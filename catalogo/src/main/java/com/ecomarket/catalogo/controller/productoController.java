package com.ecomarket.catalogo.controller;

import com.ecomarket.catalogo.model.producto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class productoController { // Esta debe ser la única clase principal

    private List<producto> catalogo = new ArrayList<>();
    private Long contadorId = 4L;

    public productoController() {
        catalogo.add(new producto(1L, "Monstera Deliciosa", "Planta de interior.", 15000, "🪴"));
        catalogo.add(new producto(2L, "Ficus Lyrata", "Ideal para sala.", 22000, "🌳"));
        catalogo.add(new producto(3L, "Suculenta Variada", "Fácil de cuidar.", 3500, "🌵"));
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
}