package fr.gboissinot.al.tps.oop.tp8;

public interface QueryBuilder {

    QueryBuilder select(String select);

    QueryBuilder from(String from);

    QueryBuilder where(String where);

    QueryBuilder orderBy(String orderBy);

    Query build();
}
