package dao;

import java.util.List;

import model.Grupo;

public interface GrupoDao {
	public List<Grupo> list();
	public Grupo getGrupo(int id);
	public boolean guardar(Grupo grupo);
	public Grupo editar(int id);
	public boolean borrar(int d);
	public Grupo getGrupo (Grupo grupo);
}
