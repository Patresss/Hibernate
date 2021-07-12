package com.globallogic.javaacademy.hibernate.onetomany.controllr;

import com.globallogic.javaacademy.hibernate.onetomany.entity.Comment;
import com.globallogic.javaacademy.hibernate.onetomany.entity.Post;
import com.globallogic.javaacademy.hibernate.onetomany.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("posts")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @PostMapping("/default")
    public Post createPosts() {
        Post post = new Post();
        post.setTitle("DEFAULT");
//        post.setComments(List.of(
//                new Comment(),
//                new Comment(),
//                new Comment()
//        ));
//
        post.addComment(new Comment());
        post.addComment(new Comment());
        post.addComment(new Comment());
        return postRepository.save(post);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }

    @PostMapping("{postId}/{commentId}")
    @Transactional
    public Post unpinComment(@PathVariable Long postId, @PathVariable Long commentId) {
        final Post post = postRepository.findById(postId).get();
        final Comment commentToUnpin = post.getComments().stream()
                .filter(comment -> comment.getId().equals(commentId))
                .findFirst()
                .get();

        post.removeComment(commentToUnpin);
        postRepository.save(post);
        return post;
    }

}
