package com.hersac.herp.config.autoruns.comercial;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hersac.herp.modulos.financiero.cuentas.entidades.TipoCuentaEntity;
import com.hersac.herp.modulos.financiero.cuentas.entidades.repositories.TipoCuentaRepository;

import jakarta.transaction.Transactional;

@Component
public class CrearTiposCuentas implements CommandLineRunner {
    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<TipoCuentaEntity> tiposCuentas = Arrays.asList(
            new TipoCuentaEntity(
                1L,
                "Activo"),
            new TipoCuentaEntity(
                2L,
                "Pasivo"),
            new TipoCuentaEntity(
                3L,
                "Capital"),
            new TipoCuentaEntity(
                4L,
                "Ingreso"),
            new TipoCuentaEntity(
                5L,
                "Gasto"));
        
        tipoCuentaRepository.saveAll(tiposCuentas);
    }
}
