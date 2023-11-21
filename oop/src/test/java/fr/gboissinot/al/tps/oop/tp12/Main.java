package fr.gboissinot.al.tps.oop.tp12;

public class Main {

    public static void main(String[] args) {
        Colis colis = Colis.create(ColisNumber.of(123));
        colis.deliver();
        final Status colisStatusy = colis.getStatus();
        System.out.println(colisStatusy);
    }
}
