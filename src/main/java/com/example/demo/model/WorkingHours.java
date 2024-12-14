package com.example.demo.model;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingHours {
    private String dayOfWeek; // "Monday", "Tuesday", etc.
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Boolean closed; // indicates if the restaurant is closed on this day
    private List<String> holidays; // list of dates the restaurant is closed

    public WorkingHours() {}
    public WorkingHours(String dayOfWeek, LocalTime openingTime, LocalTime closingTime, Boolean closed, List<String> holidays) {
        this.dayOfWeek = dayOfWeek;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.closed = closed;
        this.holidays = holidays;
    }
}