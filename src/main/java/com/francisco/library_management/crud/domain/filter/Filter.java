package com.francisco.library_management.crud.domain.filter;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Filter<T> {

	@NonNull
	private final String field;
	@NonNull
	private final T value;
	
}
