package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.PrestamoBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@Path("ServicioPrestamo")
@Component
public class ServicioPrestamo {
	
	@Autowired
	PrestamoBl prestamoBl;

	public PrestamoBl getPrestamoBl() {
		return prestamoBl;
	}

	public void setPrestamoBl(PrestamoBl prestamoBl) {
		this.prestamoBl = prestamoBl;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("registrarPrestamo/{id}/{solicitudAsociada}/{horaEntrega}/{horaDevolucion}/{horasSolicitadas}")
	public void registrarPrestamo(int id, int solicitudAsociada, Date horaEntrega, Date horaDevolucion,
			int horasSolicitadas) throws RemoteException {
		
		try {
			prestamoBl.registrarPrestamo(id, solicitudAsociada, horaEntrega, horaDevolucion, horasSolicitadas);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		
	}

}
