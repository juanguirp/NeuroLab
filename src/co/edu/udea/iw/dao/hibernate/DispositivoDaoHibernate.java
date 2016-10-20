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
 * Implementacion de la interface que permite acceder a la tabla tab_dispositivos.
 * @author Juan Fernando Moreno
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class DispositivoDaoHibernate implements DispositivoDao {
	
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

	
	/**
	 * Entrega una lista con los dispositivos en la base de datos. 
	 * @return lista de dispositivos.
	 * @throws NeuroLabDaoException
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

	@Override
	public Dispositivo obtenerDispositivo(int id) throws NeuroLabDaoException {
		Session session = null;
		Dispositivo dispositivo = null;

		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Dispositivo.class).add(Restrictions.eq("dis_id", id));
			dispositivo = (Dispositivo) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion: finally { if(session != null){
		 * session.close(); } }
		 */
		return dispositivo;
	}

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
