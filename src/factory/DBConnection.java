package factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBConnection {
	protected String[] params;
	protected Connection connnection;
	
	abstract Connection open();
	
	public ResultSet query(String query){
		Statement st;
		ResultSet rs = null;
		try{
			st = connnection.createStatement();
			rs = st.executeQuery(query);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean execute(String query){
		Statement st;
		boolean guardar = true;
		try{
			st = connnection.createStatement();
			st.executeUpdate(query);
		}catch(SQLException e){
			guardar = false;
			e.printStackTrace();
		}
		return guardar;
	}
	
	public boolean close(){
		boolean flag = true;
		try{
			connnection.close();
		}catch(SQLException e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}
}
