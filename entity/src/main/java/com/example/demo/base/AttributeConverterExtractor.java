package com.example.demo.base;

import org.hibernate.boot.Metadata;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.hibernate.jpa.boot.spi.IntegratorProvider;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Table;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.converter.AttributeConverterTypeAdapter;
import org.jooq.Name;
import org.jooq.tools.JooqLogger;

import javax.persistence.AttributeConverter;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import java.util.*;

import static org.jooq.impl.DSL.name;

public class AttributeConverterExtractor implements Integrator {

    static final JooqLogger log = JooqLogger.getLogger(JPADatabase.class);

    private Metadata meta;
    private JPADatabase database;
    private Collection<? extends Class<?>> classes;

    AttributeConverterExtractor(JPADatabase database, Collection<? extends Class<?>> classes) {
        this.database = database;
        this.classes = classes;
    }

    @Override
    public final void integrate(Metadata m, SessionFactoryImplementor f, SessionFactoryServiceRegistry r) {
        this.meta = m;
    }

    @Override
    public final void disintegrate(SessionFactoryImplementor f, SessionFactoryServiceRegistry r) {
    }

    @SuppressWarnings("unchecked")
    final Map<Name, AttributeConverter<?, ?>> extract() {
        Map<Name, AttributeConverter<?, ?>> result = new LinkedHashMap<>();

        initEntityManagerFactory();
        for (PersistentClass persistentClass : meta.getEntityBindings()) {
            Table table = persistentClass.getTable();

            Iterator<Property> propertyIterator = persistentClass.getPropertyIterator();

            propertyLoop:
            while (propertyIterator.hasNext()) {
                Property property = propertyIterator.next();
                Type type = property.getValue().getType();

                if (type instanceof AttributeConverterTypeAdapter) {
                    AttributeConverter<?, ?> converter
                        = ((AttributeConverterTypeAdapter<?>) type).getAttributeConverter().getConverterBean().getBeanInstance();
                    Iterator<Column> columnIterator = property.getColumnIterator();

                    if (columnIterator.hasNext()) {
                        Column column = columnIterator.next();

                        if (columnIterator.hasNext()) {
                            log.info("AttributeConverter", "Cannot apply AttributeConverter of property " + property + " on several columns.");
                            continue propertyLoop;
                        }

                        result.put(name(table.getCatalog(), table.getSchema(), table.getName(), column.getName()), converter);
                    }
                }
            }
        }

        return result;
    }

    private final EntityManagerFactory initEntityManagerFactory() {
        PersistenceUnitInfo persistenceUnitInfo = persistenceUnitInfo(getClass().getSimpleName());
        Map<String, Object> configuration = new HashMap<>();
        configuration.put("hibernate.integrator_provider", integratorProvider());
        configuration.put(AvailableSettings.CONNECTION_PROVIDER, database.connectionProvider());
        PersistenceUnitInfoDescriptor descriptor = new PersistenceUnitInfoDescriptor(persistenceUnitInfo);
        return new EntityManagerFactoryBuilderImpl(descriptor, configuration).build();
    }

    private IntegratorProvider integratorProvider() {
        return new IntegratorProvider() {
            @Override
            public List<Integrator> getIntegrators() {
                return Collections.<Integrator>singletonList(AttributeConverterExtractor.this);
            }
        };
    }

    private final PersistenceUnitInfoImpl persistenceUnitInfo(String name) {
        return new PersistenceUnitInfoImpl(name, entityClassNames(), properties());
    }

    private final Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", JPADatabase.HIBERNATE_DIALECT);
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }

    private final List<String> entityClassNames() {
        List<String> result = new ArrayList<>(classes.size());

        for (Class<?> klass : classes) {
            result.add(klass.getName());
        }

        return result;
    }
}
