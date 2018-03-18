package ru.sberbank.hibernate.task.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "REGION")
@Getter @Setter @ToString
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false, unique = true, updatable = false)
    private Long regionId;

    @Column(name = "region_name", nullable = true)
    private String regionName;

    //todo: optional map to cities with @OneToMany and tell about - Cascade
    private List<City> cities;

}
