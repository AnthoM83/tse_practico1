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

@WebServlet("/GetProcesoParticipativo")
public class GetProcesoParticipativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	beans.EJBGestorProcesosParticipativosRemote gestorDeProcesosParticipativos;
	
    public GetProcesoParticipativo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getProcesoParticipativo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void getProcesoParticipativo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("search-1");
		ProcesoParticipativo proceso = gestorDeProcesosParticipativos.getProcesoParticipativo(name);
		if (proceso != null) {
			request.setAttribute("pNombre", proceso.getNombre());
			request.setAttribute("pId", proceso.getId());
			request.setAttribute("pFechaInicio", proceso.getFechaInicio().toString());
			request.setAttribute("pFechaFin", proceso.getFechaFin().toString());
			request.setAttribute("pEstado", proceso.getEstado().toString());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ConsultaProcesoParticipativo.jsp");
        rd.forward(request, response);
	}

}
