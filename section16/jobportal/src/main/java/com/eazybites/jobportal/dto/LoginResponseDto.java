package com.eazybites.jobportal.dto;

public record LoginResponseDto(String username, UserDto user, String jwtToken) {
}
