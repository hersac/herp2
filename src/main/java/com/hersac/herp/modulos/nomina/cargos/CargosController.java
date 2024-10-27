package com.hersac.herp.modulos.nomina.cargos;

import com.hersac.herp.modulos.nomina.cargos.dto.ActualizarCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.dto.CrearCargoDTO;
import com.hersac.herp.modulos.nomina.cargos.entidades.CargoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargosController {
    @Autowired
    private CargosServices cargosServices;

    @GetMapping
    public ResponseEntity<List<CargoEntity>> buscarTodos(){
        return ResponseEntity.ok(cargosServices.buscarTodos());
    }

    @GetMapping("/{cargoId}")
    public ResponseEntity<CargoEntity> buscarPorId(@PathVariable Long cargoId){
        return ResponseEntity.ok(cargosServices.buscarPorId(cargoId));
    }

    @PostMapping
    public ResponseEntity<CargoEntity> crear(@RequestBody CrearCargoDTO dto){
        return ResponseEntity.ok(cargosServices.crear(dto));
    }

    @PostMapping("/{cargoId}")
    public ResponseEntity<Void> actualizar(@PathVariable Long cargoId, @Valid @RequestBody ActualizarCargoDTO datosNuevos){
        cargosServices.actualizar(cargoId, datosNuevos);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{cargoId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long cargoId){
        cargosServices.eliminar(cargoId);
        return ResponseEntity.ok().build();
    }
}
