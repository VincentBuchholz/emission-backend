package dk.vv.emission.dtos;

import dk.vv.emission.pojos.*;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class CityDTO {
    private Long id;
    private String cityName;

    private Country country;

    private String cityLocation;

    private Float averageAnnualTemperature;

    private Boolean c40;

    private Boolean gcom;

    private Float landArea;


    public CityDTO(Long id, String cityName, Float averageAnnualTemperature) {
        this.id = id;
        this.cityName = cityName;
        this.averageAnnualTemperature = averageAnnualTemperature;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public Float getAverageAnnualTemperature() {
        return averageAnnualTemperature;
    }

    public void setAverageAnnualTemperature(Float averageAnnualTemperature) {
        this.averageAnnualTemperature = averageAnnualTemperature;
    }

    public Boolean getC40() {
        return c40;
    }

    public void setC40(Boolean c40) {
        this.c40 = c40;
    }

    public Boolean getGcom() {
        return gcom;
    }

    public void setGcom(Boolean gcom) {
        this.gcom = gcom;
    }

    public Float getLandArea() {
        return landArea;
    }

    public void setLandArea(Float landArea) {
        this.landArea = landArea;
    }
}
