package client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.EJBGestorProcesosParticipativosRemote;
import datatypes.dtProcesoParticipativo;
import exceptions.ExistingEntityException;

public class Client {
	public static void main(String[] args) throws NamingException {
		
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");  
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");  
		props.put(Context.PROVIDER_URL,"remote+http://localhost:8080"); 
		Context ctx  = new InitialContext(props);
		String jndiName = "ejb:practico1/practico1-ejb/EJBGestorProcesosParticipativos!beans.EJBGestorProcesosParticipativosRemote";
		EJBGestorProcesosParticipativosRemote app = (EJBGestorProcesosParticipativosRemote)ctx.lookup(jndiName);
		
		int opt = menu();
		while (opt > 0 && opt < 4) {
			if ( opt == 1) {
				menuAlta(app);
			} else if (opt == 2) {
				menuConsulta(app);
			} else if (opt == 3) {
				menuListado(app);
			}
			opt = menu();
		}
		
		System.out.println("\n Hasta la próxima!");
	}

	public Client() {
		super();
	}
	
	public static int menu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("##########################################");
		System.out.println("###### Gestor de procesos participativos  ######");
		System.out.println("##########################################");
		System.out.println("- - Opciones - -");
		System.out.println("1. Alta");
		System.out.println("2. Consulta");
		System.out.println("3. Listado");
		System.out.println("*Otro número para salir del programa");
		System.out.println("Eliga su opción y presione ENTER: ");
		int opt = scanner.nextInt();
		return opt;
	}
	
	public static void menuAlta(EJBGestorProcesosParticipativosRemote app) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("##########################################");
		System.out.println("########  Alta de proceso participativo  ########");
		System.out.println("##########################################");
		System.out.println("Nombre: ");
		String nombre = scanner.nextLine();
		System.out.println("*Formato de fecha: YYYY-MM-DD*");
		System.out.println("Fecha de inicio: ");
		String fechaInicio = scanner.nextLine();
		System.out.println("Fecha de fin: ");
		String fechaFin = scanner.nextLine();
		try {
			dtProcesoParticipativo dtpp = new dtProcesoParticipativo();
			dtpp.setNombre(nombre);
			dtpp.setFechaInicio(LocalDate.parse(fechaInicio));
			dtpp.setFechaFin(LocalDate.parse(fechaFin));
			app.addProcesoParticipativo(dtpp);
			System.out.println("Agregado con éxito!");
		} catch (ExistingEntityException e) {
			System.out.println("Error: ya existe un proceso participativo con ese nombre.");
		}
	}
	
	public static void menuConsulta(EJBGestorProcesosParticipativosRemote app) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("##########################################");
		System.out.println("######  Consulta de proceso participativo ######");
		System.out.println("##########################################");
		System.out.println("Buscar: ");
		String buscar = scanner.nextLine();
		dtProcesoParticipativo dtpp = app.getProcesoParticipativo(buscar);
		System.out.println("Nombre: " + dtpp.getNombre());
		System.out.println("Fecha Inicio: " + dtpp.getFechaInicio().toString());
		System.out.println("Fecha Fin: " + dtpp.getFechaFin().toString());
		System.out.println("Estado: " + dtpp.getEstado().value());
	}
	
	public static void menuListado(EJBGestorProcesosParticipativosRemote app) {
		System.out.println("\n");
		System.out.println("##########################################");
		System.out.println("###### Listado de procesos participativos ######");
		System.out.println("##########################################");
		ArrayList<dtProcesoParticipativo> listDtpp = new ArrayList<dtProcesoParticipativo>(app.listProcesosParticipativos());
		for (dtProcesoParticipativo dtpp : listDtpp) {
			System.out.println("- " + dtpp.getNombre());
		}
	}
	
}