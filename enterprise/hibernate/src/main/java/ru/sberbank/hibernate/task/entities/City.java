package ru.sberbank.hibernate.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "CITY")
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Long cityId;

    @Column(name = "city_name")
    private String cityName;

    //todo: map to Region via @ManyToOne and @JoinColumn(with id of COLUMN!)
    private Region region;

    public City() {
    }

    public City(String cityName, Region region) {
        this.cityName = cityName;
        this.region = region;
    }

    public City(Long cityId, String name, Region region) {
        this.cityId = cityId;
        this.cityName = name;
        this.region = region;
    }

    @Override
    public String toString() {
        return "City{" + "cityId=" + cityId + ", name=" + cityName + '}';
    }
}
