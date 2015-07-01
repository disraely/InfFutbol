package dao;

import java.util.List;

import model.Partido;

public interface PartidoDao {
	public List<Partido> list();
	public Partido getPartido(int id);
	public boolean guardar(Partido partido);
	public Partido editar(int id);
	public boolean borrar(int d);
	public Partido getPartido (Partido partido);
}
