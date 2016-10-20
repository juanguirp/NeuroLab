package co.edu.udea.iw.test;

import static org.junit.Assert.*;

import java.util.List;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.AdministradorDao;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:spring.cfg.xml"))
public class AdministradorDaoHibernateTest {
	
	@Autowired
	AdministradorDao administradorDao;

	private NeuroLabLogger LOGGER = NeuroLabLogger.obtenerLogger();
	
	@Test
	public void hayAdministradores() {
		List<Administrador> administradores;
		try {
			administradores = administradorDao.listarAdministradores();
			
			LOGGER.escribirLog("********* Numero de administradores: " + String.valueOf(administradores.size()));
			
			assertTrue(administradores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void verAdministradores() {
		List<Administrador> administradores;
		try {
			administradores = administradorDao.listarAdministradores();
			for(Administrador administrador : administradores){
				
				LOGGER.escribirLog("********* Nombre: " + String.valueOf(administrador.getNombre()));
				LOGGER.escribirLog("********* Apellido: " + String.valueOf(administrador.getApellidos()));
							
			}			
			assertTrue(administradores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}
	
}
