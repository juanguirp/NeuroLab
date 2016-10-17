package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

public class AdministradorDaoHibernate implements AdministradorDao {

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Administrador> listarAdministradores() throws NeuroLabDaoException {
		Session session = null;
		List<Administrador> administradores = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Administrador.class);
			administradores = criteria.list();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion:
		finally {
			if(session != null){
				session.close();
			}
		}
		*/
		return administradores;
	}

	@Override
	public Administrador obtenerAdministrador(String id) throws NeuroLabDaoException {
		Session session = null;
		Administrador administrador = null;
		
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Administrador.class).add(Restrictions.eq("adm_id", id));
			administrador = (Administrador) criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion:
		finally {
			if(session != null){
				session.close();
			}
		}
		*/
		return administrador;
	}

	@Override
	public void registrarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.save(administrador);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion:
		finally {
			if(session != null){
				session.close();
			}
		}
		*/
	}

	@Override
	public void actualizarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			session.update(administrador);
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion:
		finally {
			if(session != null){
				session.close();
			}
		}
		*/

	}

	@Override
	public void eliminarAdministrador(String id) throws NeuroLabDaoException {
		Session session = null;
		Administrador administrador = new Administrador(id, "", "", "", "");
		
		try {
			session = sessionFactory.openSession();
			session.delete(administrador);
			
		} catch (HibernateException e) {
			throw new NeuroLabDaoException(e);
		}
		/*
		 * TODO: Analizar el cierre de la sesion:
		finally {
			if(session != null){
				session.close();
			}
		}
		*/

	}

}
