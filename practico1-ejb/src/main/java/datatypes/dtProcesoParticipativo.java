package datatypes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class dtProcesoParticipativo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private dtEstadoProceso estado;
	
	public dtProcesoParticipativo() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public dtEstadoProceso getEstado() {
		return estado;
	}

	public void setEstado(dtEstadoProceso estado) {
		this.estado = estado;
	}
	
}
