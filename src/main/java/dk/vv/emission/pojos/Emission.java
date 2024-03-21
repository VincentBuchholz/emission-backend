package dk.vv.emission.pojos;

public class Emission {
    public Integer reportingYear;
    public Integer measurementYear;
    public Integer totalEmissions;
    public Integer totalScope1Emissions;
    public Integer totalScope2Emissions;
    public String status;

    public Integer getReportingYear() {
        return reportingYear;
    }

    public void setReportingYear(Integer reportingYear) {
        this.reportingYear = reportingYear;
    }

    public Integer getMeasurementYear() {
        return measurementYear;
    }

    public void setMeasurementYear(Integer measurementYear) {
        this.measurementYear = measurementYear;
    }

    public Integer getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(Integer totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public Integer getTotalScope1Emissions() {
        return totalScope1Emissions;
    }

    public void setTotalScope1Emissions(Integer totalScope1Emissions) {
        this.totalScope1Emissions = totalScope1Emissions;
    }

    public Integer getTotalScope2Emissions() {
        return totalScope2Emissions;
    }

    public void setTotalScope2Emissions(Integer totalScope2Emissions) {
        this.totalScope2Emissions = totalScope2Emissions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
