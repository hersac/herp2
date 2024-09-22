package com.hersac.herp.modulos.financiero.transacciones.serviceImpl;

import com.hersac.herp.config.exceptions.financiero.CuentaNotFoundException;
import com.hersac.herp.config.exceptions.financiero.TipoTransaccionNotFoundException;
import com.hersac.herp.config.exceptions.financiero.TransaccionNotFoundException;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import com.hersac.herp.modulos.financiero.cuentas.entidades.repositories.CuentaRepository;
import com.hersac.herp.modulos.financiero.transacciones.TransaccionesService;
import com.hersac.herp.modulos.financiero.transacciones.dto.ActualizarTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.dto.CrearTransaccionesDTO;
import com.hersac.herp.modulos.financiero.transacciones.entidades.TipoTransaccionEntity;
import com.hersac.herp.modulos.financiero.transacciones.entidades.TransaccionEntity;
import com.hersac.herp.modulos.financiero.transacciones.entidades.repositories.TipoTransaccionRepository;
import com.hersac.herp.modulos.financiero.transacciones.entidades.repositories.TransaccionRepository;
import com.hersac.herp.modulos.financiero.transacciones.mappers.TransaccionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {
    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private TipoTransaccionRepository tipoTransaccionRepository;

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TransaccionMapper transaccionMapper;

    @Override
    public List<TransaccionEntity> buscarTodos() {
        return transaccionRepository.findAll();
    }

    @Override
    public TransaccionEntity buscarPorId(final Long transaccionId){
        return transaccionRepository
                .findById(transaccionId)
                .orElseThrow(() -> new TransaccionNotFoundException("Transaccion no encontrada"));
    }

    @Override
    public TransaccionEntity crear(CrearTransaccionesDTO dto){

        TipoTransaccionEntity tipoTransaccion = tipoTransaccionRepository
                .findById(dto.getTipoTransaccion())
                .orElseThrow(() -> new TipoTransaccionNotFoundException("Tipo de transaccion no encontrada"));

        CuentaEntity cuenta = cuentaRepository.findById(dto.getCuenta())
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada"));

        TransaccionEntity transaccion = transaccionMapper.toEntity(dto);
        transaccion.setTipoTransaccionId(tipoTransaccion);
        transaccion.setCuentaId(cuenta);

        return transaccionRepository.save(transaccion);
    }

    @Override
    public TransaccionEntity actualizar(Long transaccionId, ActualizarTransaccionesDTO datosNuevos){
        TipoTransaccionEntity tipoTransaccion = tipoTransaccionRepository
                .findById(datosNuevos.getTipoTransaccion())
                .orElseThrow(() -> new TipoTransaccionNotFoundException("Tipo de transaccion no encontrada"));

        CuentaEntity cuenta = cuentaRepository.findById(datosNuevos.getCuenta())
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada"));

        TransaccionEntity transaccion = transaccionRepository
                .findById(transaccionId)
                .orElseThrow(() -> new TransaccionNotFoundException("Transaccion no encontrada"));

        transaccion.setTipoTransaccionId(tipoTransaccion);
        transaccion.setCuentaId(cuenta);

        return transaccionRepository.save(transaccionMapper.updateToEntity(datosNuevos, transaccion));
    }

    @Override
    public void eliminar(Long transaccionId){
        transaccionRepository
                .findById(transaccionId)
                .orElseThrow(() -> new TransaccionNotFoundException("Transaccion no encontrada"));
        transaccionRepository.deleteById(transaccionId);
    }
}
