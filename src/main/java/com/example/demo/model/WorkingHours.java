package com.example.demo.model;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.model.common.BaseEntity;

@Document
public class WorkingHours extends BaseEntity {
    private String dayOfWeek; // "Monday", "Tuesday", etc.
    private LocalTime openingTime;
    private LocalTime closingTime;
    private Boolean closed; // indicates if the restaurant is closed on this day
    private List<String> holidays; // list of dates the restaurant is closed

    // Constructors, getters, and setters
    public WorkingHours() {}

    public WorkingHours(String dayOfWeek, LocalTime openingTime, LocalTime closingTime, Boolean closed, List<String> holidays) {
        this.dayOfWeek = dayOfWeek;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.closed = closed;
        this.holidays = holidays;
    }

    // Getters and setters
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public List<String> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<String> holidays) {
        this.holidays = holidays;
    }
}

