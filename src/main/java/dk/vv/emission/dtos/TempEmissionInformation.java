package dk.vv.emission.dtos;

public class TempEmissionInformation {

    private long cityId;

    private float avgAnnualTemp;

    private String cityName;

    private Float totalEmissions;

    public TempEmissionInformation(long cityId, float avgAnnualTemp, String cityName, Float totalEmissions) {
        this.cityId = cityId;
        this.avgAnnualTemp = avgAnnualTemp;
        this.cityName = cityName;
        this.totalEmissions = totalEmissions;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public float getAvgAnnualTemp() {
        return avgAnnualTemp;
    }

    public void setAvgAnnualTemp(float avgAnnualTemp) {
        this.avgAnnualTemp = avgAnnualTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Float getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(Float totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    @Override
    public String toString() {
        return "TempEmissionInformation{" +
                "cityId=" + cityId +
                ", avgAnnualTemp=" + avgAnnualTemp +
                ", cityName='" + cityName + '\'' +
                ", totalEmissions=" + totalEmissions +
                '}';
    }
}
