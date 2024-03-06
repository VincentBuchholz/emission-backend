package dk.vv.emission.dtos;

public class AvgEmissionPerCitizenInfo {

    private float avgEmissionsC40;

    private float avgEmissionsNonC40;

    public AvgEmissionPerCitizenInfo(float avgEmissionsC40, float avgEmissionsNonC40) {
        this.avgEmissionsC40 = avgEmissionsC40;
        this.avgEmissionsNonC40 = avgEmissionsNonC40;
    }

    public float getAvgEmissionsC40() {
        return avgEmissionsC40;
    }

    public void setAvgEmissionsC40(float avgEmissionsC40) {
        this.avgEmissionsC40 = avgEmissionsC40;
    }

    public float getAvgEmissionsNonC40() {
        return avgEmissionsNonC40;
    }

    public void setAvgEmissionsNonC40(float avgEmissionsNonC40) {
        this.avgEmissionsNonC40 = avgEmissionsNonC40;
    }
}
