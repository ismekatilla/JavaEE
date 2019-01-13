package org.ismek.ui;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ismek.domain.Kullanici;
import org.ismek.service.KullaniciService;

@ManagedBean
@RequestScoped
public class FilmMB {
	
	int id;
	String name;
	String email;
	String password;
	String gender;
	String address;
	ArrayList usersList;
	
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	Connection connection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Used to fetch all records
	public ArrayList usersList() {
		try {
			usersList = new ArrayList();
			
			KullaniciService kullaniciService = new KullaniciService();
			List<Kullanici> kullaniciList = kullaniciService.findAllKullanici();
			for (Kullanici kullanici : kullaniciList) {
				FilmMB user = new FilmMB();
				user.setId(kullanici.getId().intValue());
				user.setEmail(kullanici.getEmail());
				user.setGender(kullanici.getGender());
				user.setName(kullanici.getName());
				user.setPassword(kullanici.getPassword());
				usersList.add(user);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return usersList;
	}

	// Used to save user record
	public String save() {
		
		Kullanici kullanici = new Kullanici();
		kullanici.setEmail(email);
		kullanici.setName(name);
		kullanici.setPassword(password);
		kullanici.setAddress(address);
		kullanici.setGender(gender);
		
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici savedKullanici = kullaniciService.saveKullanici(kullanici);
		
		if (savedKullanici != null && savedKullanici.getId() != null)
			return "index.xhtml?faces-redirect=true";
		else
			return "create.xhtml?faces-redirect=true";
	}

	// Used to fetch record to update
	public String edit(int id) {
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici kullanici = kullaniciService.findById(new Long(id));
		
		FilmMB user = new FilmMB();
		user.setId(kullanici.getId().intValue());
		user.setEmail(kullanici.getEmail());
		user.setGender(kullanici.getGender());
		user.setName(kullanici.getName());
		user.setPassword(kullanici.getPassword());
		user.setAddress(kullanici.getAddress());
		sessionMap.put("editUser", user);
		
		return "/edit.xhtml?faces-redirect=true";
	}

	// Used to update user record
	public String update(FilmMB u) {
		KullaniciService kullaniciService = new KullaniciService();
		
		Kullanici kullanici = kullaniciService.findById(new Long(u.getId()));
		kullanici.setEmail(u.getEmail());
		kullanici.setName(u.getName());
		kullanici.setPassword(u.getPassword());
		kullanici.setAddress(u.getAddress());
		kullanici.setGender(u.getGender());
		kullaniciService.saveKullanici(kullanici);
		
		return "/index.xhtml?faces-redirect=true";
	}

	// Used to delete user record
	public void delete(int id) {
//		try {
//			connection = getConnection();
//			PreparedStatement stmt = connection.prepareStatement("delete from users where id = " + id);
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
	}

	// Used to set user gender
	public String getGenderName(char gender) {
		if (gender == 'M') {
			return "Male";
		} else
			return "Female";
	}
}