package com.springau.log;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class log4jExample {

	static Logger log=LogManager.getRootLogger();
	public static void main(String[] args)
	{
		log.trace("Trace message");
		log.debug("Debug message");
		log.info("Info message");
		log.warn("Warn message");
		log.error("Error message");
		log.fatal("Fatal message");
	}
}
