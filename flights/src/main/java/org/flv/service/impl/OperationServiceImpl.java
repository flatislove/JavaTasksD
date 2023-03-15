package org.flv.service.impl;

import org.flv.model.Flight;
import org.flv.service.OperationService;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OperationServiceImpl implements OperationService {

    public long getAverageFlightTimeMinutes(List<Flight> flights, String origin, String destination) {
        if (flights != null) {
            int sumSeconds = 0;
            int count = 0;
            for (Flight flight : flights) {
                if (flight.getOrigin().getOrigin().equals(origin) && flight.getDestination().getOrigin().equals(destination)) {
                    sumSeconds += getSecondsFlightTime(flight);
                    count++;
                }
            }
            if (count == 0) {
                return 0;
            }
            long averageTime = sumSeconds / count;
            return averageTime / 60;
        }
        return 0;
    }

    public long getPercentileMinutes(List<Flight> flights, int percentile) {
        if (flights != null) {
            List<Long> times = new ArrayList<>();
            for (Flight flight : flights) {
                times.add(getSecondsFlightTime(flight) / 60);
            }
            Collections.sort(times);
            int number = (int) Math.round((percentile / 100.0) * times.size());
            return times.get(number - 1);
        }
        return 0;
    }

    private long getSecondsFlightTime(Flight flight) {
        LocalDateTime departureDateTime = flight.getDepartureDate();
        LocalDateTime arrivalDateTime = flight.getArrivalDate();
        Duration duration = Duration.between(departureDateTime, arrivalDateTime);
        return duration.getSeconds();
    }
}
