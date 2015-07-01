package dao;

import java.util.List;

import model.Nota;

public interface NotaDao {
	public List<Nota> list();
	public List<Nota> listUsu(int usuIde);
	public Nota getNota(int id);
	public boolean guardar(Nota nota);
	public Nota editar(int id);
	public int obtenetNota(int EstIde, int UsuIde, String NotTit, String NotFue);
	public boolean borrar(int id);
	public Nota getNota (Nota nota);
}
