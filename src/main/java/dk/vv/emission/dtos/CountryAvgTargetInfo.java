package dk.vv.emission.dtos;

public class CountryAvgTargetInfo {

    private String countryName;

    private double AvgTarget;

    public CountryAvgTargetInfo(String countryName, double avgTarget) {
        this.countryName = countryName;
        AvgTarget = avgTarget;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getAvgTarget() {
        return AvgTarget;
    }

    public void setAvgTarget(double avgTarget) {
        AvgTarget = avgTarget;
    }
}
