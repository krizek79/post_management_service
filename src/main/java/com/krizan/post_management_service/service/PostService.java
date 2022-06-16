package com.krizan.post_management_service.service;

import com.krizan.post_management_service.dto.PostUpdateRequest;
import com.krizan.post_management_service.dto.PostCreationRequest;
import com.krizan.post_management_service.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(PostCreationRequest postCreationRequest);
    Post updatePost(Integer postId, PostUpdateRequest postUpdateRequest);
    void deletePost(Integer postId);
    Post getPostById(Integer postId);
    List<Post> getAllPostsByUserId(Integer userId);
}
