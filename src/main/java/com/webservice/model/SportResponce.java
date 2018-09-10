package com.webservice.model;

import java.util.Map;

import com.bookmeker_service.beans.EventGeneral;
import com.bookmeker_service.beans.LeagueGeneral;
import com.bookmeker_service.beans.SportGeneral;

public class SportResponce {

    private Map<Integer, SportGeneral> sports;
    private Map<Integer, LeagueGeneral> leagues;
    private Map<Integer, EventGeneral> events;
    private String errorMessage;
    private Boolean success = true;

    public Map<Integer, SportGeneral> getSports() {
        return this.sports;
    }

    public void setSports(Map<Integer, SportGeneral> sports){
        this.sports = sports;
    }

    public Map<Integer, LeagueGeneral> getLeagues() {
        return this.leagues;
    }

    public void setLeagues(Map<Integer, LeagueGeneral> leagues){
        this.leagues = leagues;
    }

    public Map<Integer, EventGeneral> getEvents() {
        return this.events;
    }

    public void setEvents(Map<Integer, EventGeneral> events){
        this.events = events;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void isSuccess(Boolean success) {
        this.success = success;
    }

}