package co.edu.udea.iw.ws;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.UsuarioBl;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyDaoException;
import co.edu.udea.iw.ws.dto.UsuarioWs;

@Path("ServicioUsuario")
@Component
public class ServicioUsuario {

	@Autowired
	UsuarioBl usuarioBl;

	public UsuarioBl getUsuarioBl() {
		return usuarioBl;
	}

	public void setUsuarioBl(UsuarioBl usuarioBl) {
		this.usuarioBl = usuarioBl;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("validarUsuario/{login}/{pwd}")
	public UsuarioWs validarUsuario(@PathParam("login") String login, @PathParam("pwd") String pwd)
			throws RemoteException {

		UsuarioWs usuarioWs = null;
		Usuario usuario = null;

		try {
			usuario = usuarioBl.validar(login, pwd);
			usuarioWs = new UsuarioWs();
			usuarioWs.setNombres(usuario.getNombres());
			usuarioWs.setApellidos(usuario.getApellidos());
			usuarioWs.setLogin(usuario.getLogin());
			usuarioWs.setContrasena(usuario.getContrasena());

		} catch (MyDaoException e) {
			throw new RemoteException(e.getMessage(), e);
		}

		return usuarioWs;
	}

}
