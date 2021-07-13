package com.globallogic.javaacademy.hibernate.onetomany.repository;

import com.globallogic.javaacademy.hibernate.onetomany.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
