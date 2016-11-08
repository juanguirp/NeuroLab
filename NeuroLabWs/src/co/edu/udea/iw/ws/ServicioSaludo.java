package co.edu.udea.iw.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * Clase que respondera a las peticiones web  para la funcionalidad de saludar. Ejercicio de clase.
 * @author Laura Martinez Londoño
 */
@Path("Saludo")
public class ServicioSaludo {

	/**
	 * Metodo sencillo para el primer saludo.
	 * @return 
	 */
	@GET
	@Produces("text/html")
	public String saludar(){
		return "Buenas tardes";
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola/{nombre}")
	public String digameHola(@PathParam("nombre") String nombre){
		return "Hola " + nombre;
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("hola2/{nombre}")
	public String digameHola2(@QueryParam("nombre") String nombre){
		return "Hola " + nombre;
	}
	
}

// http://localhost:8080/EjemploJersey/rest/Saludo

//http://localhost:11901/EjemploJersey/rest/ServicioCliente/


/*
 * 1- Deployment Assembly
 * -> configurar librerias
 * 
 * 2- Copiar las librerias en web-inf / lib
 */
