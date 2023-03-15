package org.flv.model;

import java.time.LocalDateTime;

public class Flight {
    private final Airport origin;
    private final Airport destination;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    private final Carrier carrier;
    private final int stops;
    private final int price;

    public Flight(Airport origin, Airport destination, LocalDateTime departureDate, LocalDateTime arrivalDate, Carrier carrier, int stops, int price) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public Airport getOrigin() {
        return origin;
    }

    public Airport getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "origin=" + origin +
                ", destination=" + destination +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", carrier=" + carrier +
                ", stops=" + stops +
                ", price=" + price +
                '}';
    }
}
