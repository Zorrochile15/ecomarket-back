package com.ecomarket.carrito.controller;

import com.ecomarket.carrito.model.ItemCarrito;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    private Map<String, List<ItemCarrito>> baseDeDatosCarritos = new HashMap<>();

    @GetMapping("/{usuarioId}")
    public List<ItemCarrito> obtenerCarrito(@PathVariable String usuarioId) {
        return baseDeDatosCarritos.getOrDefault(usuarioId, new ArrayList<>());
    }

    @PostMapping("/{usuarioId}/agregar")
    public ResponseEntity<ItemCarrito> agregarAlCarrito(
            @PathVariable String usuarioId, 
            @RequestBody ItemCarrito nuevoItem) {
        
        List<ItemCarrito> carritoActual = baseDeDatosCarritos.getOrDefault(usuarioId, new ArrayList<>());
        carritoActual.add(nuevoItem);
        baseDeDatosCarritos.put(usuarioId, carritoActual);
        
        return ResponseEntity.ok(nuevoItem);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarError(Exception e) {
        return ResponseEntity.status(500).body("Error en el microservicio de Carrito: " + e.getMessage());
    }
}