package com.coforgetech.ssr.service;

import java.util.List;

import com.coforgetech.ssr.entity.Doca;


public interface DocaService {
	
	public List<Doca> findAll();
	
	public Doca findById(int theId);
	
	public void save(Doca theAddress);
	
	public void deleteById(int theId);
	
	public Doca findByDocaId(int docaId);
	
	public void deleteByAddressId(int docaId); 

}
