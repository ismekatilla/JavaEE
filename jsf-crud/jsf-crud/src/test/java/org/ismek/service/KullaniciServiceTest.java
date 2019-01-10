package org.ismek.service;

import java.util.List;

import org.ismek.domain.Kullanici;
import org.ismek.service.KullaniciService;
import org.junit.Test;

public class KullaniciServiceTest {

	@Test
	public void findAllTest() {
		KullaniciService kullaniciService = new KullaniciService();
		List<Kullanici> kullaniciList = kullaniciService.findAllKullanici();
		for (Kullanici kullanici : kullaniciList) {
			System.out.println(kullanici.getName());
		}
	}
	
	@Test
	public void saveTest() {
		
		Kullanici kullanici = new Kullanici();
		kullanici.setName("AHMET");
		
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici savedKullanici = kullaniciService.saveKullanici(kullanici);
		System.out.println(savedKullanici.getId());
	}
}
