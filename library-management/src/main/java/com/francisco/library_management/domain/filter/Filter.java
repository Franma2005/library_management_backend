package com.francisco.library_management.domain.filter;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Filter {

	@NonNull
	private final String field;
	@NonNull
	private final String value;
	
}
