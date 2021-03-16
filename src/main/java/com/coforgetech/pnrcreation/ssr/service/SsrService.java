package com.coforgetech.pnrcreation.ssr.service;

import java.util.List;

import com.coforgetech.pnrcreation.pnr.vo.DOCAVO;


public interface SsrService {
	
	public List<DOCAVO> getAllDocaDetails();
	public DOCAVO getDocaDetailsById(int addressId);
	public DOCAVO addDocaDetails(DOCAVO emp);
	public DOCAVO updateDocaDetails(DOCAVO emp);
	public void deleteDocaById(int pnrid);

}
