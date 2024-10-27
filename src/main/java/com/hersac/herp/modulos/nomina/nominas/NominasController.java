package com.hersac.herp.modulos.nomina.nominas;

import com.hersac.herp.modulos.nomina.nominas.dto.ActualizarNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.dto.CrearNominaDTO;
import com.hersac.herp.modulos.nomina.nominas.entities.NominaEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nominas")
public class NominasController {
    @Autowired
    private NominasServices nominasServices;

    @GetMapping
    public ResponseEntity<List<NominaEntity>> buscarTodos(){
        return ResponseEntity.ok(nominasServices.buscarTodos());
    }

    @GetMapping("/{nominaId}")
    public ResponseEntity<NominaEntity> buscarPorId(Long nominaId){
        return ResponseEntity.ok(nominasServices.buscarPorId(nominaId));
    }

    @PostMapping
    public ResponseEntity<NominaEntity> guardar(@Valid @RequestBody CrearNominaDTO dto){
        return ResponseEntity.ok(nominasServices.guardar(dto));
    }

    @PutMapping("/{nominaId}")
    public ResponseEntity<Void> actualizar(
            @PathVariable Long nominaId,
            @Valid @RequestBody ActualizarNominaDTO datosnuevos){
        nominasServices.actualizar(nominaId, datosnuevos);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{nominaId}")
    public ResponseEntity<Void> eliminar(@PathVariable Long nominaId){
        nominasServices.eliminar(nominaId);
        return ResponseEntity.noContent().build();
    }
}
