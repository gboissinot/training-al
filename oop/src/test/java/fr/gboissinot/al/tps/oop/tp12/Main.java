package fr.gboissinot.al.tps.oop.tp12;

public class Main {

    public static void main(String[] args) {
        Colis colis = Colis.create(ColisId.of(123));
        colis.deliver();
        System.out.println(colis);
    }
}
