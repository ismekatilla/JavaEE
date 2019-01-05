package org.ismek.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Actor;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ActorServiceTest {

	private static Logger logger = LogManager.getLogger(ActorServiceTest.class);

	ActorService actorService = new ActorService();

	@Test
	public void findAllActorTest() {
		List<Actor> actorList = actorService.findAll();
		for (Actor actor : actorList) {
			System.out.println(actor.getFirstName());
		}
	}

	@Test
	public void findAllActorByNameTest() {
		ActorService actorService = new ActorService();
		List<Actor> findAllActorByName = actorService.findAllActorByName("PENELOPE");
		for (Actor actor : findAllActorByName) {
			System.out.println(actor.getLastName());
		}
	}

	@Test
	public void saveActorTest() {

		Actor actor = new Actor();
		actor.setFirstName("Test1");
		actor.setLastName("Test1 Soyad");
		actor.setLastUpdate(new Date());

		ActorService actorService = new ActorService();
		Actor savedActor = actorService.save(actor);
		System.out.println(savedActor.getId());
	}

	@Test
	public void saveActorByIdTest() {

		ActorService actorService = new ActorService();

		Actor actor = actorService.findById(3L);
		actor.setFirstName("Test3");
		actor.setLastName("Test3 Soyad");

		Actor savedActor = actorService.save(actor);
		System.out.println(savedActor.getId());
	}

	@Test
	public void findById() {
		ActorService actorService = new ActorService();
		Actor actor = actorService.findById(2L);
		System.out.println(actor.getFirstName());
	}
}