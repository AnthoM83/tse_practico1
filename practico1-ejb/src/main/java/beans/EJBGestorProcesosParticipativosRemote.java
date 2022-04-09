package beans;

import java.util.Collection;

import javax.ejb.Remote;

import classes.ProcesoParticipativo;
import exceptions.ExistingEntityException;

@Remote
public interface EJBGestorProcesosParticipativosRemote {
	public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo) throws ExistingEntityException; 
	public ProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<ProcesoParticipativo> listProcesosParticipativos();
}
