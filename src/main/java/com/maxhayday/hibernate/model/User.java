package com.maxhayday.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users", schema = "public")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastName;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToOne//////////ONETOone
    @JoinColumn(name = "region_id")
    private Region region;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

}
