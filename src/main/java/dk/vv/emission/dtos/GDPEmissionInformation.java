package dk.vv.emission.dtos;

import jakarta.persistence.Column;

public class GDPEmissionInformation {

    private Integer populationAmount;

    private float gdp;

    private Float totalEmissions;

    private String cityName;

    public GDPEmissionInformation(Integer populationAmount, float gdp, Float totalEmissions, String cityName) {
        this.populationAmount = populationAmount;
        this.gdp = gdp;
        this.totalEmissions = totalEmissions;
        this.cityName = cityName;
    }

    public Integer getPopulationAmount() {
        return populationAmount;
    }

    public void setPopulationAmount(Integer populationAmount) {
        this.populationAmount = populationAmount;
    }

    public float getGdp() {
        return gdp;
    }

    public void setGdp(float gdp) {
        this.gdp = gdp;
    }

    public Float getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(Float totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
