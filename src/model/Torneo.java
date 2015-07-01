package model;

import java.sql.Date;

public class Torneo {
	private int Toride;
	private String TorNom;
	private String TorLog;
	private String TorOrg;
	private Date TorFecIni;
	private Date TorFecFin;
	private String TorTip;
	
	public Torneo() {
		this.Toride = 0;
	}

	public Torneo(int toride, String torNom, String torLog, String torOrg, Date torFecIni, Date torFecFin, String torTip) {
		Toride = toride;
		TorNom = torNom;
		TorLog = torLog;
		TorOrg = torOrg;
		TorFecIni = torFecIni;
		TorFecFin = torFecFin;
		TorTip = torTip;
	}

	public int getToride() {
		return Toride;
	}

	public void setToride(int toride) {
		Toride = toride;
	}

	public String getTorNom() {
		return TorNom;
	}

	public void setTorNom(String torNom) {
		TorNom = torNom;
	}

	public String getTorLog() {
		return TorLog;
	}

	public void setTorLog(String torLog) {
		TorLog = torLog;
	}

	public String getTorOrg() {
		return TorOrg;
	}

	public void setTorOrg(String torOrg) {
		TorOrg = torOrg;
	}

	public Date getTorFecIni() {
		return TorFecIni;
	}

	public void setTorFecIni(Date torFecIni) {
		TorFecIni = torFecIni;
	}

	public Date getTorFecFin() {
		return TorFecFin;
	}

	public void setTorFecFin(Date torFecFin) {
		TorFecFin = torFecFin;
	}

	public String getTorTip() {
		return TorTip;
	}

	public void setTorTip(String torTip) {
		TorTip = torTip;
	}
	
}
