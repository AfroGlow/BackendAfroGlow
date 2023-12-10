package br.com.afroglow.backendAfroGlow.Controllers;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    // Getters e Setters
}
