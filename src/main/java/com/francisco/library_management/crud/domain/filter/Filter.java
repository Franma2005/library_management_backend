package com.francisco.library_management.crud.domain.filter;

import lombok.NonNull;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@ToString
public class Filter<T> {

	@NonNull
	private final String field;
	@NonNull
	private final T value;
	
}
