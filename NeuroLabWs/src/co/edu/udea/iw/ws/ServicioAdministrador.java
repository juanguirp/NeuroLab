package co.edu.udea.iw.ws;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.bl.AdministradorBl;
import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.ws.dto.AdministradorWs;

@Path("ServicioAdministrador")
@Component
public class ServicioAdministrador {

	@Autowired
	AdministradorBl administradorBl;

	public AdministradorBl getAdministradorBl() {
		return administradorBl;
	}

	public void setAdministradorBl(AdministradorBl administradorBl) {
		this.administradorBl = administradorBl;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("validarAdministrador/{id}/{contrasena}")
	public boolean validarAdministrador(@PathParam("id") String id,
			@PathParam("contrasena") String contrasena) 
					throws RemoteException{
		
		boolean esAdminValido = false;
		AdministradorWs administradorWs = null;
		Administrador administrador = null;
		
		try {
			esAdminValido = administradorBl.validarAdministrador(id, contrasena);
		} catch (NeuroLabDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		
		return esAdminValido;
	}

}
