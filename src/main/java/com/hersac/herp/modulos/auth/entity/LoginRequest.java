package com.hersac.herp.modulos.auth.entity;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String contrasena;
}
