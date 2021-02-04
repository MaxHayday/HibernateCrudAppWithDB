package com.maxhayday.hibernate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
@Builder(toBuilder = true)
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Column(name = "role")
    private Role role;

    public User() {
    }

    public User(Long id, String name, String lastName, List<Post> posts, Region region, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.posts = posts;
        this.region = region;
        this.role = role;
    }
}
