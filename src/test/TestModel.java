package test;

import java.util.List;

import dao.*;
import model.*;

public class TestModel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestModel testmodel = new TestModel();
		//testmodel.listConsult();
		//testmodel.getSpecific();
		//testmodel.Guardar();
	}
	
	public void listConsult(){
		UsuarioDao usuarioDao = new UsuarioDaoImpl();
		List<Usuario> list = usuarioDao.list();
		for (Usuario usuario : list){
			System.out.println("Nombre: " + usuario.getUsuEma());
		}
	}

	public void Guardar(){
		UsuarioDao usuarioDao = new UsuarioDaoImpl();
		Usuario usuario = new Usuario();
		usuario.setUsuNom("test2");
		usuario.setUsuApe("apellido");
		usuario.setUsuEma("test2@pur.com");
		usuario.setUsuPas("1234");
		usuarioDao.guardar(usuario);
	}
	
	public void Borrar(){
		UsuarioDao usuarioDao = new UsuarioDaoImpl();
		usuarioDao.borrar(2);
	}
	
}
