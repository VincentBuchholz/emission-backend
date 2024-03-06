package dk.vv.emission.dtos;

public class CountryAvgEmissionInfo {

    private String countryName;

    private double avgEmissions;

    public CountryAvgEmissionInfo(String countryName, double avgEmissions) {
        this.countryName = countryName;
        this.avgEmissions = avgEmissions;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getAvgEmissions() {
        return avgEmissions;
    }

    public void setAvgEmissions(double avgEmissions) {
        this.avgEmissions = avgEmissions;
    }
}
