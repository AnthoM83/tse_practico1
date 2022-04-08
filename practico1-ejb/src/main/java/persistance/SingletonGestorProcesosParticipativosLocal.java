package persistance;

import java.util.Collection;

import javax.ejb.Local;

import classes.ProcesoParticipativo;

@Local
public interface SingletonGestorProcesosParticipativosLocal {
    public void addProcesoParticipativo(ProcesoParticipativo procesoParticipativo);
    public ProcesoParticipativo getProcesoParticipativo(String nombre);
    public Collection<ProcesoParticipativo> listProcesosParticipativos();
}
