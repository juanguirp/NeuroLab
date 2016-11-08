package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.SolicitudPrestamoBl;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

@Path("ServicioSolicitudPrestamo")
@Component
public class ServicioSolicitudPrestamo {
	
	@Autowired
	SolicitudPrestamoBl solicitudPrestamoBl;

	public SolicitudPrestamoBl getSolicitudPrestamoBl() {
		return solicitudPrestamoBl;
	}

	public void setSolicitudPrestamoBl(SolicitudPrestamoBl solicitudPrestamoBl) {
		this.solicitudPrestamoBl = solicitudPrestamoBl;
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarSolicitudesPrestamo")
	public List<SolicitudPrestamo> listarSolicitudes() throws RemoteException {
		
		List<SolicitudPrestamo> solicitudesPrestamo = null;
		try{
			solicitudesPrestamo = solicitudPrestamoBl.listarSolicitudes();
		}catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		return solicitudesPrestamo;
	}
	
	

}
