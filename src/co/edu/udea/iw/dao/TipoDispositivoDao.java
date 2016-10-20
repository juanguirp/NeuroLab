package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.TipoDispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Interface que define los metodos para acceder a la tabla tab_investigadores.
 * @author Juan Fernando Moreno
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public interface TipoDispositivoDao {
	
	/**
	 * Entrega una lista con los tipos de dispositivos en la base de datos. 
	 * @return lista de tipos de dispositivos.
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public List<TipoDispositivo> listarTiposDispositivo() throws NeuroLabDaoException;
	
	/**
	 * Entrega el nombre de un tipo de dispositivo dado su identificador.
	 * @param id - Identificador de un tipo de dispositivo.
	 * @return DTO de un tipo de dispositivo con sus datos.
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public TipoDispositivo obtenerClase(String id) throws NeuroLabDaoException;	
	
	/**
	 * Permite crear un nuevo tipo de dispositivo y registrarlo en la base de datos.
	 * @param administrador - DTO con los datos del tipo de dispositivo a guardar. 
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public void registrarTipoDispositivo(TipoDispositivo tipoDispositivo) throws NeuroLabDaoException;
	
	/**
	 * Actualiza la informacion de un tipo de dispositivo en la base de datos.
	 * @param administrador - DTO con los datos del tipo de dispositivo a modificar.
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public void actualizarTipoDispositivo(TipoDispositivo tipoDispositivo) throws NeuroLabDaoException;
	
	/**
	 * Permite eliminar un tipo de dispositivo de la base de datos.
	 * @param id - Identificador de un tipo de dispositivo.
	 * @throws NeuroLabDaoException cuando hay algun problema en la conexion.
	 */
	public void eliminarTipoDispositivo(String id) throws NeuroLabDaoException;

}
