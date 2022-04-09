package beans;

import java.util.Collection;

import javax.ejb.Local;

import classes.ProcesoParticipativo;
import exceptions.ExistingEntityException;

@Local
public interface EJBGestorProcesosParticipativosLocal {
	public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo) throws ExistingEntityException; 
	public ProcesoParticipativo getProcesoParticipativo(String nombre);
	public Collection<ProcesoParticipativo> listProcesosParticipativos();
}
