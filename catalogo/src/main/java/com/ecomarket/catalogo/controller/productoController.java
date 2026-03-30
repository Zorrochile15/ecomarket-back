package com.ecomarket.catalogo.controller;

import com.ecomarket.catalogo.model.producto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class productoController {

    private List<producto> catalogo = new ArrayList<>();
    private Long contadorId = 4L;

    public productoController() {
        catalogo.add(new producto(1L, "Monstera Deliciosa", "Planta de interior muy popular.", 15000, "🪴"));
        catalogo.add(new producto(2L, "Ficus Lyrata", "Ideal para dar vida a tu sala.", 22000, "🌳"));
        catalogo.add(new producto(3L, "Suculenta Variada", "Fácil de cuidar, requiere poca agua.", 3500, "🌵"));
    }

    @GetMapping
    public List<producto> obtenerProductos() {
        return catalogo;
    }

    @PostMapping
    public producto agregarProducto(@RequestBody producto nuevoProducto) {
        nuevoProducto.setId(contadorId++);
        catalogo.add(nuevoProducto);
        return nuevoProducto;
    }

    // Patrón de resiliencia: Manejo de errores básicos
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarError(Exception e) {
        return ResponseEntity.status(500).body("Error interno en el catálogo de EcoMarket: " + e.getMessage());
    }
}