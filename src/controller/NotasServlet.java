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

import Utilities.Utilities;
import model.Imagen;
import model.Nota;
import model.Usuario;
import dao.EstadisticaDao;
import dao.EstadisticaDaoImpl;
import dao.ImagenDao;
import dao.ImagenDaoImpl;
import dao.NotaDao;
import dao.NotaDaoImpl;
import dao.UsuarioDao;
import dao.UsuarioDaoImpl;

/**
 * Servlet implementation class NotasServlet
 */
@WebServlet("/NotasServlet")
public class NotasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		String pagina;
		RequestDispatcher registrarNota;
		if(op.equals("create")){
			HttpSession sesion = request.getSession(true);
			EstadisticaDao estadisticadao = new EstadisticaDaoImpl();
			sesion.setAttribute("listEstadistica", estadisticadao.list());
			pagina = "/views/nota/ResgistrarNota.jsp";
			registrarNota = getServletContext().getRequestDispatcher(pagina);
			registrarNota.forward(request, response);
		} else if (op.equals("view")){
			String id = request.getParameter("id");
			int NotIde = Utilities.stringToInt(id);
			HttpSession sesion = request.getSession(true);
			NotaDao notadao = new NotaDaoImpl();
			ImagenDao imagendao = new ImagenDaoImpl();
			sesion.setAttribute("loadImg", imagendao.getNotaImagen(NotIde));
			sesion.setAttribute("viewNota", notadao.getNota(NotIde));
			pagina = "/views/nota/VerNota.jsp";
			registrarNota = getServletContext().getRequestDispatcher(pagina);
			registrarNota.forward(request, response);
		} else if (op.equals("delete")){
			String id = request.getParameter("id");
			int NotIde = Utilities.stringToInt(id);
			HttpSession sesion = request.getSession(true);
			NotaDao notadao = new NotaDaoImpl();
			notadao.borrar(NotIde);
			sesion.setAttribute("list", notadao.list());
			pagina = "/views/principal.jsp";
			registrarNota = getServletContext().getRequestDispatcher(pagina);
			registrarNota.forward(request, response);
		} else if (op.equals("update")){
			String id = request.getParameter("id");
			int NotIde = Utilities.stringToInt(id);
			HttpSession sesion = request.getSession(true);
			NotaDao notaDao = new NotaDaoImpl();
			Nota notaObjValue = new Nota();
			notaObjValue = notaDao.editar(NotIde);
			EstadisticaDao estadisticadao = new EstadisticaDaoImpl();
			sesion.setAttribute("listEstadistica", estadisticadao.list());
			sesion.setAttribute("Nota", notaObjValue);
			pagina = "/views/nota/EditarNota.jsp";
			registrarNota = getServletContext().getRequestDispatcher(pagina);
			registrarNota.forward(request, response);
		}
	}

	protected void SaveImg(HttpServletRequest request, HttpServletResponse response, int notValIde, int usuIde, FileItem item) throws Exception {
		// TODO Auto-generated method stub
		String filename = item.getName();
		String not = "Nota".concat(Integer.toString(notValIde).concat(Utilities.getFileExtension(filename)));
		
		//String root = getServletContext().getRealPath("/");
		//String root = "C:/Users/Disraely/Documents/workspace/RepositorioImg";
		String root = "C:/Users/Disraely/Documents/workspace/InfFutbol/WebContent/repositoryImg";
		//File path = new File(root + "/../../web/files");
		File path = new File(root);
		if (!path.exists()){
			boolean status = path.mkdirs();
		}
		File uploadedFile = new File(path + "/" + not);
		item.write(uploadedFile);
		ImagenDao imagenDao = new ImagenDaoImpl();
		Imagen imgObj = new Imagen();
		imgObj.setNotIde(notValIde);
		imgObj.setImgNom(not);
		imgObj.setImgRut(uploadedFile.getAbsolutePath());
		imagenDao.guardar(imgObj);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		FileItem filename = null;
		int notValIde = 0;
		//PrintWriter out = response.getWriter();
		RequestDispatcher registrar;
		String ErrorMessage = "";
		Map<String, String> notaMap = new HashMap<String, String>();
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
		                notaMap.put(fieldname, fieldvalue);
					}else{
						filename = item;
						
					}
				}
				String EstIdeStr = notaMap.get("txtPartido");
				int EstIde = Utilities.stringToInt(EstIdeStr);
				String UsuIdeStr = notaMap.get("txtUsuario");
				int UsuIde = Utilities.stringToInt(UsuIdeStr);
				String NotFue = notaMap.get("txtFuente");
				String NotFecStr = notaMap.get("txtFecha");
				Date NotFec = new Date(0);
				NotFec = Utilities.stringToDate(NotFecStr);
				String NotTit = notaMap.get("txtTitulo");
				String NotDes = notaMap.get("txtDescripcion");
				System.out.println("Guardar");
				NotaDao notaDao = new NotaDaoImpl();
				Nota notObj = new Nota();
				notObj.setEstIde(EstIde);
				notObj.setUsuIde(UsuIde);
				notObj.setNotFue(NotFue);
				notObj.setNotFec(NotFec);
				notObj.setNotTit(NotTit);
				notObj.setNotDes(NotDes);
				notaDao.guardar(notObj);
				//hay q oibtener el ide del ingresado :S
				notValIde = notaDao.obtenetNota(EstIde,UsuIde,NotTit,NotFue);
				SaveImg(request, response, notValIde, UsuIde, filename);
				NotaDao notadao = new NotaDaoImpl();
				registrar = getServletContext().getRequestDispatcher("/views/principal.jsp");
				HttpSession sesion = request.getSession(true);
				sesion.setAttribute("list", notadao.list());
				registrar.forward(request, response);
			} catch (FileUploadException e){
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
			}
		}		
	}

}
