package ru.sberbank.hibernate.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    // targetEntity используется в случае, если вместо класса интерфейс или суперкласс
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, targetEntity = Region.class)
    @JoinColumn(name = "region_id")
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
