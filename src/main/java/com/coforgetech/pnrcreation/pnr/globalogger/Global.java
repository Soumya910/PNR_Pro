package com.coforgetech.pnrcreation.pnr.globalogger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Global {
	
	public static Logger getLogger(Class className) {
		return LoggerFactory.getLogger(className);
	}

}
