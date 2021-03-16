package com.coforgetech.ssr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforgetech.ssr.entity.Doca;
import com.coforgetech.ssr.repositoy.DocaRepository;



@Service
public class DocaServiceImpl implements DocaService {
	
	private DocaRepository docaRepository;
	
    @Autowired
	public DocaServiceImpl(DocaRepository ssrDocaRepository) {
		docaRepository = ssrDocaRepository;
	}


	@Override
	public List<Doca> findAll() {
		
		return docaRepository.findAll();
	}


	@Override
	public Doca findById(int theId) {
		
		Optional<Doca> result = docaRepository.findById(theId);
		
		Doca theAddress = null;
		
		if (result.isPresent()) {
			theAddress = result.get();
		}
		
		else {
			throw new RuntimeException("Did not find  doca id - " + theId);
		}
		return theAddress;
	}


	@Override
	public void save(Doca theAddress) {
		
		docaRepository.save(theAddress);
		
	}


	@Override
	public void deleteById(int theId) {
		docaRepository.deleteById(theId);
		
	}
	
	@Override
	public void deleteByAddressId(int docaId) {
		docaRepository.deleteByAddressId(docaId);
		
	}


	@Override
	public Doca findByDocaId(int docaId) {
		Doca theAddress = null;
		
		Optional<Doca> result = docaRepository.findByAddressId(docaId);
		if (result.isPresent()) {
			theAddress = result.get();
		}
		
		else {
			throw new RuntimeException("Did not find  doca id - " + docaId);
		}
		return theAddress;
	}
	
	
	
	

}





















