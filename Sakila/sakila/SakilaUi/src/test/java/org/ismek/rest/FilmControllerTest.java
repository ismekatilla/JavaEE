package org.ismek.rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.ismek.domain.Film;
import org.ismek.domain.Language;
import org.ismek.service.LanguageService;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class FilmControllerTest {

	@Test
	public void findAllFilmTest() {
		try {

			URL url = new URL("http://localhost:8080/SakilaUi/rest/film/list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void findById() {
		try {

			URL url = new URL("http://localhost:8080/SakilaUi/rest/film/findById");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			String input = "filmId=13";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void saveFilm() {
		try {

			URL url = new URL("http://localhost:8080/SakilaUi/rest/film/saveFilm");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			LanguageService languageService = new LanguageService();
			Language language = languageService.findById(1L);
			
			Film film = new Film();
			film.setTitle("Rest İstek Filmi");
			film.setDescription("Rest description");
			film.setLanguage(language);
			
			Gson gson = new Gson();
			String input = gson.toJson(film);

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listAnother() {
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
			
			Type listType = new TypeToken<List<FilmDto>>(){}.getType();
			Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() { 
			       public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
			           return new Date(jsonElement.getAsJsonPrimitive().getAsLong()); 
			        } 
			     }).create();
			
			List<FilmDto> filmList = (List<FilmDto>) gson.fromJson(json, listType);
			for (FilmDto filmDto : filmList) {
				System.out.println(filmDto.getTitle());
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}