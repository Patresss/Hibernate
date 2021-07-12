package com.globallogic.javaacademy.hibernate.manytomany.controller;

import com.globallogic.javaacademy.hibernate.manytomany.entity.Blog;
import com.globallogic.javaacademy.hibernate.manytomany.entity.Tag;
import com.globallogic.javaacademy.hibernate.manytomany.repository.BlogRepository;
import com.globallogic.javaacademy.hibernate.manytomany.repository.TagRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("blogs")
public class BlogController {

    private final BlogRepository blogRepository;
    private final TagRepository tagRepository;

    public BlogController(BlogRepository blogRepository, TagRepository tagRepository) {
        this.blogRepository = blogRepository;
        this.tagRepository = tagRepository;
    }

    @PostMapping("/{blogId}/{tagId}")
    @Transactional
    public void unpinTag(@PathVariable Long blogId, @PathVariable Long tagId) {
        final Blog blog = blogRepository.findById(blogId).orElseThrow();
        final Tag tag = tagRepository.findById(tagId).orElseThrow();
        blog.removeTag(tag);
    }


}
