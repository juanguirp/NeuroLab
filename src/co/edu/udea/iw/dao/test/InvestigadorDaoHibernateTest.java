package co.edu.udea.iw.dao.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.dao.InvestigadorDao;
import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class InvestigadorDaoHibernateTest {
	
	@Autowired
	InvestigadorDao investigadorDao;
	
	static Logger LOGGER = Logger.getLogger(InvestigadorDaoHibernateTest.class);
	
	@Before
	public void inicializarLogger(){
		BasicConfigurator.configure();
	}

	@Test
	public void hayInvestigadores() {
		List<Investigador> investigadores;
		try {
			investigadores = investigadorDao.listarInvestigadores();
			
			LOGGER.debug("********* Numero de investigadores: " + String.valueOf(investigadores.size()));
			
			assertTrue(investigadores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void verInvestigadores() {
		List<Investigador> investigadores;
		try {
			investigadores = investigadorDao.listarInvestigadores();
			for(Investigador investigador : investigadores){
				
				LOGGER.debug("********* Nombre: " + String.valueOf(investigador.getNombre()));
				LOGGER.debug("********* Apellido: " + String.valueOf(investigador.getApellidos()));
							
			}			
			assertTrue(investigadores.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
