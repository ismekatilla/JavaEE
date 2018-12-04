package org.ismek;

public class Rehber {

	private String isim;
	private String telefon;
	
	

	public Rehber(String isim, String telefon) {
		super();
		this.isim = isim;
		this.telefon = telefon;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
}