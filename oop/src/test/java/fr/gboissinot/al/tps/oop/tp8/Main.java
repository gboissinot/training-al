package fr.gboissinot.al.tps.oop.tp8;

public class Main {

    public static void main(String[] args) {

        //With wrong builder implementation
        System.out.println("With wrong implementations...");
        buildQueriesFromBuilders(WrongQueryBuilder.create());

        //With right builder implementation
        System.out.println("\nWith right implementations...");
        buildQueriesFromBuilders(RightQueryBuilder.create());
    }

    private static void buildQueriesFromBuilders(QueryBuilder queryBuilder) {
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
