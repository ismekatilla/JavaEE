package org.ismek.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.ismek.domain.Kullanici;
import org.ismek.service.KullaniciService;

@Path("/kullanici")
public class KullaniciController {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllKullaniciList() {
		KullaniciService kullaniciService = new KullaniciService();
		List<Kullanici> kullaniciList = kullaniciService.findAllKullanici();
		return Response.status(200).entity(kullaniciList).build();
	}
}