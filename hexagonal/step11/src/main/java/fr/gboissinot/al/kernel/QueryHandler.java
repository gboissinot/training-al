package fr.gboissinot.al.kernel;

public interface QueryHandler<Q extends Query, R> {
    R handle(Q query);
}
