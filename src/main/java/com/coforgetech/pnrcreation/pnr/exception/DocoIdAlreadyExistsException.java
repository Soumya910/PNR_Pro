package com.coforgetech.pnrcreation.pnr.exception;

public class DocoIdAlreadyExistsException extends RuntimeException {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 3269388729683924286L;

	public DocoIdAlreadyExistsException(int addressId) {
	        super("Doco Id already exists : '" + addressId + "'");
	    }

}
