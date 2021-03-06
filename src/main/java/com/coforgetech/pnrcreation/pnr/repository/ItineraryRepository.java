package com.coforgetech.pnrcreation.pnr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforgetech.pnrcreation.pnr.entity.Itinerary;


@Repository
public interface ItineraryRepository extends JpaRepository<Itinerary, Integer> {

}
