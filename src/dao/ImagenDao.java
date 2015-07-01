package dao;

import java.util.List;

import model.Imagen;

public interface ImagenDao {
	public List<Imagen> list();
	public Imagen getNotaImagen(int id);
	public boolean guardar(Imagen imagen);
	public Imagen editar(int id);
	public boolean borrar(int d);
	public Imagen getImagen (Imagen imagen);
}
