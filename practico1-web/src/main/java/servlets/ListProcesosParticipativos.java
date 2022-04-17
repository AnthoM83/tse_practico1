package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.dtProcesoParticipativo;

@WebServlet("/ListProcesosParticipativos")
public class ListProcesosParticipativos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	beans.EJBGestorProcesosParticipativosLocal gestorDeProcesosParticipativos;
       
    public ListProcesosParticipativos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listProcesosParticipativos(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listProcesosParticipativos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<dtProcesoParticipativo> listDtpp = new ArrayList<>(gestorDeProcesosParticipativos.listProcesosParticipativos());
		List<String> listStr = new ArrayList<>();
		for (dtProcesoParticipativo dtpp : listDtpp) {
			listStr.add(dtpp.getNombre());
		}
		
		request.setAttribute("listNames", listStr);
		RequestDispatcher rd = request.getRequestDispatcher("/ListarProcesosParticipativos.jsp");
        rd.forward(request, response);
	}

}
