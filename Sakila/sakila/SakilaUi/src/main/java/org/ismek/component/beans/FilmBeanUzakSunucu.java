package org.ismek.component.beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.ismek.dto.SakilaFilmDto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

@ManagedBean(name = "filmMBUS")
public class FilmBeanUzakSunucu {

	public List<SakilaFilmDto> findAll() {
		try {

			URL url = new URL("http://10.1.8.22:8080/SakilaUi/rest/film/list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String json = "";
			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				json += output;
			}
			
			Type listType = new TypeToken<List<SakilaFilmDto>>(){}.getType();
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
			       public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			           return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
			        } 
			     }).create();
			
			conn.disconnect();
			return (List<SakilaFilmDto>) gson.fromJson(json, listType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
