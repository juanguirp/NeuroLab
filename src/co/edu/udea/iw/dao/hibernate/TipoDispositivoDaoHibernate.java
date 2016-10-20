package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.iw.dao.TipoDispositivoDao;
import co.edu.udea.iw.dto.TipoDispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla tab_tipos_dispositivos.
 * @author Juan Fernando Moreno
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class TipoDispositivoDaoHibernate implements TipoDispositivoDao {

	/* Variables de instancia global.
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
	
	/*
	 * Entrega una lista con los tipos de dispositivos en la base de datos.
	 * @see co.edu.udea.iw.dao.TipoDispositivoDao#listarTiposDispositivo()
	 */
	@Override
	public List<TipoDispositivo> listarTiposDispositivo() throws NeuroLabDaoException {
		Session session = null;
		List<TipoDispositivo> tiposDispositivo = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TipoDispositivo.class);
			tiposDispositivo = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return tiposDispositivo;
	}

	/*
	 * Entrega la clase o nombre de un tipo de dispositivo dado su identificador.
	 * @see co.edu.udea.iw.dao.TipoDispositivoDao#obtenerClase(java.lang.String)
	 */
	@Override
	public TipoDispositivo obtenerClase(String id) throws NeuroLabDaoException {
		Session session = null;
		TipoDispositivo tipoDispositivo = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TipoDispositivo.class).add(Restrictions.eq("tip_id", id));
			tipoDispositivo = (TipoDispositivo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return tipoDispositivo;
	}

	/*
	 * Permite crear un nuevo tipo de dispositivo y registrarlo en la base de datos.
	 * @see co.edu.udea.iw.dao.TipoDispositivoDao#registrarTipoDispositivo(co.edu.udea.iw.dto.TipoDispositivo)
	 */
	@Override
	public void registrarTipoDispositivo(TipoDispositivo tipoDispositivo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.save(tipoDispositivo);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

	/*
	 * Actualiza la informacion de un tipo de dispositivo en la base de datos.
	 * @see co.edu.udea.iw.dao.TipoDispositivoDao#actualizarTipoDispositivo(co.edu.udea.iw.dto.TipoDispositivo)
	 */
	@Override
	public void actualizarTipoDispositivo(TipoDispositivo tipoDispositivo) throws NeuroLabDaoException {
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.update(tipoDispositivo);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

	/*
	 * Permite eliminar un tipo de dispositivo de la base de datos.
	 * @see co.edu.udea.iw.dao.TipoDispositivoDao#eliminarTipoDispositivo(java.lang.String)
	 */
	@Override
	public void eliminarTipoDispositivo(String id) throws NeuroLabDaoException {
		Session session = null;
		TipoDispositivo tipoDispositivo = new TipoDispositivo(id, "");

		try {
			session = sessionFactory.openSession();
			session.delete(tipoDispositivo);

		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */

	}

}
