package org.ismek.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ismek.domain.Kullanici;
import org.ismek.service.KullaniciService;

@Path("/kullanici")
public class KullaniciController {

	@POST
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllKullaniciList() {
		KullaniciService kullaniciService = new KullaniciService();
		List<Kullanici> kullaniciList = kullaniciService.findAllKullanici();
		return Response.status(200).entity(kullaniciList).build();
	}
	
	@GET
	@Path("/findById/{kullaniciId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam(value = "kullaniciId") Long kullaniciId) {
		KullaniciService kullaniciService = new KullaniciService();
		Kullanici kullanici = kullaniciService.findById(kullaniciId);
		return Response.status(200).entity(kullanici).build();
	}
}