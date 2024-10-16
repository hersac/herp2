package com.hersac.herp.modulos.usuarios.roles.servicesImpl;

import com.hersac.herp.modulos.usuarios.roles.RolesServices;
import com.hersac.herp.modulos.usuarios.roles.entities.repositories.RolRepository;
import com.hersac.herp.modulos.usuarios.roles.mappers.RolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServicesImpl extends RolesServices {
    @Autowired
    private RolRepository rolesRepository() {
        return null;
    }

    @Autowired
    private RolMapper rolesMapper() {
        return null;
    }


}
