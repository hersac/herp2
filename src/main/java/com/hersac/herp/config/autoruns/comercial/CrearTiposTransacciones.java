package com.hersac.herp.config.autoruns.comercial;

import com.hersac.herp.modulos.financiero.transacciones.entidades.TipoTransaccionEntity;
import com.hersac.herp.modulos.financiero.transacciones.entidades.repositories.TipoTransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CrearTiposTransacciones implements CommandLineRunner {
    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<TipoTransaccionEntity> tiposTransacciones = Arrays.asList(
                new TipoTransaccionEntity(
                        1L,
                        "Ingreso",
                        "Transacciones de ingreso"
                ),
                new TipoTransaccionEntity(
                        2L,
                        "Gasto",
                        "Transacciones de egreso"
                )
        );

        tipoTransaccionRepository.saveAll(tiposTransacciones);
    }
}
