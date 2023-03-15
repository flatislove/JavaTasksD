package org.flv.controller;

import org.flv.model.Flight;
import org.flv.model.dto.TicketsDTO;
import org.flv.service.FlightsFileReaderService;
import org.flv.service.OperationService;
import org.flv.service.ParseService;
import org.flv.service.impl.FlightsFileReaderServiceImpl;
import org.flv.service.impl.OperationServiceImpl;
import org.flv.view.Show;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class FlightController {
    public void run() {
        Properties prop = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Properties file loading error");
        }
        final String PATH = prop.getProperty("path");
        final String ORIGIN_AIRPORT = prop.getProperty("origin_airport");
        final String DESTINATION_AIRPORT = prop.getProperty("destination_airport");
        final int PERCENTILE = Integer.parseInt(prop.getProperty("percentile"));

        FlightsFileReaderService flightsFileReader = new FlightsFileReaderServiceImpl();
        OperationService operationService = new OperationServiceImpl();
        inputStream = getClass().getClassLoader().getResourceAsStream(PATH);
        TicketsDTO ticketsDTO = flightsFileReader.getAllFlightsFromStream(inputStream);

        List<Flight> flights = ParseService.parseTicketsJSONToFlights(ticketsDTO);

        long averageTime = operationService.getAverageFlightTimeMinutes(flights, ORIGIN_AIRPORT, DESTINATION_AIRPORT);
        Show show = new Show();
        show.showTimeFromMinutes("Average Flight Time:", averageTime);

        long percentile = operationService.getPercentileMinutes(flights, PERCENTILE);
        show.showTimeFromMinutes("Percentile " + PERCENTILE + ":", percentile);
    }
}
