package co.edu.udea.iw.test;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class NeuroLabLogger {
	
	private static NeuroLabLogger logger = null;
	
	private static Logger LOGGER = null;
	
	private NeuroLabLogger(){
		BasicConfigurator.configure();
		LOGGER = Logger.getLogger(NeuroLabLogger.class);
	}
	
	public static NeuroLabLogger obtenerLogger(){
		if(logger == null){
			logger = new NeuroLabLogger();
		}
		return logger;
	}
	
	public void escribirLog(Object mensaje){
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("********* " + String.valueOf(mensaje));
		}		
	}

}
