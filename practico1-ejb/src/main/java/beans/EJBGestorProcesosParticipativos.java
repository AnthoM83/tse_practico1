package beans;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import classes.EstadoProceso;
import classes.ProcesoParticipativo;
import persistance.SingletonGestorProcesosParticipativosLocal;

@Stateless
public class EJBGestorProcesosParticipativos implements EJBGestorProcesosParticipativosRemote, EJBGestorProcesosParticipativosLocal {
	
	private @EJB SingletonGestorProcesosParticipativosLocal singletonGestorDeProcesosParticipativos;

    public EJBGestorProcesosParticipativos() {}
    
    public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo) {
    	procesoParticipativo.setEstado(EstadoProceso.EN_ESPERA);
    	procesoParticipativo.setFechaFin(null);
    	Integer randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
    	procesoParticipativo.setId("PP" + randomNum.toString());
    	singletonGestorDeProcesosParticipativos.addProcesoParticipativo(procesoParticipativo);
    }
    
    public ProcesoParticipativo getProcesoParticipativo(String nombre) {
    	return singletonGestorDeProcesosParticipativos.getProcesoParticipativo(nombre);
    }
    
    public Collection<ProcesoParticipativo> listProcesosParticipativos() {
    	return singletonGestorDeProcesosParticipativos.listProcesosParticipativos();
    }

}
