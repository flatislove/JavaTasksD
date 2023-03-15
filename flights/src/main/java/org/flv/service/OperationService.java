package org.flv.service;

import org.flv.model.Flight;

import java.util.List;

public interface OperationService {
    long getAverageFlightTimeMinutes(List<Flight> flights, String origin, String destination);

    long getPercentileMinutes(List<Flight> flights, int percentile);
}