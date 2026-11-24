package com.techkun.inventario.servicio;

import com.techkun.inventario.modelo.Producto;
import com.techkun.inventario.repositorio.ProductoRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Contiene la lógica de negocio del inventario.
 */
@Service
public class ProductoServicio {

    private final ProductoRepositorio repositorio;

    // Inyección del repositorio.
    public ProductoServicio(ProductoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    // Registrar un producto.
    public Producto guardar(Producto producto) {
        return repositorio.save(producto);
    }

    // Consultar todos los productos.
    public List<Producto> listar() {
        return repositorio.findAll();
    }

    // Buscar un producto por su identificador.
    public Optional<Producto> buscarPorId(Integer id) {
        return repositorio.findById(id);
    }

    // Eliminar un producto.
    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}