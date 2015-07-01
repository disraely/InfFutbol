package model;

public class Imagen {
	
	private int ImgIde;
	private int TorIde;
	private int EstIde;
	private int EquIde;
	private int IntIde;
	private int NotIde;
	private int UsuIde;
	private String ImgNom;
	private String ImgRut;
	private String ImgDes;
	private Torneo torneo;
	private Estadio estadio;
	private Equipo equipo;
	private Integrante integrante;
	private Nota nota;
	private Usuario usuario;
	
	public Imagen() {
		this.ImgIde = 0;;
		this.TorIde = 1;
		this.EstIde = 1;
		this.EquIde = 1;
		this.IntIde = 1;
		this.NotIde = 1;
		this.UsuIde = 1;
		this.ImgDes = "";
		this.torneo = new Torneo();
		this.estadio = new Estadio();
		this.equipo = new Equipo();
		this.integrante = new Integrante();
		this.nota = new Nota();
		this.usuario = new Usuario();
	}

	public Imagen(int imgIde, int torIde, int estIde, int equIde, int intIde, int notIde, int usuIde, String imgNom, String imgRut, String imgDes, Torneo torneo, Estadio estadio, Equipo equipo, Integrante integrante, Nota nota, Usuario usuario) {
		ImgIde = imgIde;
		TorIde = torIde;
		EstIde = estIde;
		EquIde = equIde;
		IntIde = intIde;
		NotIde = notIde;
		UsuIde = usuIde;
		ImgNom = imgNom;
		ImgRut = imgRut;
		ImgDes = imgDes;
		this.torneo = torneo;
		this.estadio = estadio;
		this.equipo = equipo;
		this.integrante = integrante;
		this.nota = nota;
		this.usuario = usuario;
	}

	public int getImgIde() {
		return ImgIde;
	}

	public void setImgIde(int imgIde) {
		ImgIde = imgIde;
	}

	public int getTorIde() {
		return TorIde;
	}

	public void setTorIde(int torIde) {
		TorIde = torIde;
	}

	public int getEstIde() {
		return EstIde;
	}

	public void setEstIde(int estIde) {
		EstIde = estIde;
	}

	public int getEquIde() {
		return EquIde;
	}

	public void setEquIde(int equIde) {
		EquIde = equIde;
	}

	public int getIntIde() {
		return IntIde;
	}

	public void setIntIde(int intIde) {
		IntIde = intIde;
	}

	public int getNotIde() {
		return NotIde;
	}

	public void setNotIde(int notIde) {
		NotIde = notIde;
	}

	public int getUsuIde() {
		return UsuIde;
	}

	public void setUsuIde(int usuIde) {
		UsuIde = usuIde;
	}

	public String getImgNom() {
		return ImgNom;
	}

	public void setImgNom(String imgNom) {
		ImgNom = imgNom;
	}

	public String getImgRut() {
		return ImgRut;
	}

	public void setImgRut(String imgRut) {
		ImgRut = imgRut;
	}

	public String getImgDes() {
		return ImgDes;
	}

	public void setImgDes(String imgDes) {
		ImgDes = imgDes;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Integrante getIntegrante() {
		return integrante;
	}

	public void setIntegrante(Integrante integrante) {
		this.integrante = integrante;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
