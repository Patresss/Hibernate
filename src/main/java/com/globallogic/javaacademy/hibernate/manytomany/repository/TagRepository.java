package com.globallogic.javaacademy.hibernate.manytomany.repository;

import com.globallogic.javaacademy.hibernate.manytomany.entity.Blog;
import com.globallogic.javaacademy.hibernate.manytomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
