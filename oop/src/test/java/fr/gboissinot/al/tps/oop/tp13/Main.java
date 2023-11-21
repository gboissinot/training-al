package fr.gboissinot.al.tps.oop.tp13;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        ScheduleMeetup scheduleMeetup = new ScheduleMeetup("My gboissinot Event", LocalDateTime.now());
        System.out.println("EVENT TITLE: " + scheduleMeetup.title);
    }
}
