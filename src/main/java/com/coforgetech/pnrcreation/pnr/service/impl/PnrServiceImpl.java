package com.coforgetech.pnrcreation.pnr.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;
import com.coforgetech.pnrcreation.pnr.globalogger.Global;
import com.coforgetech.pnrcreation.pnr.repository.PnrRepository;
import com.coforgetech.pnrcreation.pnr.service.PnrService;
import com.coforgetech.pnrcreation.pnr.vo.PnrDetailsVO;



@Service
public class PnrServiceImpl implements PnrService{
	
	private Logger logger = Global.getLogger(PnrServiceImpl.class);
	
	 @Autowired
	 private PnrRepository repository;
	 
	 @Autowired
	 private ModelMapper modelMapper;
	 
	@Override
	public List<PnrDetails> getAllPnrDetails() {
		return repository.findAll();
	}

	@Override
	public Optional<PnrDetails> getPnrDetailsById(int pnrid) {
		return repository.findById(pnrid);
	}

	@Override
	public PnrDetails addPnrDetails(PnrDetailsVO pnrDetailsVo) {
		String methodName="createPnrEntity(pnrDetailsVo pnrDetailsVo)";
		logger.info(methodName + "called");
		 
		PnrDetails pnrDetails = modelMapper.map(pnrDetailsVo, PnrDetails.class);
		pnrDetails.setCreatedDate(new Date());
		pnrDetails.setAddressId(pnrDetailsVo.getDoca().getAddressId());                                                               
	    PnrDetails savedPnr = repository.save(pnrDetails);
		 
		if (repository.findById(savedPnr.getId()).isPresent()) {
		return savedPnr;	
		}else {
			return null;
		}
	}

	@Override
	public PnrDetails updatePnrDetails(int pnrId, PnrDetailsVO pnrDetailsVo) {
		PnrDetails pnrDbDetails = null;
		PnrDetails pnrDetails = null;
		 String methodName="updatePnrEntity(int id, PnrEntity pnr)";
			logger.info(methodName + "called");
		
		if (repository.findById(pnrId).isPresent()) {
			
			pnrDbDetails =  repository.findById(pnrId).orElse(null);
			
			pnrDetails = modelMapper.map(pnrDetailsVo, PnrDetails.class);
			pnrDetails.setId(pnrDbDetails.getId());
			pnrDetails.setAddressId(pnrDbDetails.getAddressId());
			pnrDetails.getItinerary().setId(pnrDbDetails.getItinerary().getId());
			pnrDetails.setCreatedDate(new Date());
			PnrDetails savedpnrEntity= repository.save(pnrDetails);
			
			if(repository.findById(savedpnrEntity.getId()).isPresent()) {
				return savedpnrEntity;
			}
			
			 else 
				 return null;
			
			
		}
		
		else return null;
	}

	@Override
	public PnrDetails deletePnrById(int pnrId) {
		PnrDetails pnrDetails = null;
		if(repository.findById(pnrId).isPresent()) {
			pnrDetails = repository.findById(pnrId).orElse(null);
			repository.deleteById(pnrId);
		}
		return pnrDetails;
	}

	
	
}
