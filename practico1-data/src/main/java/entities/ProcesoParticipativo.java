package entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProcesoParticipativo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private EstadoProceso estado;
	
	public ProcesoParticipativo() {
		super();
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public EstadoProceso getEstado() {
		return estado;
	}
	public void setEstado(EstadoProceso estado) {
		this.estado = estado;
	}

}
