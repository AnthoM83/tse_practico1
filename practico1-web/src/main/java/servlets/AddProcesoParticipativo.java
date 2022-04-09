package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.ProcesoParticipativo;
import exceptions.ExistingEntityException;

@WebServlet("/AddProcesoParticipativo")
public class AddProcesoParticipativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	beans.EJBGestorProcesosParticipativosRemote gestorDeProcesosParticipativos;
	
    public AddProcesoParticipativo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		addProcesoParticipativo(request, response);
	}
	
	private void addProcesoParticipativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String strFechaInicio = request.getParameter("fechaInicio");
		String strFechaFin = request.getParameter("fechaFin");
		ProcesoParticipativo proceso = new ProcesoParticipativo();
		proceso.setNombre(name);
		proceso.setFechaInicio(LocalDate.parse(strFechaInicio));
		proceso.setFechaFin(LocalDate.parse(strFechaFin));
		try {
			gestorDeProcesosParticipativos.addProcesoParticipativo(proceso);
			response.sendRedirect("Index.jsp");
		} catch (ExistingEntityException e) {
			request.setAttribute("err", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/AltaProcesoParticipativo.jsp");
			rd.forward(request, response);
		}


	}

}
