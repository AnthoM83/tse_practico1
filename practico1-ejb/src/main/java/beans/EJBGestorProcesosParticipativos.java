package beans;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import classes.EstadoProceso;
import classes.ProcesoParticipativo;
import exceptions.ExistingEntityException;
import persistance.SingletonGestorProcesosParticipativosLocal;

@Stateless
public class EJBGestorProcesosParticipativos implements EJBGestorProcesosParticipativosRemote, EJBGestorProcesosParticipativosLocal {
	
	private @EJB SingletonGestorProcesosParticipativosLocal singletonGestorDeProcesosParticipativos;

    public EJBGestorProcesosParticipativos() {}
    
    public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo) throws ExistingEntityException {
    	procesoParticipativo.setEstado(EstadoProceso.EN_ESPERA);
    	Integer randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
    	procesoParticipativo.setId("PP" + randomNum.toString());
    	if (singletonGestorDeProcesosParticipativos.getProcesoParticipativo(procesoParticipativo.getNombre()) == null)
    		singletonGestorDeProcesosParticipativos.addProcesoParticipativo(procesoParticipativo);
    	else
    		throw new ExistingEntityException("Ya existe un proceso participativo con ese nombre.");
    }
    
    public ProcesoParticipativo getProcesoParticipativo(String nombre) {
    	return singletonGestorDeProcesosParticipativos.getProcesoParticipativo(nombre);
    }
    
    public Collection<ProcesoParticipativo> listProcesosParticipativos() {
    	return singletonGestorDeProcesosParticipativos.listProcesosParticipativos();
    }

}
