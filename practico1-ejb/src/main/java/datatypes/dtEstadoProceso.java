package datatypes;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum dtEstadoProceso {
	EN_ESPERA,
	EN_PROGRESO,
	FINALIZADO,
	CANCELADO;
	
    public String value() {
        return name();
    }

    public static dtEstadoProceso fromValue(String v) {
        return valueOf(v);
    }
    
}
