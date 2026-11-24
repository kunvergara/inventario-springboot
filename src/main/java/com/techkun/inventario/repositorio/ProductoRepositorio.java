package com.techkun.inventario.repositorio;

import com.techkun.inventario.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gestiona las operaciones de acceso a los productos.
 */
@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}