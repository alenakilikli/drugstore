package com.example.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleTypeConverter implements AttributeConverter<Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Role roleType) {
        return roleType == null ? null : roleType.getRoleId();
    }

    @Override
    public Role convertToEntityAttribute(Integer integer) {
        return integer == null ? null : Role.findById(integer);
    }
}
