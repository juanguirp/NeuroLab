package co.edu.udea.iw.exception;


import co.edu.udea.iw.test.NeuroLabLogger;

public class NeuroLabDaoException extends Exception{

	//private NeuroLabLogger LOGGER = NeuroLabLogger.obtenerLogger();
	
	public NeuroLabDaoException(String message, Throwable cause) {
		//super(message, cause);
		
		
			//LOGGER.escribirLog("*** Error de conexion: " + message);
		
		// LOGGER.error("*** Causa: " + cause);
	}

	public NeuroLabDaoException(String message) {
		//super(message);
		
		
		//LOGGER.escribirLog("*** Error de conexion: " + message);
		
	}

	public NeuroLabDaoException(Throwable cause) {
		//super(cause);
		
		
		//LOGGER.escribirLog("*** Error de conexion: " + cause);
		
	}
	
	

}
