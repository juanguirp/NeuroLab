package co.edu.udea.iw.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.ClienteBl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.ws.dto.ClienteWs;

@Path("ServicioCliente")
@Component
public class ServicioCliente {

	@Autowired
	ClienteBl clienteBl;

	public ClienteBl getClienteBl() {
		return clienteBl;
	}

	public void setClienteBl(ClienteBl clienteBl) {
		this.clienteBl = clienteBl;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteWs> obtener() throws RemoteException {
		List<ClienteWs> resultado = new ArrayList<>();
		List<Cliente> datos = null;

		try {
			datos = clienteBl.obtener();
			for (Cliente cliente : datos) {
				ClienteWs clienteWs = new ClienteWs(cliente.getNombres(), cliente.getApellidos(), cliente.getCedula(),
						cliente.getEmail());
				resultado.add(clienteWs);
			}
		} catch (MyDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
		return resultado;
	}

	@POST
	@Path("guardar/{cedula}/{nombre}")
	public void guardar(
			@QueryParam("cedula") String cedula,
			@QueryParam("nombre") String nombre,
			@QueryParam("apellido") String apellido,
			@QueryParam("email") String email,
			@QueryParam("usuariocrea") String usuarioCrea)
			throws RemoteException {
		try {

			clienteBl.crearCliente(cedula, nombre, apellido, email, usuarioCrea);

		} catch (MyDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}
	}
}