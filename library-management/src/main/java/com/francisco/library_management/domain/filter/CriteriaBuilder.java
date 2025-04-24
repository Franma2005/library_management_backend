package com.francisco.library_management.domain.filter;

import java.util.Optional;

public class CriteriaBuilder {

	private final Criteria criteria = new Criteria();
	
	public CriteriaBuilder() {}
	
	public <T> CriteriaBuilder addFilterIfPresent(String field, Optional<T> valueOptional) {
		valueOptional.ifPresent(
				value -> criteria.addFilter(new Filter<T>(field, value))
		);
		return this;
	}
	
	public Criteria build() {
		return criteria;
	}
}
