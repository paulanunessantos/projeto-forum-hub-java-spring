package br.com.forumhub.dto;

public record LoginResponseDTO(String token, long expiresIn) {
}
