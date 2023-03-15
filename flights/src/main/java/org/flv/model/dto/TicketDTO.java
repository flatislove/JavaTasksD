package org.flv.model.dto;

public record TicketDTO(String origin, String origin_name, String destination, String destination_name,
                        String departure_date, String departure_time, String arrival_date, String arrival_time,
                        String carrier, String stops, String price) {
}
