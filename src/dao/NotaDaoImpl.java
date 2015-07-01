package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.DBConnection;
import factory.FactoryConnectionDB;
import model.Estadistica;
import model.Nota;
import model.Usuario;

public class NotaDaoImpl implements NotaDao{

	DBConnection conn;

	public NotaDaoImpl() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
	}
	
	@Override
	public List<Nota> list() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM notas WHERE NotIde > 1 ORDER BY NotFec");
		List<Nota> list = new ArrayList<Nota>();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				Nota nota = new Nota();
				nota.setNotIde(rs.getInt("NotIde"));
				nota.setEstIde(rs.getInt("EstIde"));
				nota.setNotFue(rs.getString("NotFue"));
				nota.setNotFec(rs.getDate("NotFec"));
				nota.setNotTit(rs.getString("NotTit"));
				nota.setNotDes(rs.getString("NotDes"));
				list.add(nota);
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return list;
	}
	
	@Override
	public List<Nota> listUsu(int UsuIde) {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM notas WHERE NotIde > 1 AND UsuIde = ").append(UsuIde);
		sql.append(" ORDER BY NotFec");
		List<Nota> list = new ArrayList<Nota>();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				Nota nota = new Nota();
				nota.setNotIde(rs.getInt("NotIde"));
				nota.setEstIde(rs.getInt("EstIde"));
				nota.setNotFue(rs.getString("NotFue"));
				nota.setNotFec(rs.getDate("NotFec"));
				nota.setNotTit(rs.getString("NotTit"));
				nota.setNotDes(rs.getString("NotDes"));
				list.add(nota);
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return list;
	}

	@Override
	public Nota getNota(int id) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM notas WHERE NotIde = ").append(id);
		Nota viewNota = new Nota();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				viewNota.setNotIde(rs.getInt("NotIde"));
				viewNota.setEstIde(rs.getInt("EstIde"));
				viewNota.setUsuIde(rs.getInt("UsuIde"));
				viewNota.setNotFue(rs.getString("NotFue"));
				viewNota.setNotFec(rs.getDate("NotFec"));
				viewNota.setNotTit(rs.getString("NotTit"));
				viewNota.setNotDes(rs.getString("NotDes"));
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return viewNota;
	}

	@Override
	public boolean guardar(Nota nota) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean guardar = false;
		try {
			if (nota.getNotIde() == 0){
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO notas (EstIde,UsuIde,NotFue,NotFec,NotTit,NotDes) VALUES (").append(nota.getEstIde()); 
				sql.append(", ").append(nota.getUsuIde());
				sql.append(", '").append(nota.getNotFue());
				sql.append("', '").append(nota.getNotFec());
				sql.append("', '").append(nota.getNotTit());
				sql.append("', '").append(nota.getNotDes());
				sql.append("')");
				this.conn.execute(sql.toString());
			} else {
				StringBuilder sql = new StringBuilder();
				sql.append("UPDATE notas SET EstIde = ").append(nota.getEstIde());
				sql.append(" WHERE UsuIde = ").append(nota.getNotIde());
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
	public Nota editar(int id) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM notas WHERE NotIde =").append(id);
		Nota nota = new Nota();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				nota.setNotIde(rs.getInt("NotIde"));
				nota.setEstIde(rs.getInt("EstIde"));
				nota.setNotFue(rs.getString("NotFue"));
				nota.setNotFec(rs.getDate("NotFec"));
				nota.setNotTit(rs.getString("NotTit"));
				nota.setNotDes(rs.getString("NotDes"));
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return nota;
	}

	@Override
	public int obtenetNota(int EstIde, int UsuIde, String NotTit, String NotFue) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM notas WHERE EstIde = ").append(EstIde);
		sql.append(" AND ").append("UsuIde = ").append(UsuIde);
		sql.append(" AND ").append("NotTit = '").append(NotTit);
		sql.append("' AND ").append("NotFue = '").append(NotFue).append("'");
		int notIde = 0;
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				notIde = rs.getInt("NotIde");
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return notIde;
	}
	
	@Override
	public boolean borrar(int id) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean borrar = false;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM notas WHERE NotIde = ").append(id);
			this.conn.execute(sql.toString()); 
			borrar = true;
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return borrar;
	}

	@Override
	public Nota getNota(Nota nota) {
		// TODO Auto-generated method stub
		return null;
	}

}
