package fr.gboissinot.al.tps.oop.tp8;

public class Main {

    public static void main(String[] args) {
        //With right builder implementation
        System.out.println("With right implementations...");
        build_queries_from_builders(RightQueryBuilder.create());

        //With wrong builder implementation
        System.out.println("\nWith wrong implementations...");
        build_queries_from_builders(WrongQueryBuilder.create());
    }

    private static void build_queries_from_builders(QueryBuilder queryBuilder) {
        var query1 = queryBuilder
                .select("SELECT ID, NAME")
                .from("T_USERS")
                .where("ID=4")
                .build();

        var query2 = queryBuilder
                .select("SELECT ID, NAME")
                .from("T_USERS")
                .build();

        System.out.println(query1);
        System.out.println(query2);
    }


}
