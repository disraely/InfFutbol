package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.ImagenDao;
import dao.ImagenDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import Utilities.Utilities;
import model.Imagen;
import model.Usuario;

/**
 * Servlet implementation class NewUsuarioServlet
 */
@WebServlet("/NuevoUsuario")
public class NewUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void SaveImg(HttpServletRequest request, HttpServletResponse response, int useEmaVal, FileItem item) throws Exception {
		// TODO Auto-generated method stub
		String filename = item.getName();
		String nom = "UserProfile".concat(Integer.toString(useEmaVal).concat(Utilities.getFileExtension(filename)));
		
		//String root = getServletContext().getRealPath("/");
		//String root = "C:/Users/Disraely/Documents/workspace/RepositorioImg";
		String root = "C:/Users/Disraely/Documents/workspace/InfFutbol/WebContent/repositoryImg";
		//File path = new File(root + "/../../web/files");
		File path = new File(root);
		if (!path.exists()){
			boolean status = path.mkdirs();
		}
		File uploadedFile = new File(path + "/" + nom);
		item.write(uploadedFile);
		ImagenDao imagenDao = new ImagenDaoImpl();
		Imagen imgObj = new Imagen();
		imgObj.setUsuIde(useEmaVal);
		imgObj.setImgNom(nom);
		imgObj.setImgRut(uploadedFile.getAbsolutePath());
		imagenDao.guardar(imgObj);
		/*
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()){
					FileItem item = (FileItem) iterator.next();
					if (!item.isFormField()){
						String filename = item.getName();
						//String root = getServletContext().getRealPath("/");
						String root = "C:/Users/Disraely/Documents/workspace/RepositorioImg";
						//File path = new File(root + "/../../web/files");
						File path = new File(root);
						if (!path.exists()){
							boolean status = path.mkdirs();
						}
						File uploadedFile = new File(path + "/" + filename);
						item.write(uploadedFile);
						ImagenDao imagenDao = new ImagenDaoImpl();
						Imagen imgObj = new Imagen();
						imgObj.setUsuIde(useEmaVal);
						imgObj.setImgNom(filename);
						imgObj.setImgRut(uploadedFile.getAbsolutePath());
						imagenDao.guardar(imgObj);
					}
				}
			} catch (FileUploadException e){
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}*/
	}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		int useEmaVal = 0;
		FileItem filename = null;
		//PrintWriter out = response.getWriter();
		RequestDispatcher registrar;
		String ErrorMessage = "";
		Map<String, String> nombreMap = new HashMap<String, String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		
		if (isMultipart){
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try{
				List items = upload.parseRequest(request);
				Iterator iterator = items.iterator();
				while (iterator.hasNext()){
					FileItem item = (FileItem) iterator.next();
					if (item.isFormField()){
						String fieldname = item.getFieldName();
		                String fieldvalue = item.getString();
		                nombreMap.put(fieldname, fieldvalue);
					}else{
						filename = item;
						
					}
				}
				String userNom = nombreMap.get("txtNombre");
				String userApe = nombreMap.get("txtApellido");
				String userFecStr = nombreMap.get("txtFecha");
				Date userFec = new Date(0);
				userFec = Utilities.stringToDate(userFecStr);
				String userEma = nombreMap.get("txtEmail");
				String userPas = nombreMap.get("txtPassword");
				String userPre = nombreMap.get("txtPregunta");
				String userRes = nombreMap.get("txtRespuesta");
				String userClu = nombreMap.get("txtClub");
				// do Insertar
				System.out.println("Guardar");
				UsuarioDao usuarioDao = new UsuarioDaoImpl();
				useEmaVal = usuarioDao.getSpecific(userEma);
				if (useEmaVal < 0){ //usuario nuevo
					Usuario userObj = new Usuario();
					userObj.setUsuNom(userNom);
					userObj.setUsuApe(userApe);
					userObj.setUsuFecNac(userFec);
					userObj.setUsuEma(userEma);
					userObj.setUsuPas(userPas);
					userObj.setUsuPreSec(userPre);
					userObj.setUsuResSec(userRes);
					userObj.setUsuCluFav(userClu);
					usuarioDao.guardar(userObj);
					useEmaVal = usuarioDao.getSpecific(userEma);
					SaveImg(request, response, useEmaVal, filename);
					ErrorMessage = "Usuario registrado, ingrese con los datos registrados";
					registrar = getServletContext().getRequestDispatcher("/index.jsp");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("authError", ErrorMessage);
					registrar.forward(request, response);
				} else {
					ErrorMessage = "El email que has indicado ya existe";
					registrar = getServletContext().getRequestDispatcher("/views/usuario/registrarUsuario.jsp");
					HttpSession sesion = request.getSession(true);
					sesion.setAttribute("authEmail", ErrorMessage);
					registrar.forward(request, response);
				}
			} catch (FileUploadException e){
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		
		/*
		response.setContentType("text/html; charset=UTF-8");
		int useEmaVal = 0;
		//PrintWriter out = response.getWriter();
		RequestDispatcher registrar;
		String ErrorMessage = "";
		try {
			String userNom = request.getParameter("txtNombre");
			String userApe = request.getParameter("txtApellido");
			String userFot = request.getParameter("txtFoto");
			String userFecStr = request.getParameter("txtFecha");
			Date userFec = new Date(0);
			userFec = Utilities.stringToDate(userFecStr);
			String userEma = request.getParameter("txtEmail");
			String userPas = request.getParameter("txtPassword");
			String userPre = request.getParameter("txtPregunta");
			String userRes = request.getParameter("txtRespuesta");
			String userClu = request.getParameter("txtClub");
			// do Insertar
			System.out.println("Guardar");
			UsuarioDao usuarioDao = new UsuarioDaoImpl();
			useEmaVal = usuarioDao.getSpecific("userEma");
			if (useEmaVal < 0){
				Usuario userObj = new Usuario();
				userObj.setUsuNom(userNom);
				userObj.setUsuApe(userApe);
				userObj.setUsuFecNac(userFec);
				userObj.setUsuEma(userEma);
				userObj.setUsuPas(userPas);
				userObj.setUsuPreSec(userPre);
				userObj.setUsuResSec(userRes);
				userObj.setUsuCluFav(userClu);
				usuarioDao.guardar(userObj);
				useEmaVal = usuarioDao.getSpecific(userEma);
				if(userFot.length() !=0){
					SaveImg(request, response, useEmaVal);
				}
				ErrorMessage = "Usuario registrado, ingrese con los datos registrados";
				registrar = getServletContext().getRequestDispatcher("/index.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("authError", ErrorMessage);
				registrar.forward(request, response);
			} else {
				ErrorMessage = "El email que has indicado ya existe";
				registrar = getServletContext().getRequestDispatcher("/views/usuario/registrarUsuario.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("authEmail", ErrorMessage);
				registrar.forward(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}*/
	}
}
