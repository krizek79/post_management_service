package com.krizan.post_management_service.controller;

import com.krizan.post_management_service.dto.PostCreationRequest;
import com.krizan.post_management_service.dto.PostResponse;
import com.krizan.post_management_service.service.PostService;
import com.krizan.post_management_service.dto.PostUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/post")
public record PostController(PostService postService) {

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostCreationRequest request) {
        return new ResponseEntity<>(new PostResponse(postService.createPost(request)), HttpStatus.CREATED);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable("postId") Integer postId,
                                                   @RequestBody PostUpdateRequest request) {
        return new ResponseEntity<>(new PostResponse(postService.updatePost(postId, request)), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Integer postId) {
        postService.deletePost(postId);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("postId") Integer postId) {
        return new ResponseEntity<>(new PostResponse(postService.getPostById(postId)), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public List<PostResponse> getAllPostsByUserId(@PathVariable("userId") Integer userId) {
        return postService.getAllPostsByUserId(userId)
                .stream()
                .map(PostResponse::new)
                .collect(Collectors.toList());
    }
}