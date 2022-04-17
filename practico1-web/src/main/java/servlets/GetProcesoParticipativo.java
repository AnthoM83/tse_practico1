package servlets;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.dtProcesoParticipativo;

@WebServlet("/GetProcesoParticipativo")
public class GetProcesoParticipativo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	beans.EJBGestorProcesosParticipativosLocal gestorDeProcesosParticipativos;
	
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
		dtProcesoParticipativo dtpp = gestorDeProcesosParticipativos.getProcesoParticipativo(name);
		if (dtpp != null) {
			request.setAttribute("pNombre", dtpp.getNombre());
			request.setAttribute("pFechaInicio", dtpp.getFechaInicio().toString());
			request.setAttribute("pFechaFin", dtpp.getFechaFin().toString());
			request.setAttribute("pEstado", dtpp.getEstado().toString());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/ConsultaProcesoParticipativo.jsp");
        rd.forward(request, response);
	}

}
