package model;



import java.sql.Date;
import Utilities.Utilities;

public class Usuario {
	
	private int UsuIde; //usuario
	private String UsuNom; //nombre
	private String UsuApe; 
	private Date UsuFecNac;
	private String UsuEma;
	private String UsuPas; //password
	private String UsuPreSec;
	private String UsuResSec;
	private String UsuLocLog;
	private Date UsuLasLog;
	private String UsuAfi;
	private String UsuCluFav;
	private String UsuSta;
	// int relation
	
	public Usuario() {
		this.UsuIde = 0;
		this.UsuNom = "";
		this.UsuApe = "";
		this.UsuEma = "";
		this.UsuPas = "";
		this.UsuLocLog = "N";
		this.UsuFecNac = Utilities.getToday();
		this.UsuLasLog = Utilities.getToday();
		this.UsuSta = "02";
		//inicializa this.tabla1 = new tabla();
	}

	public Usuario(int usuIde, String usuNom, String usuApe, Date usuFecNac, String usuEma, String usuPas, String usuPreSec, String usuResSec, String usuLocLog, Date usuLasLog, String usuAfi, String usuCluFav, String usuSta) {
		UsuIde = usuIde;
		UsuNom = usuNom;
		UsuApe = usuApe;
		UsuFecNac = usuFecNac;
		UsuEma = usuEma;
		UsuPas = usuPas;
		UsuPreSec = usuPreSec;
		UsuResSec = usuResSec;
		UsuLocLog = usuLocLog;
		UsuLasLog = usuLasLog;
		UsuAfi = usuAfi;
		UsuCluFav = usuCluFav;
		UsuSta = usuSta;
	}

	public int getUsuIde() {
		return UsuIde;
	}

	public void setUsuIde(int usuIde) {
		UsuIde = usuIde;
	}

	public String getUsuNom() {
		return UsuNom;
	}

	public void setUsuNom(String usuNom) {
		UsuNom = usuNom;
	}

	public String getUsuApe() {
		return UsuApe;
	}

	public void setUsuApe(String usuApe) {
		UsuApe = usuApe;
	}

	public Date getUsuFecNac() {
		return UsuFecNac;
	}

	public void setUsuFecNac(Date usuFecNac) {
		UsuFecNac = usuFecNac;
	}

	public String getUsuEma() {
		return UsuEma;
	}

	public void setUsuEma(String usuEma) {
		UsuEma = usuEma;
	}

	public String getUsuPas() {
		return UsuPas;
	}

	public void setUsuPas(String usuPas) {
		UsuPas = usuPas;
	}

	public String getUsuPreSec() {
		return UsuPreSec;
	}

	public void setUsuPreSec(String usuPreSec) {
		UsuPreSec = usuPreSec;
	}

	public String getUsuResSec() {
		return UsuResSec;
	}

	public void setUsuResSec(String usuResSec) {
		UsuResSec = usuResSec;
	}

	public String getUsuLocLog() {
		return UsuLocLog;
	}

	public void setUsuLocLog(String usuLocLog) {
		UsuLocLog = usuLocLog;
	}

	public Date getUsuLasLog() {
		return UsuLasLog;
	}

	public void setUsuLasLog(Date usuLasLog) {
		UsuLasLog = usuLasLog;
	}

	public String getUsuAfi() {
		return UsuAfi;
	}

	public void setUsuAfi(String usuAfi) {
		UsuAfi = usuAfi;
	}

	public String getUsuCluFav() {
		return UsuCluFav;
	}

	public void setUsuCluFav(String usuCluFav) {
		UsuCluFav = usuCluFav;
	}

	public String getUsuSta() {
		return UsuSta;
	}

	public void setUsuSta(String usuSta) {
		UsuSta = usuSta;
	}
	
}
