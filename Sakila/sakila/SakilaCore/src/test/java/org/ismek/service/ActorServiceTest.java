package org.ismek.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Actor;
import org.junit.Test;

public class ActorServiceTest {
	
	private static Logger logger = LogManager.getLogger(ActorServiceTest.class);

	@Test
	public void findAllActor() {
		ActorService actorService = new ActorService();
		List<Actor> actorList = actorService.findAllActor();
		for (Actor actor : actorList) {
			System.out.println(actor.getFirstName());
		}
	}
}