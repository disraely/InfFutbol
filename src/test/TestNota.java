package test;

import java.util.List;

import model.Nota;
import dao.NotaDao;
import dao.NotaDaoImpl;

public class TestNota {

	public void list(){
		NotaDao	notaDao = new NotaDaoImpl();
		List<Nota> list = notaDao.list();
		for (Nota nota : list){
			System.out.println("Titulo " + nota.getNotTit());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestNota test = new TestNota();
		test.list();
	}

}
