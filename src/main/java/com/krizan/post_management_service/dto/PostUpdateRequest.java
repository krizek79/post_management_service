package com.krizan.post_management_service.dto;

public record PostUpdateRequest(
        String title,
        String body) {
}