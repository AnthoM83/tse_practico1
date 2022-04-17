package beans;

import java.util.Collection;

import javax.ejb.Local;

import datatypes.dtProcesoParticipativo;
import exceptions.ExistingEntityException;

@Local
public interface EJBGestorProcesosParticipativosLocal {
	public void addProcesoParticipativo(dtProcesoParticipativo procesoParticipativo) throws ExistingEntityException; 
	public dtProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<dtProcesoParticipativo> listProcesosParticipativos();
}
