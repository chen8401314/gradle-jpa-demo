package com.example.demo.base;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, Timestamp> {
    @Override
    public ZonedDateTime convertToEntityAttribute(Timestamp attribute) {
        if (attribute == null) {
            return null;
        }
        Instant instant = Instant.ofEpochMilli(attribute.getTime()).plusNanos(attribute.getNanos() % 1000000);
        return ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }

    @Override
    public Timestamp convertToDatabaseColumn(ZonedDateTime dbData) {
        if (dbData == null) {
            return null;
        }
        return Timestamp.from(dbData.toInstant());
    }
}
