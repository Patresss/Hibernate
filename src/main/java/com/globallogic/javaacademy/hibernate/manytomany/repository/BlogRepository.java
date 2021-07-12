package com.globallogic.javaacademy.hibernate.manytomany.repository;

import com.globallogic.javaacademy.hibernate.manytomany.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
