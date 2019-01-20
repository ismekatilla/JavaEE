package org.ismek.dto;

import java.math.BigInteger;

public class FilmRatingDto {

	private String rating;
	private BigInteger count;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public BigInteger getCount() {
		return count;
	}

	public void setCount(BigInteger count) {
		this.count = count;
	}
}