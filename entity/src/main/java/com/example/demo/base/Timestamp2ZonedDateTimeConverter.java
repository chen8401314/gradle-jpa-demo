package com.example.demo.base;

import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import org.jooq.Converter;
public class Timestamp2ZonedDateTimeConverter  implements Converter<Timestamp, ZonedDateTime> {
    @Override
    public ZonedDateTime from(Timestamp databaseObject) {
        return databaseObject == null ? null : ZonedDateTime.ofInstant(databaseObject.toInstant(), ZoneOffset.UTC);
    }

    @Override
    public Timestamp to(ZonedDateTime userObject) {
        return userObject == null ? null : Timestamp.from(userObject.toInstant());
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<ZonedDateTime> toType() {
        return ZonedDateTime.class;
    }
}
