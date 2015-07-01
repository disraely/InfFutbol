package model;

import java.sql.Date;

public class Integrante {
	private int IntIde; //varchar to int
	private Equipo EquIde;
	private String IntCar;
	private String IntNom;
	private String IntApe;
	private String intFot;
	private Date intNac;
	private String IntCluAct;
	private String IntPos;
	
	public Integrante() {
		this.IntIde = 0;
		this.EquIde = new Equipo();
	}

	public Integrante(int intIde, Equipo equIde, String intCar, String intNom, String intApe, String intFot, Date intNac, String intCluAct, String intPos) {
		super();
		IntIde = intIde;
		EquIde = equIde;
		IntCar = intCar;
		IntNom = intNom;
		IntApe = intApe;
		this.intFot = intFot;
		this.intNac = intNac;
		IntCluAct = intCluAct;
		IntPos = intPos;
	}

	public int getIntIde() {
		return IntIde;
	}

	public void setIntIde(int intIde) {
		IntIde = intIde;
	}

	public Equipo getEquIde() {
		return EquIde;
	}

	public void setEquIde(Equipo equIde) {
		EquIde = equIde;
	}

	public String getIntCar() {
		return IntCar;
	}

	public void setIntCar(String intCar) {
		IntCar = intCar;
	}

	public String getIntNom() {
		return IntNom;
	}

	public void setIntNom(String intNom) {
		IntNom = intNom;
	}

	public String getIntApe() {
		return IntApe;
	}

	public void setIntApe(String intApe) {
		IntApe = intApe;
	}

	public String getIntFot() {
		return intFot;
	}

	public void setIntFot(String intFot) {
		this.intFot = intFot;
	}

	public Date getIntNac() {
		return intNac;
	}

	public void setIntNac(Date intNac) {
		this.intNac = intNac;
	}

	public String getIntCluAct() {
		return IntCluAct;
	}

	public void setIntCluAct(String intCluAct) {
		IntCluAct = intCluAct;
	}

	public String getIntPos() {
		return IntPos;
	}

	public void setIntPos(String intPos) {
		IntPos = intPos;
	}
	
}
