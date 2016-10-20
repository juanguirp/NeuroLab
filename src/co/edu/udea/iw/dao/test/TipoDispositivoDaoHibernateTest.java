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

import co.edu.udea.iw.dao.TipoDispositivoDao;
import co.edu.udea.iw.dto.TipoDispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class TipoDispositivoDaoHibernateTest {

	@Autowired
	TipoDispositivoDao tipoDispositivoDao;	
	
	static Logger LOGGER = Logger.getLogger(TipoDispositivoDaoHibernateTest.class);
	
	@Before
	public void inicializarLogger(){
		BasicConfigurator.configure();
	}
	
	@Test
	public void verTiposDispositivo() {
		List<TipoDispositivo> tiposDispositivo;
		try {
			tiposDispositivo = tipoDispositivoDao.listarTiposDispositivo();
			for(TipoDispositivo tipoDispositivo : tiposDispositivo){
				
				LOGGER.debug("********* Id: " + String.valueOf(tipoDispositivo.getId()));
				LOGGER.debug("********* Clase: " + String.valueOf(tipoDispositivo.getClase()));
			}			
			assertTrue(tiposDispositivo.size() > 0);
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
