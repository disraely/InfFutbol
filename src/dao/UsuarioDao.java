package dao;

import java.util.List;
import model.Usuario;


public interface UsuarioDao {

	public List<Usuario> list();
	public Usuario getSpecific(int id);
	public int getSpecific(String email);
	public boolean guardar(Usuario usuario);
	public Usuario editar(int id);
	public boolean borrar(int d);
	public Usuario getUsuario (Usuario usuario);
	public boolean isValid (Usuario usuario);
	
}
