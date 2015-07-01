package factory;

public class FactoryConnectionDB {
	public static final int MYSQL = 1;
	
	public static String[] configMYSQL = {"bd_futbol", "root", "mysql"};
	
	public static DBConnection open(int typeDb){
		switch(typeDb){
		case FactoryConnectionDB.MYSQL:
			return new MysqlConnection(configMYSQL);
		default:
			return null;
		}
	}
}
