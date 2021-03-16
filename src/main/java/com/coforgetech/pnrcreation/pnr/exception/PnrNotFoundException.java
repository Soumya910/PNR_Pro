package com.coforgetech.pnrcreation.pnr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PnrNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1432804608919715443L;

	public PnrNotFoundException(int pnrId) {
		  super("could not find the pnr: '" + pnrId + "'");
	  }
	
	

}
