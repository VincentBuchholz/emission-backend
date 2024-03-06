package dk.vv.emission.pojos;

import jakarta.inject.Named;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "emission_target", schema = "emission")
public class EmissionTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "baseline_year")
    private Integer baselineYear;

    @Column(name = "target_year")
    private Integer targetYear;

    @Column(name = "baseline_emissions")
    private Float baselineEmissions;

    @Column(name = "percentage_reduction_target")
    private Float percentageReductionTarget;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "sector_id")
    private int sectorId;

    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Float getBaselineEmissions() {
        return baselineEmissions;
    }

    public void setBaselineEmissions(Float baselineEmissions) {
        this.baselineEmissions = baselineEmissions;
    }

    public Float getPercentageReductionTarget() {
        return percentageReductionTarget;
    }

    public void setPercentageReductionTarget(Float percentageReductionTarget) {
        this.percentageReductionTarget = percentageReductionTarget;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getSectorId() {
        return sectorId;
    }

    public void setSectorId(int sectorId) {
        this.sectorId = sectorId;
    }
}
