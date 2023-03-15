package org.flv.service;

import org.flv.model.Airport;
import org.flv.model.Carrier;
import org.flv.model.Flight;
import org.flv.model.dto.TicketsDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ParseService {
    public static List<Flight> parseTicketsJSONToFlights(TicketsDTO tickets) {
        if (tickets == null) {
            return null;
        }
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < tickets.tickets().size(); i++) {
            flights.add(new Flight(
                    new Airport(tickets.tickets().get(i).origin(), tickets.tickets().get(i).origin_name()),
                    new Airport(tickets.tickets().get(i).destination(), tickets.tickets().get(i).destination_name()),
                    parseStringDateAndTimeToDate(tickets.tickets().get(i).departure_date(), tickets.tickets().get(i).departure_time()),
                    parseStringDateAndTimeToDate(tickets.tickets().get(i).arrival_date(), tickets.tickets().get(i).arrival_time()),
                    new Carrier(tickets.tickets().get(i).carrier()),
                    Integer.parseInt(tickets.tickets().get(i).stops()),
                    Integer.parseInt(tickets.tickets().get(i).price())
            ));
        }
        return flights;
    }

    private static LocalDateTime parseStringDateAndTimeToDate(String dateStr, String timeStr) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yy");
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("H:mm");
        LocalDateTime dateTime;
        LocalDate date = LocalDate.parse(dateStr, formatterDate);
        LocalTime time = LocalTime.parse(timeStr, formatterTime);
        dateTime = LocalDateTime.of(date, time);
        return dateTime;
    }
}
