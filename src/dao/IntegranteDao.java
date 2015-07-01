package dao;

import java.util.List;

import model.Integrante;

public interface IntegranteDao {
	public List<Integrante> list();
	public Integrante getIntegrante(int id);
	public boolean guardar(Integrante integrante);
	public Integrante editar(int id);
	public boolean borrar(int d);
	public Integrante getIntegrante (Integrante integrante);
}
