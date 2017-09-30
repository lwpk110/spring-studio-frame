package cn.spring.studio.data.jpa.converter;

import cn.spring.studio.util.JsonUtils;
import javax.persistence.AttributeConverter;

public class JsonAttributeConverter implements AttributeConverter<Object, String>{

    @Override
    public String convertToDatabaseColumn(Object attribute) {
        return JsonUtils.serialize(attribute);
    }

    @Override
    public Object convertToEntityAttribute(String dbData) {
        return JsonUtils.deserialize(dbData);
    }
}
