package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Nota;
import model.Usuario;
import Utilities.Utilities;
import dao.EstadisticaDao;
import dao.EstadisticaDaoImpl;
import dao.NotaDao;
import dao.NotaDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

/**
 * Servlet implementation class NotasUpdateServlet
 */
@WebServlet(name = "notUpdate", urlPatterns = { "/notUpdate" })
public class NotasUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotasUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		RequestDispatcher editar;
		String pagina;
		try {
			String EditarAcction = request.getParameter("btnEditar");
			String CancelAcction = request.getParameter("btnCancelar");
			
			if ("Editar".equals(EditarAcction)) {
				String NotIdeStr = request.getParameter("txtIde");//int
				int NotIde = Utilities.stringToInt(NotIdeStr);
				String EstIdeStr = request.getParameter("txtPartido");//int
				int EstIde = Utilities.stringToInt(EstIdeStr);
				String NotFue = request.getParameter("txtFuente");
				String NotFecStr = request.getParameter("txtFecha");//date
				Date NotFec = new Date(0);
				NotFec = Utilities.stringToDate(NotFecStr);
				String NotTit = request.getParameter("txtTitulo");
				String NotDes = request.getParameter("txtDescripcion");
				String NotImg = request.getParameter("txtImg");
				// do Insertar
				System.out.println("Update");
				NotaDao notaDao = new NotaDaoImpl();
				Nota notObj = new Nota();
				notObj.setNotIde(NotIde);
				notObj.setEstIde(EstIde);
				notObj.setNotFue(NotFue);
				notObj.setNotFec(NotFec);
				notObj.setNotTit(NotTit);
				notObj.setNotDes(NotDes);
				//notaDao..guardar(userObj);
				editar = getServletContext().getRequestDispatcher("/index.jsp");
				HttpSession sesion = request.getSession(true);
				editar.forward(request, response);
			} else if ("Cancelar".equals(CancelAcction)) {
				pagina = "/views/principal.jsp";
				editar = getServletContext().getRequestDispatcher(pagina);
				HttpSession sesion = request.getSession(true);
				editar.forward(request, response);
			} else {
				System.out.println("Sin accion");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

}
