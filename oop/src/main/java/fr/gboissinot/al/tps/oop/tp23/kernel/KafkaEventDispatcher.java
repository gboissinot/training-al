package fr.gboissinot.al.tps.oop.tp23.kernel;

public class KafkaEventDispatcher implements EventDispatcher {
    @Override
    public void dispatch(Event event) {
        System.out.println("Producing a Kafka message (event) to a topic");
    }
}
