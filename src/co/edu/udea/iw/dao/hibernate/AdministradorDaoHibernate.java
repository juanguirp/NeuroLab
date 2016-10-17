package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrador obtenerAdministrador(String id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarAdministrador(Administrador administrador) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarAdministrador(String id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

}
