package org.improving.tag;


import org.improving.tag.items.UniqueItems;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class UniqueItemConverter implements AttributeConverter<UniqueItems, String> {

    public String convertToDatabaseColumn(UniqueItems items) {
        return items.getName();
    }

    @Override
    public UniqueItems convertToEntityAttribute(String string) {
        return null;
    }


}
