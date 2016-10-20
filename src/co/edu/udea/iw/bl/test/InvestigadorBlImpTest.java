package co.edu.udea.iw.bl.test;

import static org.junit.Assert.*;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.iw.bl.InvestigadorBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("classpath:configuracion.cfg.xml"))
public class InvestigadorBlImpTest {

	@Autowired
	InvestigadorBl investigadorBl;

	static Logger LOGGER = Logger.getLogger(InvestigadorBlImpTest.class);

	@Before
	public void inicializarLogger() {
		BasicConfigurator.configure();
	}

	@Test

	public void existeInvestigador() {
		try {
			assertTrue(investigadorBl.validarInvestigador("dani01", "c9eb1d8b152704c9ebeccf8cd8706dad"));
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
	}

}
