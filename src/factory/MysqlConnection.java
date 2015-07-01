package factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;


public final class MysqlConnection extends DBConnection{

	public MysqlConnection(String[] params) {
		this.params = params;
		this.open();
	}

	@Override
	public Connection open() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			this.connnection = DriverManager.getConnection("jdbc:mysql://localhost/"+this.params[0], this.params[1], this.params[2]);
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

}
