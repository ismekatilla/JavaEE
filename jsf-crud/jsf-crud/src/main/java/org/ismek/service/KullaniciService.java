package org.ismek.service;

import java.util.List;

import org.ismek.dao.KullaniciDao;
import org.ismek.domain.Kullanici;

public class KullaniciService {
	
	public List<Kullanici> findAllKullanici() {
		KullaniciDao kullaniciDao = new KullaniciDao();
		return kullaniciDao.findAll();
	}
	
	public Kullanici findById(Long kullaniciId) {
		KullaniciDao kullaniciDao = new KullaniciDao();
		return kullaniciDao.findById(kullaniciId);
	}
	
	public Kullanici saveKullanici(Kullanici kullanici) {
		KullaniciDao kullaniciDao = new KullaniciDao();
		return kullaniciDao.save(kullanici);
	}
}