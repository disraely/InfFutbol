package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.DBConnection;
import factory.FactoryConnectionDB;
import model.Estadistica;
import model.Nota;
import model.Partido;
import model.Usuario;

public class EstadisticaDaoImpl implements EstadisticaDao{

	DBConnection conn;

	public EstadisticaDaoImpl() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
	}
	
	@Override
	public List<Estadistica> list() {
		this.conn = FactoryConnectionDB.open(FactoryConnectionDB.MYSQL);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM estadisticas WHERE EstIde > 1");
		List<Estadistica> list = new ArrayList<Estadistica>();
		try {
			ResultSet rs = this.conn.query(sql.toString());
			while (rs.next()){
				Estadistica estadistica = new Estadistica();
				estadistica.setEstIde(rs.getInt("EstIde"));
				estadistica.setParIde(rs.getInt("ParIde"));
				estadistica.setEstSegEqu(rs.getString("EstSegEqu"));
				estadistica.setEstSegTarRoj(rs.getInt("EstSegTarRoj"));
				estadistica.setEstSegTarAma(rs.getInt("EstSegTarAma"));
				estadistica.setEstSegTirDir(rs.getInt("EstSegTirDir"));
				estadistica.setEstSegTirInd(rs.getInt("EstSegTirInd"));
				estadistica.setEstSegTirEsq(rs.getInt("EstSegTirEsq"));
				estadistica.setEstSegFueJue(rs.getInt("EstSegFueJue"));
				estadistica.setEstPriEqu(rs.getString("EstPriEqu"));
				estadistica.setEstPriTarRoj(rs.getInt("EstPriTarRoj"));
				estadistica.setEstPriTarAma(rs.getInt("EstPriTarAma"));
				estadistica.setEstPriTirDir(rs.getInt("EstPriTirDir"));
				estadistica.setEstPriTirInd(rs.getInt("EstPriTirInd"));
				estadistica.setEstPriTirEsq(rs.getInt("EstPriTirEsq"));
				estadistica.setEstPriFueJue(rs.getInt("EstPriFueJue"));
				list.add(estadistica);
			}
		} catch (Exception e){
		} finally {
			this.conn.close();
		}
		return list;
	}

	@Override
	public Estadistica getEstadistica(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean guardar(Estadistica estadistica) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Estadistica editar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean borrar(int d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Estadistica getEstadistica(Estadistica estadistica) {
		// TODO Auto-generated method stub
		return null;
	}

}
