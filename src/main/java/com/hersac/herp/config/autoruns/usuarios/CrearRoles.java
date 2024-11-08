package com.hersac.herp.config.autoruns.usuarios;

import com.hersac.herp.modulos.usuarios.roles.entities.RolEntity;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;
import java.util.List;

public class CrearRoles implements CommandLineRunner {

    @Autowired
    private RolRepository rolRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<RolEntity> roles = Arrays.asList(
                new RolEntity(
                        null,
                        "Administrador",
                        "Rol de administrador"
                ),
                new RolEntity(
                        null,
                        "Usuario",
                        "Rol de usuario"
                )
        );

        rolRepository.saveAll(roles);
    }
}
