package co.edu.udea.iw.ws;

import java.rmi.RemoteException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.iw.bl.InvestigadorBl;
import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.ws.dto.InvestigadoWs;

/**
 * Clase que implementa los servicios rest para un investigador
 * @author Juan Fernando Moreno juan.moreno1@udea.edu.co
 *
 */
@Path("ServicioInvestigador")
@Component
public class ServicioInvestigador {

		@Autowired
		InvestigadorBl investigadorbl;

		public InvestigadorBl getInvestigadorbl() {
			return investigadorbl;
		}

		public void setInvestigadorbl(InvestigadorBl investigadorbl) {
			this.investigadorbl = investigadorbl;
		}
		
		/**
		 * clase que valida si existe el investigador.
		 * @param id
		 * @param contrasena
		 * @return true si existe, false si no existe
		 * @throws RemoteException
		 */
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("validarUsuario/{id}/{contrasena}")
		public boolean validar(@PathParam("id") String id, @PathParam("contrasena") String contrasena) throws RemoteException{
			
			boolean investigador = false;
			
			try {
				investigador = investigadorbl.validarInvestigador(id, contrasena);
				
			} catch (NeuroLabDaoException e) {
				throw new RemoteException(e.getMessage(), e);
			}
			
			return investigador;
		}
		
		/**
		 * Clase que crea un nuevo investigador pasandole los parametros que son necesarios para crear este por pathparam.
		 * @param id
		 * @param nombre
		 * @param apellidos
		 * @param correo
		 * @param contrasena
		 * @return La id y contraseņa del investigador si se a creado exitosamente
		 * @throws RemoteException
		 */
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Path("registrarInvesigador/{id}/{nombre}/{apellidos}/{correo}/{contrasena}")
		public InvestigadoWs crearInvestigador(@PathParam("id")String id, @PathParam("nombre")String nombre, @PathParam("apellidos")String apellidos, 
				@PathParam("correo") String correo, @PathParam("contrasena")String contrasena)
				throws RemoteException {

			InvestigadoWs investigadorWs = null;
			boolean investigador = false;

			try {
				investigador = investigadorbl.validarInvestigador(id, contrasena);
				if(investigador== true){
					
					investigadorWs = new InvestigadoWs();
					investigadorWs.setNombre(nombre);
					investigadorWs.setApellidos(apellidos);
					investigadorWs.setCorreo(correo);
					investigadorWs.setId(id);
					investigadorWs.setContrasena(contrasena);
				}
				
				

			} catch (NeuroLabDaoException e) {
				throw new RemoteException(e.getMessage(), e);
			}
			
			return investigadorWs;

		}
		
			
		
}
