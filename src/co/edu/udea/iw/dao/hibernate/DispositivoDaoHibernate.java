package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.DispositivoDao;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla
 * tab_dispositivos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class DispositivoDaoHibernate implements DispositivoDao {

	/*
	 * Variables de instancia global.
	 */
	private SessionFactory sessionFactory;

	/*
	 * Getters y Setters para los atributos de la clase.
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Metodos implementados de la interface.
	 */

	/**
	 * Entrega una lista con los dispositivos en la base de datos.
	 * 
	 * @return lista de dispositivos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.DispositivoDao#listarDispositivos()
	 */
	@Override
	public List<Dispositivo> listarDispositivos() throws NeuroLabDaoException {
		Session session = null;
		List<Dispositivo> dispositivos = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class);
			dispositivos = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return dispositivos;
	}

	/**
	 * Entrega los datos de un dispositivo dado su identificador.
	 * 
	 * @param id
	 *            - Identificador de un dispositivo.
	 * @return DTO de un dispositivo con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.DispositivoDao#obtenerDispositivo(int)
	 */
	@Override
	public Dispositivo obtenerDispositivo(int id) throws NeuroLabDaoException {

		Dispositivo dispositivo = null;

		try {
			List<Dispositivo> dispositivos = listarDispositivos();
			dispositivo = dispositivos.get(0);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return dispositivo;
	}

	/**
	 * Permite crear un nuevo dispositivo y registrarlo en la base de datos.
	 * 
	 * @param administrador
	 *            - DTO con los datos del dispositivo a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.DispositivoDao#registrarDispositivo(co.edu.udea.iw.dto.Dispositivo)
	 */
	@Override
	public void registrarDispositivo(Dispositivo dispositivo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.save(dispositivo);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

}
