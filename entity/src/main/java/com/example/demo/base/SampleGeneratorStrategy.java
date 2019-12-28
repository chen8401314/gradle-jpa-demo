package com.example.demo.base;


import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.CatalogDefinition;
import org.jooq.meta.Definition;
import org.jooq.meta.SchemaDefinition;
import org.jooq.tools.StringUtils;

public final   class SampleGeneratorStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        String name = getFixedJavaClassName(definition);
        return name != null ? name : this.getJavaClassName0(definition, mode);
    }

    private String getJavaClassName0(Definition definition, Mode mode) {
        StringBuilder result = new StringBuilder();
        result.append(StringUtils.toCamelCase(definition.getOutputName().replaceAll("(^pf_|PF_)|(_t|_T)","")));
        if (mode == Mode.RECORD) {
            result.append("Record");
        } else if (mode == Mode.DAO) {
            result.append("Dao");
        } else if (mode == Mode.POJO) {
            result.append("Bo");
        } else if (mode == Mode.INTERFACE) {
            result.insert(0, "I");
        }else{
            result.append("Table");
        }
        return result.toString();
    }
    final String getFixedJavaClassName(Definition definition) {
        if (definition instanceof CatalogDefinition && ((CatalogDefinition) definition).isDefaultCatalog()) {
            return "DefaultCatalog";
        } else {
            return definition instanceof SchemaDefinition && ((SchemaDefinition) definition).isDefaultSchema() ? "DefaultSchema" : null;
        }
    }

}
