package org.ismek.service;

import java.util.List;
import java.util.stream.Collectors;

import org.ismek.dao.ActorDao;
import org.ismek.domain.Actor;

public class ActorService extends BaseService<Actor> {

	public ActorService() {
		super(Actor.class);
	}
	
	public List<Actor> findAllActorByName(String actorName) {
		ActorDao actorDao = new ActorDao();
		List<Actor> actorList = actorDao.findAll();
		List<Actor> actorListByName = 
				actorList
				.stream()
				.filter(actor -> actor.getFirstName().equals(actorName))
				.collect(Collectors.toList());
		return actorListByName;
	}
}