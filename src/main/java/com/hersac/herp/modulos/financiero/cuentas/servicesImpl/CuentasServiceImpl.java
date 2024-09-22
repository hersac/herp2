package com.hersac.herp.modulos.financiero.cuentas.servicesImpl;

import com.hersac.herp.config.exceptions.financiero.CuentaNotFoundException;
import com.hersac.herp.config.exceptions.financiero.TipoCuentaNotFoundException;
import com.hersac.herp.modulos.financiero.cuentas.CuentasService;
import com.hersac.herp.modulos.financiero.cuentas.dto.ActualizarCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.dto.CrearCuentaDTO;
import com.hersac.herp.modulos.financiero.cuentas.entidades.CuentaEntity;
import com.hersac.herp.modulos.financiero.cuentas.entidades.TipoCuentaEntity;
import com.hersac.herp.modulos.financiero.cuentas.entidades.repositories.CuentaRepository;
import com.hersac.herp.modulos.financiero.cuentas.entidades.repositories.TipoCuentaRepository;
import com.hersac.herp.modulos.financiero.cuentas.mappers.CuentaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentasServiceImpl implements CuentasService {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private TipoCuentaRepository tipoCuentaRepository;

    @Autowired
    private CuentaMapper cuentaMapper;

    @Override
    public List<CuentaEntity> buscarTodos() {
        return cuentaRepository.findAll();
    }

    @Override
    public CuentaEntity buscarPorId(Long cuentaId) {
        return cuentaRepository
                .findById(cuentaId)
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada"));
    }

    @Override
    public CuentaEntity crear(CrearCuentaDTO dto) {

        TipoCuentaEntity tipoCuenta = tipoCuentaRepository
                .findById(dto.getTipoCuenta())
                .orElseThrow(() -> new TipoCuentaNotFoundException("Tipo de cuenta no encontrado"));
        
        CuentaEntity cuenta = cuentaMapper.toEntity(dto);
        cuenta.setTipoCuentaId(tipoCuenta);

        return cuentaRepository.save(cuenta);
    }

    @Override
    public CuentaEntity actualizar(Long cuentaId, ActualizarCuentaDTO datosNuevos) {

        CuentaEntity cuentaExistente = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new CuentaNotFoundException("Cuenta no encontrada"));

        return cuentaRepository.save(cuentaMapper.updateToEntity(datosNuevos, cuentaExistente));
    }
}
