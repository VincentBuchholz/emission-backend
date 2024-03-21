package dk.vv.emission.dtos;

public class AvgEmissionPerCitizenInfo {

    private double avgEmissionsC40;

    private double avgEmissionsNonC40;

    public AvgEmissionPerCitizenInfo(double avgEmissionsC40, double avgEmissionsNonC40) {
        this.avgEmissionsC40 = avgEmissionsC40;
        this.avgEmissionsNonC40 = avgEmissionsNonC40;
    }

    public double getAvgEmissionsC40() {
        return avgEmissionsC40;
    }

    public void setAvgEmissionsC40(double avgEmissionsC40) {
        this.avgEmissionsC40 = avgEmissionsC40;
    }

    public double getAvgEmissionsNonC40() {
        return avgEmissionsNonC40;
    }

    public void setAvgEmissionsNonC40(double avgEmissionsNonC40) {
        this.avgEmissionsNonC40 = avgEmissionsNonC40;
    }
}
