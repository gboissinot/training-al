package fr.gboissinot.al.tps.oop.tp7;

final class ReservationRequest {

    private final int numberOfRooms;
    private final int nbumberOfAdults;
    private final int numberOfChildren;

    public ReservationRequest(int numberOfRooms, int numberOfAdults, int numberOfChildren) {
        //Invariant
        if (numberOfRooms > numberOfAdults + numberOfChildren) {
            throw new IllegalArgumentException("Reservation impossible: Chaque chambre doit être occupée.");
        }

        this.numberOfRooms = numberOfRooms;
        this.nbumberOfAdults = numberOfAdults;
        this.numberOfChildren = numberOfChildren;
    }
}
