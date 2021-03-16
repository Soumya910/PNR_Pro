package com.coforgetech.pnrcreation.pnr.service;

import java.util.List;
import java.util.Optional;

import com.coforgetech.pnrcreation.pnr.entity.PnrDetails;
import com.coforgetech.pnrcreation.pnr.vo.PnrDetailsVO;


public interface PnrService {
	
	public List<PnrDetails> getAllPnrDetails();
	public Optional<PnrDetails> getPnrDetailsById(int pnrid);
	public PnrDetails addPnrDetails(PnrDetailsVO emp);
	public PnrDetails updatePnrDetails(int pnrId,PnrDetailsVO pnrDetailsVo);
	public PnrDetails deletePnrById(int pnrid);

}
