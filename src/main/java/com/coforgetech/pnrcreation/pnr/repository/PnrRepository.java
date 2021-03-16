package com.coforgetech.pnrcreation.pnr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;


@Repository
public interface PnrRepository extends JpaRepository<PnrDetails, Integer> {
	
	 public Optional<PnrDetails> findByAddressId(int addressId);
	 
}
