package com.globallogic.javaacademy.hibernate.basic.converter;

import javax.persistence.AttributeConverter;

public class YesNoConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return attribute == Boolean.TRUE ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "Y".equals(dbData);
    }
}
