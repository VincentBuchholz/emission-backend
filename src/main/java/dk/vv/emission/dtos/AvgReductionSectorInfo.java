package dk.vv.emission.dtos;

public class AvgReductionSectorInfo {

    private String sectorName;
    private double avgReductionTarget;

    public AvgReductionSectorInfo(String sectorName, double avgReductionTarget) {
        this.sectorName = sectorName;
        this.avgReductionTarget = avgReductionTarget;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public double getAvgReductionTarget() {
        return avgReductionTarget;
    }

    public void setAvgReductionTarget(double avgReductionTarget) {
        this.avgReductionTarget = avgReductionTarget;
    }
}
