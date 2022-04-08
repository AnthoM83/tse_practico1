package beans;

import java.util.Collection;

import javax.ejb.Local;

import classes.ProcesoParticipativo;

@Local
public interface EJBGestorProcesosParticipativosLocal {
	public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo); 
	public ProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<ProcesoParticipativo> listProcesosParticipativos();
}
