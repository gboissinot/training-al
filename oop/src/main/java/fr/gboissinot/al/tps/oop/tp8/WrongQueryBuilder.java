package fr.gboissinot.al.tps.oop.tp8;

import java.util.Objects;

final class WrongQueryBuilder implements QueryBuilder {

    private String select;
    private String from;
    private String where;
    private String orderBy;

    public static WrongQueryBuilder create() {
        return new WrongQueryBuilder();
    }

    @Override
    public QueryBuilder select(String select) {
        this.select = Objects.requireNonNull(select);
        return this;
    }

    @Override
    public WrongQueryBuilder from(String from) {
        this.from = Objects.requireNonNull(from);
        return this;
    }

    @Override
    public QueryBuilder where(String where) {
        this.where = Objects.requireNonNull(where);
        return this;
    }

    @Override
    public QueryBuilder orderBy(String orderBy) {
        this.orderBy = Objects.requireNonNull(orderBy);
        return this;
    }

    @Override
    public Query build() {
        return new Query(select, from, where, orderBy);
    }
}
