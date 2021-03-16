package com.coforgetech;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.coforgetech.pnrcreation.controller.PnrRestController;
import com.coforgetech.pnrcreation.pnr.entity.Itinerary;
import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;
import com.coforgetech.pnrcreation.pnr.repository.ItineraryRepository;
import com.coforgetech.pnrcreation.pnr.repository.PnrRepository;
import com.coforgetech.pnrcreation.pnr.service.impl.PnrServiceImpl;


public class PnrUnitTest extends PnrTestConfig {
	
	@Mock
	private PnrServiceImpl pnrservice;

	@InjectMocks
	PnrRestController pnrRestController;
  
    @InjectMocks
	PnrServiceImpl pnrServiceImpl;
	
	@MockBean
	private PnrRepository pnrRepository;
	
	@MockBean
	private ItineraryRepository itineraryRepository;
	

    @Test
    public void testDeletePnrEntity() throws Exception {
    	Itinerary itinerary = new Itinerary("AB", 235, "Z", new Date(), "DFW", "AME", 1);
    	PnrDetails existingPnr = new PnrDetails(1,"mayank","agarwal",new Date(),"8123456376","TAW/30APR", "mayank",5,itinerary);
    	pnrRepository.delete(existingPnr);
    	verify(pnrRepository,times(1)).delete(existingPnr);

    }
    
    @Test
    public void testGetById() {
    	Itinerary itinerary = new Itinerary("AB", 235, "Z", new Date(), "DFW", "AME", 1);	
    	PnrDetails existingPnr = new PnrDetails(1,"mayank","agarwal",new Date(),"8123456376","TAW/30APR", "mayank",5,itinerary);
        when(pnrRepository.findById(1)).thenReturn(Optional.of(existingPnr));
    }
    
    @Test
    public void testGetAllPnrDetails() {
    	Page<PnrDetails> tasks = Mockito.mock(Page.class);
    	Mockito.when(this.pnrRepository.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn(tasks);
    }

}
