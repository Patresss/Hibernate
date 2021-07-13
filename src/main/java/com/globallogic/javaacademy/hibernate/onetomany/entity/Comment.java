package com.globallogic.javaacademy.hibernate.onetomany.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(generator = "comment_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Post post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
