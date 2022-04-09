package persistance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import classes.EstadoProceso;
import classes.ProcesoParticipativo;

@Startup
@Singleton
public class SingletonGestorProcesosParticipativos implements SingletonGestorProcesosParticipativosRemote, SingletonGestorProcesosParticipativosLocal {

	private Map<String, ProcesoParticipativo> procesosParticipativos = new HashMap<>();

    public SingletonGestorProcesosParticipativos() {}
    
    @PostConstruct
    private void initialize() {
    	ProcesoParticipativo p1 = new ProcesoParticipativo();
    	p1.setNombre("Plan Nacional de Acción en Derechos Humanos");
    	p1.setId("PP10452");
    	p1.setEstado(EstadoProceso.EN_PROGRESO);
    	p1.setFechaInicio(LocalDate.parse("2021-03-01"));
    	p1.setFechaFin(LocalDate.parse("2024-12-30"));
    	ProcesoParticipativo p2 = new ProcesoParticipativo();
    	p2.setNombre("Consulta pública: 5to Plan de Acción Nacional de Gobierno Abierto");
    	p2.setId("PP34393");
    	p2.setEstado(EstadoProceso.FINALIZADO);
    	p2.setFechaInicio(LocalDate.parse("2021-03-10"));
    	p2.setFechaFin(LocalDate.parse("2021-12-15"));
    	ProcesoParticipativo p3 = new ProcesoParticipativo();
    	p3.setNombre("¿Qué Reglamento del Servicio de Radioaficionados queremos?");
    	p3.setId("PP46891");
    	p3.setEstado(EstadoProceso.FINALIZADO);
    	p3.setFechaInicio(LocalDate.parse("2021-08-23"));
    	p3.setFechaFin(LocalDate.parse("2021-12-13"));
    	procesosParticipativos.put(p1.getNombre(), p1);
    	procesosParticipativos.put(p2.getNombre(), p2);
    	procesosParticipativos.put(p3.getNombre(), p3);
    }
    
    public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo) {
    	procesosParticipativos.put(procesoParticipativo.getNombre(), procesoParticipativo);
    }
    
    public ProcesoParticipativo getProcesoParticipativo(String nombre) {
    	return procesosParticipativos.get(nombre);
    }
    
    public Collection<ProcesoParticipativo> listProcesosParticipativos() {
    	return new ArrayList<ProcesoParticipativo>(procesosParticipativos.values());
    }
    
 

}
