package com.krizan.post_management_service;

public record PostUpdateRequest(
        String title,
        String body) {
}