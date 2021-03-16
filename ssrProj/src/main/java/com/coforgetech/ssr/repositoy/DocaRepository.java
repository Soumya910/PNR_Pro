package com.coforgetech.ssr.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforgetech.ssr.entity.Doca;


public interface DocaRepository extends JpaRepository<Doca, Integer>{
	
    public Optional<Doca> findByAddressId(int addressId);
    
    public void deleteByAddressId(int addressId);

}
