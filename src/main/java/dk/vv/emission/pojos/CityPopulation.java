package dk.vv.emission.pojos;

import jakarta.persistence.*;

@Entity
@Table(name = "city_population", schema = "emission")
public class CityPopulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "population_amount")
    private Float populationAmount;

    @Column(name = "population_year")
    private Integer populationYear;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    // Getters and setters
}