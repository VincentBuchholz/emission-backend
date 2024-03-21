package dk.vv.emission.dtos;

public class LandAreaEmissionInfo {

    private double landArea;

    private double emissions;

    public LandAreaEmissionInfo(double landArea, double emissions) {
        this.landArea = landArea;
        this.emissions = emissions;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public double getEmissions() {
        return emissions;
    }

    public void setEmissions(double emissions) {
        this.emissions = emissions;
    }
}
