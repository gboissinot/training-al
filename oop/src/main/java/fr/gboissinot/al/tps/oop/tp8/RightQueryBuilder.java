package fr.gboissinot.al.tps.oop.tp8;

import java.util.Objects;

final class RightQueryBuilder implements QueryBuilder{

    private String select;
    private String from;
    private String where;
    private String orderBy;

    public static QueryBuilder create() {
        return new RightQueryBuilder();
    }

    @Override
    public QueryBuilder select(String select) {
        RightQueryBuilder queryBuilder1 = new RightQueryBuilder();
        queryBuilder1.select = Objects.requireNonNull(select);
        queryBuilder1.from = from;
        queryBuilder1.where = where;
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    @Override
    public QueryBuilder from(String from) {
        RightQueryBuilder queryBuilder1 = new RightQueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = Objects.requireNonNull(from);
        queryBuilder1.where = where;
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    @Override
    public QueryBuilder where(String where) {
        RightQueryBuilder queryBuilder1 = new RightQueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = from;
        queryBuilder1.where = Objects.requireNonNull(where);
        queryBuilder1.orderBy = orderBy;
        return queryBuilder1;
    }

    @Override
    public QueryBuilder orderBy(String orderBy) {
        RightQueryBuilder queryBuilder1 = new RightQueryBuilder();
        queryBuilder1.select = select;
        queryBuilder1.from = from;
        queryBuilder1.where = where;
        queryBuilder1.orderBy = Objects.requireNonNull(orderBy);
        return queryBuilder1;
    }

    @Override
    public Query build() {
        return new Query(select, from, where, orderBy);
    }
}
