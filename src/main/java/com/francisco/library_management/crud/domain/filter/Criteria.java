package com.francisco.library_management.crud.domain.filter;

import java.util.ArrayList;
import java.util.List;

public class Criteria {

	private List<Filter<?>> filters;
	
	public Criteria() {
		filters = new ArrayList<>();
	}
	
	public void addFilter(Filter<?> filter) {
		filters.add(filter);
	}
	
	public List<Filter<?>> getFilter() {
		return filters;
	}
}
