package org.ismek.ui;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.ismek.domain.Kullanici;
import org.ismek.service.KullaniciService;

@ManagedBean(name = "userMB")
@RequestScoped
public class User {
	int id;
	String name;
	String email;
	String password;
	String gender;
	String address;

	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

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
	public ArrayList<Kullanici> usersList() {
		try {
			KullaniciService kullaniciService = new KullaniciService();
			return (ArrayList<Kullanici>) kullaniciService.findAllKullanici();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
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
		if (savedKullanici != null)
			return "index.xhtml?faces-redirect=true";
		else
			return "create.xhtml?faces-redirect=true";
	}

	// Used to fetch record to update
	public String edit(int id) {
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici kullanici = kullaniciService.findById(new Long(id));
		User user = new User();
		user.setId(kullanici.getId().intValue());
		user.setEmail(kullanici.getEmail());
		user.setName(kullanici.getName());
		user.setPassword(kullanici.getPassword());
		user.setAddress(kullanici.getAddress());
		
		sessionMap.put("editUser", user);
		return "/edit.xhtml?faces-redirect=true";
	}

	// Used to update user record
	public String update(User user) {
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici kullanici = kullaniciService.findById(new Long(user.getId()));
		kullanici.setAddress(user.getAddress());
		kullanici.setEmail(user.getEmail());
		kullanici.setGender(user.getGender());
		kullanici.setName(user.getName());
		kullanici.setPassword(user.getPassword());
		kullaniciService.saveKullanici(kullanici);
		return "/index.xhtml?faces-redirect=true";
	}

	// Used to delete user record
	public void delete(int id) {
		try {
			KullaniciService kullaniciService = new KullaniciService();
			Kullanici kullanici = kullaniciService.findById(new Long(id));
			kullaniciService.deleteKullanici(kullanici);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Used to set user gender
	public String getGenderName(char gender) {
		if (gender == 'M') {
			return "Male";
		} else if (gender == 'F') {
			return "Female";
		} else return "";
	}
}