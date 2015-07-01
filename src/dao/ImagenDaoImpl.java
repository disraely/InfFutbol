package dao;

import java.sql.ResultSet;
import java.util.List;

import factory.DBConnection;
import factory.FactoryConnectionDB;
import model.Imagen;
import model.Nota;

public class ImagenDaoImpl implements ImagenDao{

	DBConnection conn;

	public ImagenDaoImpl() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
	}
	
	@Override
	public List<Imagen> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Imagen getNotaImagen(int id) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM imagen WHERE NotIde = ").append(id);
		Imagen loadImagen = new Imagen();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				loadImagen.setImgIde(rs.getInt("ImgIde")); 
				loadImagen.setNotIde(rs.getInt("NotIde")); 
				loadImagen.setUsuIde(rs.getInt("UsuIde")); 
				loadImagen.setImgNom(rs.getString("ImgNom")); 
				loadImagen.setImgRut(rs.getString("ImgRut")); 
				loadImagen.setImgDes(rs.getString("ImgDes")); 
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return loadImagen;
	}

	@Override
	public boolean guardar(Imagen imagen) {
		// TODO Auto-generated method stub
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		boolean guardar = false;
		try {
			if (imagen.getImgIde() == 0){
				StringBuilder sql = new StringBuilder();
				sql.append("INSERT INTO imagen (TorIde,EstIde,EquIde,IntIde,NotIde,UsuIde,ImgNom,ImgRut,ImgDes) VALUES('").append(imagen.getTorIde());
				sql.append("', '").append(imagen.getEstIde());
				sql.append("', '").append(imagen.getEquIde());
				sql.append("', '").append(imagen.getIntIde());
				sql.append("', '").append(imagen.getNotIde());
				sql.append("', '").append(imagen.getUsuIde());
				sql.append("', '").append(imagen.getImgNom());
				sql.append("', '").append(imagen.getImgRut());
				sql.append("', '").append(imagen.getImgDes());
				sql.append("')");
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
	public Imagen editar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(int d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Imagen getImagen(Imagen imagen) {
		// TODO Auto-generated method stub
		return null;
	}

}
