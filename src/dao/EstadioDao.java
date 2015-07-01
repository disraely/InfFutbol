package dao;

import java.util.List;

import model.Estadio;

public interface EstadioDao {
	public List<Estadio> list();
	public Estadio getEstadio(int id);
	public boolean guardar(Estadio estadio);
	public Estadio editar(int id);
	public boolean borrar(int d);
	public Estadio getEstadio (Estadio estadio);
}
