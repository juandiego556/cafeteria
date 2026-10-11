package com.example.cafeteria;


import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

 
@RestController

public class CafeteriaController {

    @GetMapping("/bienvenida")
    public String saludar() {
        return "Bienvenido a Café Andino";
    }

    @GetMapping("/pedido/{producto}")
    public String pedido(@PathVariable String producto) {
        return "Preparando tu " + producto;
    }
    @GetMapping("/pedido/{producto}/{producto_dos}")
    public String pedidoDoble(@PathVariable String producto, @PathVariable String producto_dos) {
        return "Preparando tu " + producto + " y tu " + producto_dos + "...";
    }

    @GetMapping("/menu") 
    public Map<String, Object> menu() { 
        return Map.of( 
            "tinto", 3000, 
            "capuchino", 6500, 
            "chocolate", 5500,
            "pan de bono", 2500
            ); 
    }   
    @GetMapping("/cafeteria") 
    public Map<String, Object> cafeteria() { 
        return Map.of( 
            "nombre", "Café Andino", 
            "ciudad", "Bogotá", 
            "abierto", true,
            "horario", "8:00 AM - 8:00 PM"
            ); 
    }   
    @GetMapping("/total/{precio}/{cantidad}")
    public String calcularTotal(@PathVariable int precio, @PathVariable int cantidad) {
        int total = precio * cantidad;
        return "Total a pagar: $" + total;
    }
}