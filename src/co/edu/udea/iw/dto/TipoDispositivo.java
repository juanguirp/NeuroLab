package co.edu.udea.iw.dto;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla tab_tipos_dispositivo.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class TipoDispositivo {
	
	/* Variables de instancia global que representan las
	 * caracteristicas o atributos que posee un tipo de dispositivo.
	 */
	private String id;
	private String clase;
	
	/**
	 * Constructor para un objeto de la clase TipoDispositivo.
	 * @param id - Codigo que identifica un tipo de dispositivo.
	 * @param clase - Nombre de la clase o categoria a la que pertenece un tipo de dispositivo.
	 */
	public TipoDispositivo(String id, String clase) {
		super();
		this.id = id;
		this.clase = clase;
	}
	
	/* 
	 * Getters y Setters para los atributos de un tipo de dispositivo.
	 */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getClase() {
		return clase;
	}
	
	public void setClase(String clase) {
		this.clase = clase;
	}
	
}
