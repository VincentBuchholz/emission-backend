package dk.vv.emission.dtos;

public class AvgTargetInformation {


    private boolean isC40;

    private double avgTarget;


    public AvgTargetInformation(boolean isC40, double avgTarget) {
        this.isC40 = isC40;
        this.avgTarget = avgTarget;
    }

    public boolean isC40() {
        return isC40;
    }

    public void setC40(boolean c40) {
        isC40 = c40;
    }

    public double getAvgTarget() {
        return avgTarget;
    }

    public void setAvgTarget(double avgTarget) {
        this.avgTarget = avgTarget;
    }
}
