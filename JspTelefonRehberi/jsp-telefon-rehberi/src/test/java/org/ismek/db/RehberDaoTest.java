package org.ismek.db;

import java.util.List;

import org.ismek.Rehber;
import org.junit.*;

public class RehberDaoTest {

	@Test
	public void rehbereEkle() {
		Rehber rehber = new Rehber("ABCDEF", "37487239");
		RehberDao rehberDao = new RehberDao();
		rehberDao.rehberEkle(rehber);
		System.out.println("Kayıt yapıldı");
	}
	
	@Test
	public void rehberdenGetir() {
		RehberDao rehberDao = new RehberDao();
		List<Rehber> rehberList = rehberDao.rehberListesiGetir();
		for (Rehber rehber : rehberList) {
			System.out.println(rehber.getIsim());
		}
	}
}