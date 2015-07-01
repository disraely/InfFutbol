package model;

import java.sql.Date;
import java.sql.Time;

public class Partido {
	private int ParIde; //cambiar de varchar to int
	private Torneo TorIde;
	private String ParRes;
	private Date ParFec;
	private Time ParHor;
	private String ParPriEqu;
	private String ParSegEqu;
	
	public Partido() {
		this.ParIde = 0;
		this.TorIde = new Torneo();
	}

	public Partido(int parIde, Torneo torIde, String parRes, Date parFec, Time parHor, String parPriEqu, String parSegEqu) {
		ParIde = parIde;
		TorIde = torIde;
		ParRes = parRes;
		ParFec = parFec;
		ParHor = parHor;
		ParPriEqu = parPriEqu;
		ParSegEqu = parSegEqu;
	}

	public int getParIde() {
		return ParIde;
	}

	public void setParIde(int parIde) {
		ParIde = parIde;
	}

	public Torneo getTorIde() {
		return TorIde;
	}

	public void setTorIde(Torneo torIde) {
		TorIde = torIde;
	}

	public String getParRes() {
		return ParRes;
	}

	public void setParRes(String parRes) {
		ParRes = parRes;
	}

	public Date getParFec() {
		return ParFec;
	}

	public void setParFec(Date parFec) {
		ParFec = parFec;
	}

	public Time getParHor() {
		return ParHor;
	}

	public void setParHor(Time parHor) {
		ParHor = parHor;
	}

	public String getParPriEqu() {
		return ParPriEqu;
	}

	public void setParPriEqu(String parPriEqu) {
		ParPriEqu = parPriEqu;
	}

	public String getParSegEqu() {
		return ParSegEqu;
	}

	public void setParSegEqu(String parSegEqu) {
		ParSegEqu = parSegEqu;
	}
	
}
