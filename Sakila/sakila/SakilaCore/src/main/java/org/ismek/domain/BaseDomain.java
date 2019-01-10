package org.ismek.domain;

import java.io.Serializable;

public abstract class BaseDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889000364527241263L;

	public abstract Long getId();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (getId() ^ (getId() >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDomain other = (BaseDomain) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}
}