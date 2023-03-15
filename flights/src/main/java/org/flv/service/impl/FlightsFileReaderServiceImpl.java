package org.flv.service.impl;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.flv.model.dto.TicketsDTO;
import org.flv.service.FlightsFileReaderService;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FlightsFileReaderServiceImpl implements FlightsFileReaderService {
    public TicketsDTO getAllFlightsFromFile(String path) {
        TicketsDTO tickets = null;
        try (FileReader reader = new FileReader(path)) {
            Gson gson = new Gson();
            tickets = gson.fromJson(reader, TicketsDTO.class);
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid Json Syntax");
        }
        return tickets;
    }

    public TicketsDTO getAllFlightsFromStream(InputStream inputStream) {
        TicketsDTO tickets = null;
        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            Gson gson = new Gson();
            tickets = gson.fromJson(reader, TicketsDTO.class);
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (JsonSyntaxException e) {
            System.out.println("Invalid Json Syntax");
        }
        return tickets;
    }

}