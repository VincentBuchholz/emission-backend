package dk.vv.emission.dtos;

public class LandAreaEmissionInfo {

    private float landArea;

    private double emissions;

    public LandAreaEmissionInfo(float landArea, double emissions) {
        this.landArea = landArea;
        this.emissions = emissions;
    }

    public float getLandArea() {
        return landArea;
    }

    public void setLandArea(float landArea) {
        this.landArea = landArea;
    }

    public double getEmissions() {
        return emissions;
    }

    public void setEmissions(double emissions) {
        this.emissions = emissions;
    }
}
