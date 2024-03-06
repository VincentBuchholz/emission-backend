package dk.vv.emission.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "emission", schema = "emission")
public class Emission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reporting_year")
    private Integer reportingYear;

    @Column(name = "measurement_year")
    private Integer measurementYear;

    @Column(name = "total_emissions")
    private Float totalEmissions;

    @Column(name = "total_scope_1_emissions")
    private Float totalScope1Emissions;

    @Column(name = "total_scope_2_emissions")
    private Float totalScope2Emissions;

    @ManyToOne
    @JoinColumn(name = "emission_status_id")
    private EmissionStatus emissionStatus;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Float getTotalEmissions() {
        return totalEmissions;
    }

    public void setTotalEmissions(Float totalEmissions) {
        this.totalEmissions = totalEmissions;
    }

    public Float getTotalScope1Emissions() {
        return totalScope1Emissions;
    }

    public void setTotalScope1Emissions(Float totalScope1Emissions) {
        this.totalScope1Emissions = totalScope1Emissions;
    }

    public Float getTotalScope2Emissions() {
        return totalScope2Emissions;
    }

    public void setTotalScope2Emissions(Float totalScope2Emissions) {
        this.totalScope2Emissions = totalScope2Emissions;
    }

    public EmissionStatus getEmissionStatus() {
        return emissionStatus;
    }

    public void setEmissionStatus(EmissionStatus emissionStatus) {
        this.emissionStatus = emissionStatus;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
