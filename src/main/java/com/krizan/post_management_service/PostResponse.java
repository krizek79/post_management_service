package com.krizan.post_management_service;

import lombok.Getter;

@Getter
public class PostResponse {

    private final Integer userId;
    private final Integer id;
    private final String title;
    private final String body;

    public PostResponse(Post post) {
        this.userId = post.getUserId();
        this.id = post.getId();
        this.title = post.getTitle();
        this.body = post.getBody();
    }
}
