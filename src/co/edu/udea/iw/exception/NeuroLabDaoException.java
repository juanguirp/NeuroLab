package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

public class NeuroLabDaoException extends Exception{

	final static Logger LOGGER = Logger.getLogger(NeuroLabDaoException.class);
	
	public NeuroLabDaoException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.error("*** Error de conexion: " + message);
		// LOGGER.error("*** Causa: " + cause);
	}

	public NeuroLabDaoException(String message) {
		super(message);
		LOGGER.error("*** Error de conexion: " + message);
	}

	public NeuroLabDaoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
