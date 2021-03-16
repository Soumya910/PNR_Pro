package com.coforgetech;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;
import com.coforgetech.pnrcreation.pnr.repository.PnrRepository;
import com.coforgetech.pnrcreation.pnr.service.impl.PnrServiceImpl;
import com.coforgetech.pnrcreation.pnr.vo.PnrDetailsVO;



public class ServiceTest extends PnrTestConfig{
	
	@InjectMocks
	PnrServiceImpl pnrServiceImpl;

	@Mock
	PnrRepository pnrRepository;
	
	private static final PnrDetailsVO PnrEntityVo = new PnrDetailsVO();
	
	@Test
	public void saveTest(){
		PnrDetails pnrEntity = mock(PnrDetails.class);
		pnrServiceImpl.addPnrDetails(PnrEntityVo);
		verify(pnrRepository).save(pnrEntity);
	}
}
