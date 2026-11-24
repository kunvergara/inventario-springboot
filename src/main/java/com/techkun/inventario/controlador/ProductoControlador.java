package com.techkun.inventario.controlador;

import com.techkun.inventario.modelo.Producto;
import com.techkun.inventario.servicio.ProductoServicio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controla las solicitudes web del módulo de inventario.
 */
@Controller
@RequestMapping("/productos")
public class ProductoControlador {

    private final ProductoServicio servicio;

    // Inyección del servicio de productos.
    public ProductoControlador(ProductoServicio servicio) {
        this.servicio = servicio;
    }

    // Mostrar la lista de productos.
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", servicio.listar());
        return "productos";
    }

    // Mostrar el formulario de registro.
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    // Guardar un producto.
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto) {
        servicio.guardar(producto);
        return "redirect:/productos";
    }

    // Eliminar un producto.
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return "redirect:/productos";
    }

    // Mostrar el formulario para editar un producto.
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Optional<Producto> producto = servicio.buscarPorId(id);

        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "formulario";
        }

        return "redirect:/productos";
    }
}