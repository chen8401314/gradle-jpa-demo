/*
 * This file is generated by jOOQ.
 */
package com.example.demo.jooq;


import com.example.demo.jooq.tables.PfTestT;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code></code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index PRIMARY_KEY_F = Indexes0.PRIMARY_KEY_F;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index PRIMARY_KEY_F = Internal.createIndex("PRIMARY_KEY_F", PfTestT.PF_TEST_T, new OrderField[] { PfTestT.PF_TEST_T.ID }, true);
    }
}