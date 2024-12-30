package com.example.demo.model.beans;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkingHour {
    private DayOfWeek dayOfWeek; // "Monday", "Tuesday", etc.
    private Boolean closed; // indicates if the restaurant is closed on this day
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<String> holidays; // list of dates the restaurant is closed

    public WorkingHour() {}
    public WorkingHour(DayOfWeek dayOfWeek, LocalTime openingTime, LocalTime closingTime, Boolean closed, List<String> holidays) {
        this.dayOfWeek = dayOfWeek;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.closed = closed;
        this.holidays = holidays;
    }
}