package com.krizan.post_management_service;

public record PostCreationRequest(
        Integer userId,
        String title,
        String body) {
}
