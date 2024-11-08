package com.hersac.herp.modulos.auth;


import com.hersac.herp.config.exceptions.auth.CredencialesInvalidasException;
import com.hersac.herp.config.exceptions.usuarios.RolNotFoundException;
import com.hersac.herp.config.security.jwt.JwtTokenProvider;
import com.hersac.herp.config.security.model.TokenResponse;
import com.hersac.herp.modulos.auth.entity.LoginRequest;
import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
import com.hersac.herp.modulos.usuarios.usuarios.UsuariosServices;
import com.hersac.herp.modulos.usuarios.usuarios.dto.CrearUsuarioDTO;
import com.hersac.herp.modulos.usuarios.usuarios.entities.UsuarioEntity;
import com.hersac.herp.modulos.usuarios.usuarios.entities.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UsuariosServices usuariosServices;

    @Autowired
    private RolRepository rolRepository;

    public TokenResponse authenticate(LoginRequest loginRequest) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(loginRequest.getEmail());
        /*
        if (usuario == null && !passwordEncoder.matches(loginRequest.getContrasena(), usuario.getContrasena())) {
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }
        */
        if(usuario == null && !loginRequest.getContrasena().equals(usuario.getContrasena())){
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }
        return jwtTokenProvider.generateToken(loginRequest.getEmail());
    }

    public UsuarioEntity register(CrearUsuarioDTO usuario) {
        final Long ROL_DEFAULT = 1L;
        usuario.setRol(ROL_DEFAULT);

        return usuariosServices.crear(usuario);
    }
}
