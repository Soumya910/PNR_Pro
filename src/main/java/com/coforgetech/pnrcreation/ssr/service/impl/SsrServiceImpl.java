package com.coforgetech.pnrcreation.ssr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.coforgetech.pnrcreation.pnr.vo.DOCAVO;
import com.coforgetech.pnrcreation.ssr.service.SsrService;



@Service
public class SsrServiceImpl  implements SsrService {
	
	 @Autowired
	 private RestTemplate restTemplate;
	
	 @Value("${ssr.findalldoca.details.url}")
	 private String ssrFindAllDetailsUrl;
	 
	 @Value("${ssr.findbyid.details.url}")
	 private String ssrFindByIdDetailsUrl;
	 
	 @Value("${ssr.createdoca.details.url}")
	 private String ssrCreateDocaDetailsUrl;
	 
	 @Value("${ssr.updatedoca.details.url}")
	 private String ssrUpdateDocaDetailsUrl;
	 
	 @Value("${ssr.deletedoca.details.url}")
	 private String ssrDeleteDocaDetailsUrl;

	 @Override
	 @Transactional
	 public List<DOCAVO> getAllDocaDetails() {
		 ResponseEntity<List<DOCAVO>> responseEntity = 
		 restTemplate.exchange(ssrFindAllDetailsUrl,HttpMethod.GET,null,new ParameterizedTypeReference<List<DOCAVO>>() {});
		 List<DOCAVO> docoVo = responseEntity.getBody();
		 return docoVo;
	 }


	@Override
	@Transactional
	public DOCAVO getDocaDetailsById(int addressId) {
         Map<String, Integer> param = new HashMap<>();
		 param.put("docaId",addressId);
		 DOCAVO docaVo = restTemplate.getForObject(ssrFindByIdDetailsUrl,DOCAVO.class,param);
		return docaVo;
	}


	@Override
	@Transactional
	public DOCAVO addDocaDetails(DOCAVO docaVo) {
		ResponseEntity<DOCAVO> address2 =restTemplate.postForEntity(ssrCreateDocaDetailsUrl, docaVo, DOCAVO.class);
		System.out.println(address2.getBody());
		System.out.println("Address created ...");
		return docaVo;
	}


	@Override
	@Transactional
	public DOCAVO updateDocaDetails(DOCAVO docoVo) {
		Map<String, Integer> param = new HashMap<>();
		restTemplate.put(ssrUpdateDocaDetailsUrl, docoVo, param);
		System.out.println("Address updated ....");
		return docoVo;
	}


	@Override
	@Transactional
	public void deleteDocaById(int pnrid) {
		Map<String, Integer> param = new HashMap<>();
		param.put("docaId", pnrid);
		restTemplate.delete(ssrDeleteDocaDetailsUrl,param);
		System.out.println("Address deleted ...");
		
	}
	
}
