package beans;

import java.util.Collection;

import javax.ejb.Remote;

import classes.ProcesoParticipativo;

@Remote
public interface EJBGestorProcesosParticipativosRemote {
	public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo); 
	public ProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<ProcesoParticipativo> listProcesosParticipativos();
}
