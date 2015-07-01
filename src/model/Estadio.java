package model;

public class Estadio {
	private int EstIde;
	private Torneo TorIde;
	private String EstLug;
	private String EstNom;
	private String EstCap;
	private String EstImg;
	
	public Estadio() {
		this.EstIde = 0;
		this.TorIde = new Torneo();
	}

	public Estadio(int estIde, Torneo torIde, String estLug, String estNom, String estCap, String estImg) {
		EstIde = estIde;
		TorIde = torIde;
		EstLug = estLug;
		EstNom = estNom;
		EstCap = estCap;
		EstImg = estImg;
	}

	public int getEstIde() {
		return EstIde;
	}

	public void setEstIde(int estIde) {
		EstIde = estIde;
	}

	public Torneo getTorIde() {
		return TorIde;
	}

	public void setTorIde(Torneo torIde) {
		TorIde = torIde;
	}

	public String getEstLug() {
		return EstLug;
	}

	public void setEstLug(String estLug) {
		EstLug = estLug;
	}

	public String getEstNom() {
		return EstNom;
	}

	public void setEstNom(String estNom) {
		EstNom = estNom;
	}

	public String getEstCap() {
		return EstCap;
	}

	public void setEstCap(String estCap) {
		EstCap = estCap;
	}

	public String getEstImg() {
		return EstImg;
	}

	public void setEstImg(String estImg) {
		EstImg = estImg;
	}
	
}
