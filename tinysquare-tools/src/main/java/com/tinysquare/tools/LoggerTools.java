package com.tinysquare.tools;

import org.apache.log4j.Logger;

public class LoggerTools {

	public static void debug(Logger logger, Object message) {
		if (logger.isDebugEnabled()) {
			logger.debug(message);
		}
	}

}
