package model;

public class Equipo {
	private int EquIde;  //int to varchar
	private Grupo GruIde;
	private String EquNom;
	private String EquBan;
	private int ParJug;
	private int ParGan;
	private int ParEmp;
	private int GolFav;
	private int GolCon;
	private int EquPun;
	private int ParPer;
	
	public Equipo() {
		this.EquIde = 0;
		this.GruIde = new Grupo();
	}

	public Equipo(int equIde, Grupo gruIde, String equNom, String equBan, int parJug, int parGan, int parEmp, int golFav, int golCon, int equPun, int parPer) {
		EquIde = equIde;
		GruIde = gruIde;
		EquNom = equNom;
		EquBan = equBan;
		ParJug = parJug;
		ParGan = parGan;
		ParEmp = parEmp;
		GolFav = golFav;
		GolCon = golCon;
		EquPun = equPun;
		ParPer = parPer;
	}

	public int getEquIde() {
		return EquIde;
	}

	public void setEquIde(int equIde) {
		EquIde = equIde;
	}

	public Grupo getGruIde() {
		return GruIde;
	}

	public void setGruIde(Grupo gruIde) {
		GruIde = gruIde;
	}

	public String getEquNom() {
		return EquNom;
	}

	public void setEquNom(String equNom) {
		EquNom = equNom;
	}

	public String getEquBan() {
		return EquBan;
	}

	public void setEquBan(String equBan) {
		EquBan = equBan;
	}

	public int getParJug() {
		return ParJug;
	}

	public void setParJug(int parJug) {
		ParJug = parJug;
	}

	public int getParGan() {
		return ParGan;
	}

	public void setParGan(int parGan) {
		ParGan = parGan;
	}

	public int getParEmp() {
		return ParEmp;
	}

	public void setParEmp(int parEmp) {
		ParEmp = parEmp;
	}

	public int getGolFav() {
		return GolFav;
	}

	public void setGolFav(int golFav) {
		GolFav = golFav;
	}

	public int getGolCon() {
		return GolCon;
	}

	public void setGolCon(int golCon) {
		GolCon = golCon;
	}

	public int getEquPun() {
		return EquPun;
	}

	public void setEquPun(int equPun) {
		EquPun = equPun;
	}

	public int getParPer() {
		return ParPer;
	}

	public void setParPer(int parPer) {
		ParPer = parPer;
	}
		
}
