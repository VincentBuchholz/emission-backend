package dk.vv.emission.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city", schema = "emission")
public class City {
    @Id
    private Long id;

    @Column(name = "city_name")
    private String cityName;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "city_location")
    private String cityLocation;

    @Column(name = "average_annual_temperature")
    private Float averageAnnualTemperature;

    @Column(name = "c40")
    private Boolean c40;

    @Column(name = "gcom")
    private Boolean gcom;

    @Column(name = "land_area")
    private Float landArea;

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<CityGDP> cityGDPS = new HashSet<>();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<CityPopulation> cityPopulations = new HashSet<>();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Emission> emissions = new HashSet<>();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<EmissionTarget> emissionTargets = new HashSet<>();

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public Float getAverageAnnualTemperature() {
        return averageAnnualTemperature;
    }

    public void setAverageAnnualTemperature(Float averageAnnualTemperature) {
        this.averageAnnualTemperature = averageAnnualTemperature;
    }

    public Boolean getC40() {
        return c40;
    }

    public void setC40(Boolean c40) {
        this.c40 = c40;
    }

    public Boolean getGcom() {
        return gcom;
    }

    public void setGcom(Boolean gcom) {
        this.gcom = gcom;
    }

    public Float getLandArea() {
        return landArea;
    }

    public void setLandArea(Float landArea) {
        this.landArea = landArea;
    }

    public Set<CityGDP> getCityGDPS() {
        return cityGDPS;
    }

    public void setCityGDPS(Set<CityGDP> cityGDPS) {
        this.cityGDPS = cityGDPS;
    }

    public Set<CityPopulation> getCityPopulations() {
        return cityPopulations;
    }

    public void setCityPopulations(Set<CityPopulation> cityPopulations) {
        this.cityPopulations = cityPopulations;
    }

    public Set<Emission> getEmissions() {
        return emissions;
    }

    public void setEmissions(Set<Emission> emissions) {
        this.emissions = emissions;
    }

    public Set<EmissionTarget> getEmissionTargets() {
        return emissionTargets;
    }

    public void setEmissionTargets(Set<EmissionTarget> emissionTargets) {
        this.emissionTargets = emissionTargets;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                ", cityLocation='" + cityLocation + '\'' +
                ", averageAnnualTemperature=" + averageAnnualTemperature +
                ", c40=" + c40 +
                ", gcom=" + gcom +
                ", landArea=" + landArea +
                ", cityGDPS=" + cityGDPS +
                ", cityPopulations=" + cityPopulations +
                ", emissions=" + emissions +
                ", emissionTargets=" + emissionTargets +
                '}';
    }
}