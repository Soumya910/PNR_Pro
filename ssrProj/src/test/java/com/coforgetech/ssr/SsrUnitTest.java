package com.coforgetech.ssr;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.coforgetech.ssr.entity.Doca;
import com.coforgetech.ssr.repositoy.DocaRepository;
import com.coforgetech.ssr.service.DocaServiceImpl;

public class SsrUnitTest extends SsrTestConfig {
	

	@InjectMocks
	DocaServiceImpl docaServiceImpl;
	
	@Mock
	DocaRepository docaRepository;
	
	@Mock
	Doca doca;
	
	private static final int pnrId= 47;

	@Test
	public void getAllTest() throws Exception {
		docaServiceImpl.findAll();
		verify(docaRepository).findAll();
	}
	
    @Test
	public void saveTest() throws Exception {
    	Doca doca = mock(Doca.class);
		docaServiceImpl.save(doca);
		verify(docaRepository).save(doca);
	}
    
    @Test
    public void updateTest() throws Exception {
    	
    	Doca doca = mock(Doca.class);
    	docaServiceImpl.save(doca);
    	verify(docaRepository).save(doca);
    }
    
    @Test
    public void deleteTest() throws Exception {
    	
    	docaServiceImpl.deleteById(pnrId);
    	verify(docaRepository).deleteById(pnrId);
    }

}
