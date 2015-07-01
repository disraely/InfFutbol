package dao;

import java.util.List;

import model.Estadistica;;

public interface EstadisticaDao {
	public List<Estadistica> list();
	public Estadistica getEstadistica(int id);
	public boolean guardar(Estadistica estadistica);
	public Estadistica editar(int id);
	public boolean borrar(int d);
	public Estadistica getEstadistica (Estadistica estadistica);
}
