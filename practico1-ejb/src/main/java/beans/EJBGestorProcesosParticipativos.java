package beans;

import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import datatypes.dtEstadoProceso;
import datatypes.dtProcesoParticipativo;
import entities.EstadoProceso;
import entities.ProcesoParticipativo;
import exceptions.ExistingEntityException;
import persistance.SingletonGestorProcesosParticipativosLocal;

@Stateless
public class EJBGestorProcesosParticipativos implements EJBGestorProcesosParticipativosRemote, EJBGestorProcesosParticipativosLocal {
	
	private @EJB SingletonGestorProcesosParticipativosLocal singletonGestorDeProcesosParticipativos;

    public EJBGestorProcesosParticipativos() {}
    
    public void addProcesoParticipativo(dtProcesoParticipativo dtpp) throws ExistingEntityException {
    	ProcesoParticipativo proceso = new ProcesoParticipativo();
    	proceso.setNombre(dtpp.getNombre());
    	proceso.setFechaInicio(dtpp.getFechaInicio());
    	proceso.setFechaFin(dtpp.getFechaFin());
    	proceso.setEstado(EstadoProceso.EN_ESPERA);
    	if (singletonGestorDeProcesosParticipativos.getProcesoParticipativo(proceso.getNombre()) == null)
    		singletonGestorDeProcesosParticipativos.addProcesoParticipativo(proceso);
    	else
    		throw new ExistingEntityException("Ya existe un proceso participativo con ese nombre.");
    }
    
    public dtProcesoParticipativo getProcesoParticipativo(String nombre) {
    	ProcesoParticipativo proceso = singletonGestorDeProcesosParticipativos.getProcesoParticipativo(nombre);
    	dtProcesoParticipativo dtpp = new dtProcesoParticipativo();
    	dtpp.setNombre(proceso.getNombre());
    	dtpp.setFechaInicio(proceso.getFechaInicio());
    	dtpp.setFechaFin(proceso.getFechaFin());
    	dtpp.setEstado(dtEstadoProceso.fromValue(proceso.getEstado().toString()));
    	return dtpp;
    }
    
    public Collection<dtProcesoParticipativo> listProcesosParticipativos() {
    	ArrayList<ProcesoParticipativo> listProcesos = new ArrayList<>(singletonGestorDeProcesosParticipativos.listProcesosParticipativos());
    	ArrayList<dtProcesoParticipativo> listDtpp = new ArrayList<>();
    	for (ProcesoParticipativo proceso : listProcesos) {
    		dtProcesoParticipativo dtpp = new dtProcesoParticipativo();
        	dtpp.setNombre(proceso.getNombre());
        	dtpp.setFechaInicio(proceso.getFechaInicio());
        	dtpp.setFechaFin(proceso.getFechaFin());
        	dtpp.setEstado(dtEstadoProceso.fromValue(proceso.getEstado().toString()));
    		listDtpp.add(dtpp);
    	}
        return listDtpp;
    }

}
