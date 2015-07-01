package model;

import java.sql.Date;

public class Nota {
	private int NotIde;
	private int EstIde;
	private int UsuIde;
	private String NotFue;
	private Date NotFec;
	private String NotTit;
	private String NotDes;
	private Usuario usuario;
	private Estadistica estadistica;
	
	public Nota() {
		this.NotIde = 0;
		this.estadistica = new Estadistica();
		this.usuario = new Usuario();
	}

	public Nota(int notIde, int estIde, int usuIde, String notFue, Date notFec, String notTit, String notDes, Usuario usuario, Estadistica estadistica) {
		NotIde = notIde;
		EstIde = estIde;
		UsuIde = usuIde;
		NotFue = notFue;
		NotFec = notFec;
		NotTit = notTit;
		NotDes = notDes;
		this.usuario = usuario;
		this.estadistica = estadistica;
	}

	public int getNotIde() {
		return NotIde;
	}

	public void setNotIde(int notIde) {
		NotIde = notIde;
	}

	public int getEstIde() {
		return EstIde;
	}

	public void setEstIde(int estIde) {
		EstIde = estIde;
	}

	public int getUsuIde() {
		return UsuIde;
	}

	public void setUsuIde(int usuIde) {
		UsuIde = usuIde;
	}

	public String getNotFue() {
		return NotFue;
	}

	public void setNotFue(String notFue) {
		NotFue = notFue;
	}

	public Date getNotFec() {
		return NotFec;
	}

	public void setNotFec(Date notFec) {
		NotFec = notFec;
	}

	public String getNotTit() {
		return NotTit;
	}

	public void setNotTit(String notTit) {
		NotTit = notTit;
	}

	public String getNotDes() {
		return NotDes;
	}

	public void setNotDes(String notDes) {
		NotDes = notDes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Estadistica getEstadistica() {
		return estadistica;
	}

	public void setEstadistica(Estadistica estadistica) {
		this.estadistica = estadistica;
	}
	
}
