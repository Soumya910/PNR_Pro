package com.coforgetech.ssr.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforgetech.ssr.entity.Doca;
import com.coforgetech.ssr.service.DocaService;


@RestController
@RequestMapping("/ssr")
public class SsrRestController {

	private DocaService docaService;

	@Autowired
	public SsrRestController(DocaService ssrDocaService) {
		docaService = ssrDocaService;
	}
	
	@GetMapping("/doca")
	public List<Doca> findAll(){
		
		return docaService.findAll();
	}
	
	
	// find address by doca id
	
	@GetMapping("/doca/{docaId}")
	public Doca getAddress(@PathVariable int docaId) {
		
		Doca theAddress = docaService.findByDocaId(docaId);
		
		if (theAddress == null) {
			throw new RuntimeException("Doca id not found - " + docaId);
			
		}
		
		return theAddress;
	}
	
	// create address 
	
	@PostMapping("/doca")
	public Doca addAddress(@RequestBody Doca theAddress) {
		
		docaService.save(theAddress);
		
		return theAddress;
	}
	
	@PutMapping("/doca")
	public Doca updateAddress(@RequestBody Doca docaVo) {
		
		Doca theAddress = docaService.findByDocaId(docaVo.getAddressId());
		
		if (theAddress == null) {
			throw new RuntimeException("Doca id not found - " + docaVo.getAddressId());
			
		}else{
			theAddress.setCountry(docaVo.getCountry());
			theAddress.setCountryCode(docaVo.getCountryCode());
			theAddress.setDestination(docaVo.getDestination());
			theAddress.setPassengerNo(docaVo.getPassengerNo());
			theAddress.setStreetNo(docaVo.getStreetNo());
			theAddress.setZipcode(docaVo.getZipcode());
			theAddress.setSegmentNo(docaVo.getSegmentNo());
			docaService.save(theAddress);
		}
		
		
		
		return theAddress;
	}
	
	@DeleteMapping("/doca/{docaId}")
	public String deleteEmployee(@PathVariable int docaId) {
		
		Doca address = docaService.findByDocaId(docaId);
		
		// throw exception if null
		
		if (address == null) {
			throw new RuntimeException("DOCA id not found - " + docaId);
		}
		
		docaService.deleteById(address.getId());
		return "Deleted doca id - " + docaId;
	}
	
}















