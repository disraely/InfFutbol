package dao;

import java.util.List;

import model.Torneo;

public interface torneoDao {
	public List<Torneo> list();
	public Torneo getTorneo(int id);
	public boolean guardar(Torneo torneo);
	public Torneo editar(int id);
	public boolean borrar(int d);
	public Torneo getTorneo (Torneo torneo);
}
