package org.ismek.service;

import java.util.List;

import org.ismek.dao.ActorDao;
import org.ismek.domain.Actor;

public class ActorService {

	public List<Actor> findAllActor() {
		ActorDao actorDao = new ActorDao();
		return actorDao.findAllActor();
	}
}