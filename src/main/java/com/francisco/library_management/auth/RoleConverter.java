package com.francisco.library_management.auth;

import com.francisco.library_management.auth.domain.model.Role;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {
    @Override
    public String convertToDatabaseColumn(Role role) {
        return (role == null) ? null : role.name();
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return (dbData == null) ? null : Role.valueOf(dbData);
    }
}