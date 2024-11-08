package com.hersac.herp.modulos.auth;

import com.hersac.herp.config.security.model.TokenResponse;
import com.hersac.herp.modulos.auth.entity.LoginRequest;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest) {

        return ResponseEntity.ok(authService.authenticate(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UsuarioEntity> register(@Valid @RequestBody CrearUsuarioDTO nuevoUsuario) {
        return ResponseEntity.ok(authService.register(nuevoUsuario));
    }
}
