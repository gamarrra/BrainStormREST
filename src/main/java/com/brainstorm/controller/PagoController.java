package com.brainstorm.controller;

import com.brainstorm.exception.ResourceNotFoundException;

import com.brainstorm.model.Pago;
import com.brainstorm.repository.PagoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class PagoController {

	
    @Autowired
    PagoRepository pagoRepository;

    @GetMapping("/pagos")
    public List<Pago> getAll() {
        return pagoRepository.findAll();
    }

    @PostMapping("/pagos")
    public Pago create(@Valid @RequestBody Pago pago) {
        return pagoRepository.save(pago);
    }

    @GetMapping("/pagos/{id}")
    public Pago getById(@PathVariable(value = "id") Long pagoId) {
        return pagoRepository.findById(pagoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pago", "id", pagoId));
    }

    @PutMapping("/pagos/{id}")
    public Pago update(@PathVariable(value = "id") Long pagoId,
                                           @Valid @RequestBody Pago grupoDetails) {

    	Pago pago = pagoRepository.findById(pagoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pago", "id", pagoId));

    	pago.setUsuarioId(grupoDetails.getUsuarioId());

    	Pago pagoActualizado = pagoRepository.save(pago);
        return pagoActualizado;
    }

    @DeleteMapping("/pagos/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long pagoId) {
    	Pago pago = pagoRepository.findById(pagoId)
                .orElseThrow(() -> new ResourceNotFoundException("Pago", "id", pagoId));

    	pagoRepository.delete(pago);

        return ResponseEntity.ok().build();
    }
}
