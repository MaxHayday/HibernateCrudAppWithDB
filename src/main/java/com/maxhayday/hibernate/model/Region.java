package com.maxhayday.hibernate.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "regions",schema = "public")
@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "regions_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;


}
