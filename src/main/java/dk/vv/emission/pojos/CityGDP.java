package dk.vv.emission.pojos;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city_gdp", schema = "emission")
public class CityGDP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gdp")
    private Float gdp;

    @Column(name = "currency")
    private String currency;

    @Column(name = "gdp_year")
    private Integer gdpYear;

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

    public Float getGdp() {
        return gdp;
    }

    public void setGdp(Float gdp) {
        this.gdp = gdp;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getGdpYear() {
        return gdpYear;
    }

    public void setGdpYear(Integer gdpYear) {
        this.gdpYear = gdpYear;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}