package org.ismek.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.ismek.domain.Actor;

public class ActorDao extends BaseDao<Actor> {
	
	private static Logger logger = LogManager.getLogger(ActorDao.class);
	
	public ActorDao() {
		super(Actor.class);
		// TODO Auto-generated constructor stub
	}
}