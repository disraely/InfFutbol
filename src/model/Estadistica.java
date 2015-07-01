package model;

public class Estadistica {
										
	private int EstIde;
	private int ParIde;
	private String EstSegEqu;
	private int EstSegTarRoj;
	private int EstSegTarAma;
	private int EstSegTirDir;
	private int EstSegTirInd;
	private int EstSegTirEsq;
	private int EstSegFueJue;
	private String EstPriEqu;
	private int EstPriTarRoj;
	private int EstPriTarAma;
	private int EstPriTirDir;
	private int EstPriTirInd;
	private int EstPriTirEsq;
	private int EstPriFueJue;
	private Partido partido;
	
	public Estadistica() {
		this.EstIde = 0;
		this.partido = new Partido();
	}

	public Estadistica(int estIde, int parIde, String estSegEqu, int estSegTarRoj, int estSegTarAma, int estSegTirDir, int estSegTirInd, int estSegTirEsq, int estSegFueJue, String estPriEqu, int estPriTarRoj, int estPriTarAma, int estPriTirDir, int estPriTirInd, int estPriTirEsq, int estPriFueJue, Partido partido) {
		EstIde = estIde;
		ParIde = parIde;
		EstSegEqu = estSegEqu;
		EstSegTarRoj = estSegTarRoj;
		EstSegTarAma = estSegTarAma;
		EstSegTirDir = estSegTirDir;
		EstSegTirInd = estSegTirInd;
		EstSegTirEsq = estSegTirEsq;
		EstSegFueJue = estSegFueJue;
		EstPriEqu = estPriEqu;
		EstPriTarRoj = estPriTarRoj;
		EstPriTarAma = estPriTarAma;
		EstPriTirDir = estPriTirDir;
		EstPriTirInd = estPriTirInd;
		EstPriTirEsq = estPriTirEsq;
		EstPriFueJue = estPriFueJue;
		this.partido = partido;
	}

	public int getEstIde() {
		return EstIde;
	}

	public void setEstIde(int estIde) {
		EstIde = estIde;
	}

	public int getParIde() {
		return ParIde;
	}

	public void setParIde(int parIde) {
		ParIde = parIde;
	}

	public String getEstSegEqu() {
		return EstSegEqu;
	}

	public void setEstSegEqu(String estSegEqu) {
		EstSegEqu = estSegEqu;
	}

	public int getEstSegTarRoj() {
		return EstSegTarRoj;
	}

	public void setEstSegTarRoj(int estSegTarRoj) {
		EstSegTarRoj = estSegTarRoj;
	}

	public int getEstSegTarAma() {
		return EstSegTarAma;
	}

	public void setEstSegTarAma(int estSegTarAma) {
		EstSegTarAma = estSegTarAma;
	}

	public int getEstSegTirDir() {
		return EstSegTirDir;
	}

	public void setEstSegTirDir(int estSegTirDir) {
		EstSegTirDir = estSegTirDir;
	}

	public int getEstSegTirInd() {
		return EstSegTirInd;
	}

	public void setEstSegTirInd(int estSegTirInd) {
		EstSegTirInd = estSegTirInd;
	}

	public int getEstSegTirEsq() {
		return EstSegTirEsq;
	}

	public void setEstSegTirEsq(int estSegTirEsq) {
		EstSegTirEsq = estSegTirEsq;
	}

	public int getEstSegFueJue() {
		return EstSegFueJue;
	}

	public void setEstSegFueJue(int estSegFueJue) {
		EstSegFueJue = estSegFueJue;
	}

	public String getEstPriEqu() {
		return EstPriEqu;
	}

	public void setEstPriEqu(String estPriEqu) {
		EstPriEqu = estPriEqu;
	}

	public int getEstPriTarRoj() {
		return EstPriTarRoj;
	}

	public void setEstPriTarRoj(int estPriTarRoj) {
		EstPriTarRoj = estPriTarRoj;
	}

	public int getEstPriTarAma() {
		return EstPriTarAma;
	}

	public void setEstPriTarAma(int estPriTarAma) {
		EstPriTarAma = estPriTarAma;
	}

	public int getEstPriTirDir() {
		return EstPriTirDir;
	}

	public void setEstPriTirDir(int estPriTirDir) {
		EstPriTirDir = estPriTirDir;
	}

	public int getEstPriTirInd() {
		return EstPriTirInd;
	}

	public void setEstPriTirInd(int estPriTirInd) {
		EstPriTirInd = estPriTirInd;
	}

	public int getEstPriTirEsq() {
		return EstPriTirEsq;
	}

	public void setEstPriTirEsq(int estPriTirEsq) {
		EstPriTirEsq = estPriTirEsq;
	}

	public int getEstPriFueJue() {
		return EstPriFueJue;
	}

	public void setEstPriFueJue(int estPriFueJue) {
		EstPriFueJue = estPriFueJue;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
}
