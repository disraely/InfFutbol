package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.*;
import model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{

	DBConnection conn;

	public UsuarioDaoImpl() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
	}

	@Override
	public List<Usuario> list() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario WHERE UsuSta = '02'");
		List<Usuario> list = new ArrayList<Usuario>();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				Usuario usuario = new Usuario();
				usuario.setUsuIde(rs.getInt("UsuIde"));
				usuario.setUsuNom(rs.getString("UsuNom"));
				usuario.setUsuApe(rs.getString("UsuApe"));
				usuario.setUsuFecNac(rs.getDate("UsuFecNac"));
				usuario.setUsuEma(rs.getString("UsuEma"));
				usuario.setUsuPas(rs.getString("UsuPas"));
				usuario.setUsuPreSec(rs.getString("UsuPreSec"));
				usuario.setUsuResSec(rs.getString("UsuResSec"));
				usuario.setUsuLocLog(rs.getString("UsuLocLog"));
				usuario.setUsuLasLog(rs.getDate("UsuLasLog"));
				usuario.setUsuAfi(rs.getString("UsuAfi"));
				usuario.setUsuCluFav(rs.getString("UsuCluFav"));
				usuario.setUsuSta(rs.getString("UsuSta"));
				list.add(usuario);
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return list;
	}

	@Override
	public Usuario getSpecific(int id) {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		Usuario usuario = new Usuario();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario WHERE UsuIde = ").append(id);
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				usuario.setUsuIde(rs.getInt("UsuIde"));
				usuario.setUsuNom(rs.getString("UsuNom"));
				usuario.setUsuApe(rs.getString("UsuApe"));
				usuario.setUsuFecNac(rs.getDate("UsuFecNac"));
				usuario.setUsuEma(rs.getString("UsuEma"));
				usuario.setUsuPas(rs.getString("UsuPas"));
				usuario.setUsuPreSec(rs.getString("UsuPreSec"));
				usuario.setUsuResSec(rs.getString("UsuResSec"));
				usuario.setUsuLocLog(rs.getString("UsuLocLog"));
				usuario.setUsuLasLog(rs.getDate("UsuLasLog"));
				usuario.setUsuAfi(rs.getString("UsuAfi"));
				usuario.setUsuCluFav(rs.getString("UsuCluFav"));
				usuario.setUsuSta(rs.getString("UsuSta"));	
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return usuario;
	}

	@Override
	public int getSpecific(String email){
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		int usuIde = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM usuario WHERE UsuEma = '").append(email).append("'");
		try {
			ResultSet rs = this.conn.query(sql.toString());
			if (rs.next()){
				usuIde = rs.getInt("UsuIde");
			} else {
				usuIde = -1;
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return usuIde;
	}

	@Override
	public boolean guardar(Usuario usuario) {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean guardar = false;
		try {
			if (usuario.getUsuIde() == 0){
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO usuario (UsuNom,UsuApe,UsuFecNac,UsuEma,UsuPas,UsuPreSec,UsuResSec,UsuLocLog,UsuLasLog,UsuAfi,UsuCluFav,UsuSta) VALUES('").append(usuario.getUsuNom());
				sql.append("', '").append(usuario.getUsuApe());
				sql.append("', '").append(usuario.getUsuFecNac());
				sql.append("', '").append(usuario.getUsuEma());
				sql.append("', '").append(usuario.getUsuPas());
				sql.append("', '").append(usuario.getUsuPreSec());
				sql.append("', '").append(usuario.getUsuResSec());
				sql.append("', '").append(usuario.getUsuLocLog());
				sql.append("', '").append(usuario.getUsuLasLog());
				sql.append("', '").append(usuario.getUsuAfi());
				sql.append("', '").append(usuario.getUsuCluFav());
				sql.append("', '").append(usuario.getUsuSta());
				sql.append("')");
				this.conn.execute(sql.toString());
			} else {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE usuario SET UsuIde = ").append(usuario.getUsuIde());
				sql.append(", UsuNom = '").append(usuario.getUsuNom());
				sql.append("', UsuEma'").append(usuario.getUsuEma()).append(" WHERE UsuIde = ").append(usuario.getUsuIde());
				this.conn.execute(sql.toString());
			}
			guardar = true;
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return guardar;
	}

	@Override
	public Usuario editar(int id) {
		Usuario usuario = new Usuario();
		return usuario;
	}
	
	@Override
	public boolean borrar(int id) {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean borrar = false;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE usuario SET UsuSta = '01' WHERE UsuIde = ").append(id);
			this.conn.execute(sql.toString()); 
			borrar = true;
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return borrar;
	}

	@Override
	public Usuario getUsuario(Usuario usuario) {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		String UsuEma = usuario.getUsuEma();
		String UsuPas = usuario.getUsuPas();
		sql.append("SELECT * FROM usuario WHERE UsuEma = '").append(UsuEma);
		sql.append("' AND UsuPas = '").append(UsuPas);
		sql.append("' AND UsuSta = '02'");
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				usuario.setUsuIde(rs.getInt("UsuIde"));
				usuario.setUsuNom(rs.getString("UsuNom"));
				usuario.setUsuApe(rs.getString("UsuApe"));
				usuario.setUsuFecNac(rs.getDate("UsuFecNac"));
				usuario.setUsuEma(rs.getString("UsuEma"));
				usuario.setUsuPas(rs.getString("UsuPas"));
				usuario.setUsuPreSec(rs.getString("UsuPreSec"));
				usuario.setUsuResSec(rs.getString("UsuResSec"));
				usuario.setUsuLocLog(rs.getString("UsuLocLog"));
				usuario.setUsuLasLog(rs.getDate("UsuLasLog"));
				usuario.setUsuAfi(rs.getString("UsuAfi"));
				usuario.setUsuCluFav(rs.getString("UsuCluFav"));
				usuario.setUsuSta(rs.getString("UsuSta"));	
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return usuario;
	}
	
	@Override
	public boolean isValid (Usuario usuario){
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean valido = false;
		StringBuilder sql = new StringBuilder();
		String UsuEma = usuario.getUsuEma();
		String UsuPas = usuario.getUsuPas();
		sql.append("SELECT * FROM usuario WHERE UsuEma = '").append(UsuEma);
		sql.append("' AND UsuPas = '").append(UsuPas);
		sql.append("' AND UsuSta = '02'");
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				valido = true;
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return valido;
	}

}
