package org.flv.model;

public class Airport {
    private final String origin;
    private final String name;

    public Airport(String origin, String name) {
        this.origin = origin;
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "origin='" + origin + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
