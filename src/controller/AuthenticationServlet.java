package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NotaDao;
import dao.NotaDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import model.Usuario;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/AuthenticationServlet")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String pagina ="categoria/list.jsp";
    	UsuarioDao usuarioDao = new UsuarioDaoImpl();
    	HttpSession sesion = request.getSession(true);
    	sesion.setAttribute("list", usuarioDao.list());
    	RequestDispatcher dispacher = getServletContext().getRequestDispatcher(pagina);
    	dispacher.forward(request, response);
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
		//puede llamar a list
		response.setContentType("text/html; charset=UTF-8");
		//PrintWriter out = response.getWriter();
		RequestDispatcher loguear;
		try{
			String userEma = request.getParameter("txtEmail");
			String userPas = request.getParameter("txtPassword");
			String ErrorMessage = "";
			
			if(userEma != null && !userEma.equalsIgnoreCase("") && userPas != null && !userPas.equalsIgnoreCase("")){
				System.out.println("Logueando...");
				Usuario userObj = new Usuario();
				userObj.setUsuEma(userEma);
				userObj.setUsuPas(userPas);
				UsuarioDao usuarioDao = new UsuarioDaoImpl();
				Usuario userObjValue = new Usuario();
				boolean isValid = usuarioDao.isValid(userObj);
				if (isValid){
					HttpSession sesion = request.getSession(true);
					userObjValue = usuarioDao.getUsuario(userObj);
					NotaDao notadao = new NotaDaoImpl();
					sesion.setAttribute("list", notadao.listUsu(userObjValue.getUsuIde()));
					sesion.setAttribute("listOther", notadao.list());
					sesion.setAttribute("authUsuario", userObjValue);
					loguear = getServletContext().getRequestDispatcher("/views/principal.jsp");
					loguear.forward(request, response);
				}else{
					ErrorMessage = "El usuario o la contraseña son incorrectos";
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("authError", ErrorMessage);
					loguear = getServletContext().getRequestDispatcher("/index.jsp");
					loguear.forward(request, response);
				}
				
			}else{
				ErrorMessage = "Ambos campos son obligatorios";
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("authError", ErrorMessage);
				loguear = getServletContext().getRequestDispatcher("/index.jsp");
				loguear.forward(request, response);
			}
		} finally{
			//out.close();
		} 
	}

}
