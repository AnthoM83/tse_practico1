package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ProcesoParticipativo;

@WebServlet("/GestorProcesosParticipativos")
public class ServletGestorProcesosParticipativos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//@EJB(lookup="java:global/practico1/practico1-ejb/EJBGestorProcesosParticipativos!beans.EJBGestorProcesosParticipativosRemote")
	@EJB
	beans.EJBGestorProcesosParticipativosRemote gestorDeProcesosParticipativos;
       
    public ServletGestorProcesosParticipativos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("operation");
		if(action == null) {
			response.getWriter().append("No operation passed as parameter");
		} else {
			switch(action) {
			case "add":
				addProcesoParticipativo(request, response);
				break;
			case "get":
				getProcesoParticipativo(request, response);
				break;
			case "list":
				listProcesosParticipativos(request, response);
				break;
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void addProcesoParticipativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String strFechaInicio = request.getParameter("fechaInicio");
		String strFechaFin = request.getParameter("fechaFin");
		ProcesoParticipativo proceso = new ProcesoParticipativo();
		proceso.setNombre(name);
		proceso.setFechaInicio(LocalDate.parse(strFechaInicio));
		proceso.setFechaFin(LocalDate.parse(strFechaFin));
		gestorDeProcesosParticipativos.addProcesoParticipativo(proceso);
		response.getWriter().append("¡Proceso participativo agregado con éxito!");
	}
	
	private void getProcesoParticipativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		ProcesoParticipativo proceso = gestorDeProcesosParticipativos.getProcesoParticipativo(name);
		if (proceso == null)
			response.getWriter().append("No existe ese proceso participativo");
		else {
			String strHeader = ("= = = = = = =	 Proceso participativo  = = = = = = =\n");
			String strId = ("Id: " + proceso.getId() + "\n");
			String strName = ("Nombre: " + proceso.getNombre() + "\n");
			String strIni = ("Fecha inicio: " + proceso.getFechaInicio().toString() + "\n");
			String strEnd = ("Fecha Fin: " + proceso.getFechaFin().toString() + "\n");
			String strState = ("Estado: " + proceso.getEstado() + "\n");
			String strFooter = ("= = = = = = = = = = = = = = = = = = = = = = = = = = =");
			response.getWriter().print(strHeader + strId + strName + strIni + strEnd + strState + strFooter);
		}	
	}
	
	private void listProcesosParticipativos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ProcesoParticipativo> list = new ArrayList<>(gestorDeProcesosParticipativos.listProcesosParticipativos());
	}

}
