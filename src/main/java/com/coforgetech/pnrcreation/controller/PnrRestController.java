package com.coforgetech.pnrcreation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;
import com.coforgetech.pnrcreation.pnr.exception.DocoIdAlreadyExistsException;
import com.coforgetech.pnrcreation.pnr.exception.PnrNotFoundException;
import com.coforgetech.pnrcreation.pnr.globalogger.Global;
import com.coforgetech.pnrcreation.pnr.repository.PnrRepository;
import com.coforgetech.pnrcreation.pnr.service.PnrService;
import com.coforgetech.pnrcreation.pnr.vo.DOCAVO;
import com.coforgetech.pnrcreation.pnr.vo.PnrDetailsVO;
import com.coforgetech.pnrcreation.ssr.service.SsrService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/pnr")
@Api(value="PNR Creation")
public class PnrRestController {
	
	private  Logger logger = Global.getLogger(PnrRestController.class);
	
	@Autowired
	private PnrService pnrService;
	
	@Autowired
	private SsrService ssrService;
	
	 @Autowired
	 private PnrRepository pnrRepository;
	 
	 @Autowired
	 private ModelMapper modelMapper;
	 
		
	@ApiOperation(value = "Create PNR in the System ")
	@ApiResponses(value = { 
	            @ApiResponse(code = 200, message = "Success|OK"),
	            @ApiResponse(code = 401, message = "not authorized!"), 
	            @ApiResponse(code = 403, message = "forbidden!!!"),
	            @ApiResponse(code = 404, message = "not found!!!") })
	@Transactional
	@PostMapping("/create")
	public ResponseEntity<PnrDetailsVO> createPnrEntity(@RequestBody PnrDetailsVO pnrDetailsVo){
		String methodName="createPnrEntity(@Valid @RequestBody PnrEntityVo pnrEntityVo))";
		logger.info(methodName + "called");
		
		if (pnrRepository.findByAddressId(pnrDetailsVo.getDoca().getAddressId()).isPresent()) {
			throw new DocoIdAlreadyExistsException(pnrDetailsVo.getDoca().getAddressId());
		}
		
		PnrDetails pnrdetails= pnrService.addPnrDetails(pnrDetailsVo);
		DOCAVO docaVo = ssrService.addDocaDetails(pnrDetailsVo.getDoca());   
		
		PnrDetailsVO pnrDetailsVO = new PnrDetailsVO();
		pnrDetailsVO = modelMapper.map(pnrdetails, PnrDetailsVO.class);
		pnrDetailsVO.setDoca(docaVo);
		return new ResponseEntity<>(pnrDetailsVO, HttpStatus.CREATED);
	}
	
	
	@ApiOperation(value = "View a list of PNR",response = Iterable.class)
	@Transactional
	@GetMapping("/get")
	public ResponseEntity<List<PnrDetailsVO>> getPnrEntity(){
		String methodName="getPnrEntity()";
		logger.info(methodName + "called");
		List<PnrDetailsVO> pnrDetailsListVO = new ArrayList<PnrDetailsVO>();
		List<PnrDetails> pnrListdetails= pnrService.getAllPnrDetails();

		List<DOCAVO> docaListdetails= ssrService.getAllDocaDetails();

		pnrListdetails.forEach(pnrDetails -> {
			docaListdetails.forEach(docadetails -> {
				if(pnrDetails.getAddressId() == docadetails.getAddressId()){
					PnrDetailsVO pnrDetailsVO = new PnrDetailsVO();
					pnrDetailsVO = modelMapper.map(pnrDetails, PnrDetailsVO.class);
					pnrDetailsVO.setDoca(docadetails);
					pnrDetailsListVO.add(pnrDetailsVO);
				}
			});

		}); 
		return new ResponseEntity<>(pnrDetailsListVO, HttpStatus.OK);
	}

	
	@ApiOperation(value = "Search a PNR with an ID",response = PnrDetails.class)
	@Transactional
	@GetMapping("/get/{pnrId}")
	public ResponseEntity<PnrDetailsVO> getPnrEntity(@PathVariable int pnrId) {
		String methodName="getPnrEntity(@PathVariable int id)";
		logger.info(methodName + "called");
		PnrDetailsVO postDto = null;
		Optional<PnrDetails> pnrDetails = pnrService.getPnrDetailsById(pnrId);

		if(pnrDetails.isPresent()){
			DOCAVO docaVo= ssrService.getDocaDetailsById(pnrDetails.get().getAddressId());
			postDto = modelMapper.map(pnrDetails.get(), PnrDetailsVO.class);
			postDto.setDoca(docaVo);
		}else{
			throw new PnrNotFoundException(pnrId);
		}

		return new ResponseEntity<>(postDto, HttpStatus.OK);

	}
	
	
	@ApiOperation(value = "Update a PNR")
	@Transactional
	@PutMapping("/update/{pnrId}")
	public ResponseEntity<PnrDetailsVO> updatePnrEntity(@PathVariable int pnrId, @RequestBody PnrDetailsVO pnrDetailsVo){
		String methodName="updatePnrEntity(@PathVariable int id, @RequestBody PnrEntityVo pnrVo)";
		logger.info(methodName + "called");
		PnrDetailsVO postDto = null;
		
		if (!pnrRepository.findById(pnrId).isPresent()) {
			throw new PnrNotFoundException(pnrId);
		}
		
		PnrDetails pnrDetails = pnrService.updatePnrDetails(pnrId, pnrDetailsVo);
		if(null!=pnrDetails){
			pnrDetailsVo.getDoca().setAddressId(pnrDetails.getAddressId());
			DOCAVO docaVo= ssrService.updateDocaDetails(pnrDetailsVo.getDoca());
			
			postDto = modelMapper.map(pnrDetails, PnrDetailsVO.class);
			postDto.setDoca(docaVo);
		}
		return new ResponseEntity<>(postDto, HttpStatus.OK);
	}
	
	
	 @ApiOperation(value = "Delete a PNR")
	 @Transactional
	 @DeleteMapping("/delete/{pnrId}")
	 public ResponseEntity<?> deletePnrEntity(@PathVariable int pnrId){
		 String methodName="deletePnrEntity(@PathVariable int id)";
			logger.info(methodName + "called");
			
			if (!pnrRepository.findById(pnrId).isPresent()) {
				throw new PnrNotFoundException(pnrId);
			}
			
			PnrDetails pnrDetails= pnrService.deletePnrById(pnrId);
			if(null!=pnrDetails){
				ssrService.deleteDocaById(pnrDetails.getAddressId());
			}
		 return new ResponseEntity(HttpStatus.NO_CONTENT);
	 }
}





