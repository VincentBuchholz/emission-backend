package dk.vv.emission.dtos;

import org.bson.types.ObjectId;

public class TempEmissionInformation {

    private ObjectId cityId;

    private double avgAnnualTemp;

    private String cityName;

    private double totalEmissions;

    public TempEmissionInformation(ObjectId cityId, double avgAnnualTemp, String cityName, double totalEmissions) {
        this.cityId = cityId;
        this.avgAnnualTemp = avgAnnualTemp;
        this.cityName = cityName;
        this.totalEmissions = totalEmissions;
    }

    public ObjectId getCityId() {
        return cityId;
    }

    public void setCityId(ObjectId cityId) {
        this.cityId = cityId;
    }

    public double getAvgAnnualTemp() {
        return avgAnnualTemp;
    }

    public void setAvgAnnualTemp(double avgAnnualTemp) {
        this.avgAnnualTemp = avgAnnualTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(double totalEmissions) {
        this.totalEmissions = totalEmissions;
    }
}
