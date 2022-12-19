package com.example.CRUDCapacitacionbackend.models;

import lombok.Getter;
import lombok.Setter;

public class JwtResponse {
    @Getter @Setter
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public JwtResponse() {
    }
}
