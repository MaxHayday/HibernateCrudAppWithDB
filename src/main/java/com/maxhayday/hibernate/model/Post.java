package com.maxhayday.hibernate.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "Posts",schema = "public")
@Builder(toBuilder = true)
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created")
    private Timestamp created;

    @Column(name = "updated")
    private Timestamp updated;

    @Column(name = "user_id")
    private Long user_id;

    public Post() {
    }

    public Post(Long id, String content, Timestamp created, Timestamp updated, Long user_id) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.user_id = user_id;
    }
}
