package beans;

import java.util.Collection;

import javax.ejb.Remote;

import datatypes.dtProcesoParticipativo;
import exceptions.ExistingEntityException;

@Remote
public interface EJBGestorProcesosParticipativosRemote {
	public void addProcesoParticipativo(dtProcesoParticipativo procesoParticipativo) throws ExistingEntityException; 
	public dtProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<dtProcesoParticipativo> listProcesosParticipativos();
}
