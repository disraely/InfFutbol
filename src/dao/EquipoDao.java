package dao;

import java.util.List;

import model.Equipo;

public interface EquipoDao {
	public List<Equipo> list();
	public Equipo getEquipo(int id);
	public boolean guardar(Equipo equipo);
	public Equipo editar(int id);
	public boolean borrar(int d);
	public Equipo getEquipo (Equipo equipo);
}
