package org.ismek;

public class Rehber {

	static int sayac = 0;
	private Long id;
	private String isim;
	private String telefon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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