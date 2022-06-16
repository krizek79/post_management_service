package com.krizan.post_management_service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record PostServiceImpl(PostRepository postRepository, RestTemplate restTemplate) implements PostService {

    @Override
    public Post createPost(PostCreationRequest postCreationRequest) {
        try {
            restTemplate.getForObject(
                    "https://jsonplaceholder.typicode.com/users/{userId}",
                    Object.class,
                    postCreationRequest.userId());
        } catch (HttpClientErrorException e) {
            throw new NotFoundException();
        }
        Post post = Post.builder()
                .userId(postCreationRequest.userId())
                .title(postCreationRequest.title())
                .body(postCreationRequest.body())
                .build();
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Integer postId, PostUpdateRequest postUpdateRequest) {
        Post post = postRepository.findPostById(postId);
        if (post == null) {
            throw new NotFoundException();
        }
        post.setTitle(postUpdateRequest.title());
        post.setBody(postUpdateRequest.body());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findPostById(postId);
        if (post == null) {
            throw new NotFoundException();
        }
        postRepository.delete(post);
    }

    @Override
    public Post getPostById(Integer postId) {
        Post post = postRepository.findPostById(postId);
        if (post == null) {
            try {
                post = restTemplate.getForObject(
                        "https://jsonplaceholder.typicode.com/posts/{postId}",
                        Post.class,
                        postId);
            } catch (HttpClientErrorException e) {
                throw new NotFoundException();
            }
            if (post != null) {
                postRepository.save(post);
            }
        }
        return post;
    }

    @Override
    public List<Post> getAllPostsByUserId(Integer userId) {
        List<Post> posts = postRepository.findAllByUserId(userId);
        if (posts == null) throw new NotFoundException();
        return posts;
    }
}
