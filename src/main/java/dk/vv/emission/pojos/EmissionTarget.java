package dk.vv.emission.pojos;


public class EmissionTarget {
    public Integer baselineYear;
    public Integer targetYear;
    public Integer baselineEmissions;
    public Integer percentageReductionTarget;
    public String sector;

    public Integer getBaselineYear() {
        return baselineYear;
    }

    public void setBaselineYear(Integer baselineYear) {
        this.baselineYear = baselineYear;
    }

    public Integer getTargetYear() {
        return targetYear;
    }

    public void setTargetYear(Integer targetYear) {
        this.targetYear = targetYear;
    }

    public Integer getBaselineEmissions() {
        return baselineEmissions;
    }

    public void setBaselineEmissions(Integer baselineEmissions) {
        this.baselineEmissions = baselineEmissions;
    }

    public Integer getPercentageReductionTarget() {
        return percentageReductionTarget;
    }

    public void setPercentageReductionTarget(Integer percentageReductionTarget) {
        this.percentageReductionTarget = percentageReductionTarget;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }
}