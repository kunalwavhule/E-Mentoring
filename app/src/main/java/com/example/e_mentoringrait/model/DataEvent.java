package com.example.e_mentoringrait.model;

public class DataEvent {
    String EventName;
    String EventOragnizer;
    String EventTypes;
    String EventDiscription;
    String EventDate;

    public DataEvent() {
    }

    public DataEvent(String eventName, String eventOragnizer, String eventTypes, String eventDiscription, String eventDate) {
        EventName = eventName;
        EventOragnizer = eventOragnizer;
        EventTypes = eventTypes;
        EventDiscription = eventDiscription;
        EventDate = eventDate;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String eventName) {
        EventName = eventName;
    }

    public String getEventOragnizer() {
        return EventOragnizer;
    }

    public void setEventOragnizer(String eventOragnizer) {
        EventOragnizer = eventOragnizer;
    }

    public String getEventTypes() {
        return EventTypes;
    }

    public void setEventTypes(String eventTypes) {
        EventTypes = eventTypes;
    }

    public String getEventDiscription() {
        return EventDiscription;
    }

    public void setEventDiscription(String eventDiscription) {
        EventDiscription = eventDiscription;
    }

    public String getEventDate() {
        return EventDate;
    }

    public void setEventDate(String eventDate) {
        EventDate = eventDate;
    }
}
