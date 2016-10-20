package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla tab_solicitudes_prestamo.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class DetalleSolicitud {

	/* Variables de instancia global que representan las
	 * caracteristicas o atributos que posee el detalle
	 * de una solicitud.
	 */
	private SolicitudPrestamo solicitud;
	private Dispositivo dispositivoSolicitado;
	private Date horaEntrega;
	private Date horaDevolucion;
	private int horasSolicitadas;
	
	/**
	 * Constructores para un objeto de la clase DetalleSolicitud.
	 * @param solicitud - Numero de identificacion de la solicitud de prestamo asociada.
	 * @param dispositivoSolicitado - Numero de identificacion del dispositivo solicitado.
	 * @param horaEntrega - Fecha en la que se entrego el dispositivo solicitado.
	 * @param horaDevolucion - Fecha en la que se devolvio el dispositivo.
	 * @param horasSolicitadas - Numero de horas reservadas.
	 */
	public DetalleSolicitud(SolicitudPrestamo solicitud, Dispositivo dispositivoSolicitado, Date horaEntrega,
			Date horaDevolucion, int horasSolicitadas) {
		this.solicitud = solicitud;
		this.dispositivoSolicitado = dispositivoSolicitado;
		this.horaEntrega = horaEntrega;
		this.horaDevolucion = horaDevolucion;
		this.horasSolicitadas = horasSolicitadas;
	}
	
	public DetalleSolicitud() {
		
	}
	
	/* 
	 * Getters y Setters para los atributos de un objeto de la clase DetalleSolicitud.
	 */

	public SolicitudPrestamo getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(SolicitudPrestamo solicitud) {
		this.solicitud = solicitud;
	}

	public Dispositivo getDispositivoSolicitado() {
		return dispositivoSolicitado;
	}

	public void setDispositivoSolicitado(Dispositivo dispositivoSolicitado) {
		this.dispositivoSolicitado = dispositivoSolicitado;
	}

	public Date getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(Date horaEntrega) {
		this.horaEntrega = horaEntrega;
	}

	public Date getHoraDevolucion() {
		return horaDevolucion;
	}

	public void setHoraDevolucion(Date horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}

	public int getHorasSolicitadas() {
		return horasSolicitadas;
	}

	public void setHorasSolicitadas(int horasSolicitadas) {
		this.horasSolicitadas = horasSolicitadas;
	}
	
}
