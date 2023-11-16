package fr.gboissinot.al.tps.oop.tp1;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        var zipCode1 = ZipCode.of("94140");
        var zipCode2 = ZipCode.of("94140");

        System.out.println(zipCode1 == zipCode2);
        System.out.println(zipCode1.equals(zipCode2));

        final Map<ZipCode, String> zipCodeMap = Map.of(
                ZipCode.of("94140"), "94140",
                ZipCode.of("75000"), "75000");

        final String value = zipCodeMap.get(ZipCode.of("94140"));
        System.out.println(value);


    }
}
