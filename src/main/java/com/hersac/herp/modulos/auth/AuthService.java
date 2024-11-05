package com.hersac.herp.modulos.auth;


import com.hersac.herp.config.exceptions.auth.CredencialesInvalidasException;
import com.hersac.herp.config.security.jwt.JwtTokenProvider;
import com.hersac.herp.config.security.model.TokenResponse;
import com.hersac.herp.modulos.auth.entity.LoginRequest;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenResponse authenticate(LoginRequest loginRequest) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(loginRequest.getEmail());
        if (usuario == null && !passwordEncoder.matches(loginRequest.getContrasena(), usuario.getContrasena())) {
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }
        return jwtTokenProvider.generateToken(loginRequest.getEmail());
    }
}
