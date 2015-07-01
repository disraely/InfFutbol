package model;

public class Grupo {
	private int GruIde; //cambiar varchar to int
	private Torneo TorIde;
	private String GruNom;
	private int GruCan;
	
	public Grupo() {
		this.GruIde = 0;
		this.TorIde = new Torneo();
	}

	public Grupo(int gruIde, Torneo torIde, String gruNom, int gruCan) {
		super();
		GruIde = gruIde;
		TorIde = torIde;
		GruNom = gruNom;
		GruCan = gruCan;
	}

	public int getGruIde() {
		return GruIde;
	}

	public void setGruIde(int gruIde) {
		GruIde = gruIde;
	}

	public Torneo getTorIde() {
		return TorIde;
	}

	public void setTorIde(Torneo torIde) {
		TorIde = torIde;
	}

	public String getGruNom() {
		return GruNom;
	}

	public void setGruNom(String gruNom) {
		GruNom = gruNom;
	}

	public int getGruCan() {
		return GruCan;
	}

	public void setGruCan(int gruCan) {
		GruCan = gruCan;
	}
	
}
