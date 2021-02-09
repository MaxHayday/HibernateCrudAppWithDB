package com.maxhayday.hibernate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Regions",schema = "public")
@Builder(toBuilder = true)
@Getter
@Setter
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "regions_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    public Region() {
    }

    public Region(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
