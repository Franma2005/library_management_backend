package com.francisco.library_management.crud.infraestructure.filters.interfaces;

public interface MyCommand<T> {

	public boolean execute(T entity, Object value);
	
}
