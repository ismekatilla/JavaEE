package org.ismek.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.Rehber;

public class RehberDao {

	private static Logger logger = LogManager.getLogger(RehberDao.class);
	
	public void rehberEkle(Rehber rehber) {
		
		try (Connection connetion = IsmekConnection.getConnetion()){
			PreparedStatement prepareStatement = connetion.prepareStatement("insert into rehber (isim, telefon) values (?, ?)");
			prepareStatement.setString(1, rehber.getIsim());
			prepareStatement.setString(2, rehber.getTelefon());
			prepareStatement.executeUpdate();
			String kullanici = "DENEME";
			logger.info(kullanici + " tarafından kayıt yapıldı");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Rehber> rehberListesiGetir() {
		
		List<Rehber> rehberList = new ArrayList<Rehber>();
		try (Connection connetion = IsmekConnection.getConnetion()){
			PreparedStatement prepareStatement = connetion.prepareStatement("Select * From rehber");
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				String isim = resultSet.getString(2);
				String telefon = resultSet.getString(3);
				Rehber rehber = new Rehber(isim, telefon);
				rehberList.add(rehber);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return rehberList;
	}
}
