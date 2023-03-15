package org.flv.service;

import org.flv.model.dto.TicketsDTO;

import java.io.InputStream;

public interface FlightsFileReaderService {
    TicketsDTO getAllFlightsFromFile(String path);

    TicketsDTO getAllFlightsFromStream(InputStream inputStream);
}
