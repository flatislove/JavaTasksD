package org.flv.model;

public class Carrier {
    private final String name;

    public Carrier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "name='" + name + '\'' +
                '}';
    }
}
