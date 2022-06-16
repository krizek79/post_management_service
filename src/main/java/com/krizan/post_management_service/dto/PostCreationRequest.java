package com.krizan.post_management_service.dto;

public record PostCreationRequest(
        Integer userId,
        String title,
        String body) {
}
