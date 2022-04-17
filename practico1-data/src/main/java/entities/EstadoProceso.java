package entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum EstadoProceso {
	EN_ESPERA,
	EN_PROGRESO,
	FINALIZADO,
	CANCELADO
}
