package com.techkun.inventario.servicio;

import com.techkun.inventario.modelo.Producto;
import com.techkun.inventario.repositorio.ProductoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServicioTest {

    @Mock
    private ProductoRepositorio repositorio;

    @InjectMocks
    private ProductoServicio servicio;

    private Producto producto;

    @BeforeEach
    void configurar() {
        producto = new Producto("Teclado", "Teclado USB", 75000.0, 10);
    }

    @Test
    void guardarDebeDelegarEnRepositorio() {
        when(repositorio.save(producto)).thenReturn(producto);
        assertSame(producto, servicio.guardar(producto));
        verify(repositorio).save(producto);
    }

    @Test
    void listarDebeRetornarProductosDelRepositorio() {
        when(repositorio.findAll()).thenReturn(List.of(producto));
        assertEquals(1, servicio.listar().size());
        verify(repositorio).findAll();
    }

    @Test
    void buscarPorIdDebeRetornarProductoCuandoExiste() {
        when(repositorio.findById(1)).thenReturn(Optional.of(producto));
        assertTrue(servicio.buscarPorId(1).isPresent());
        verify(repositorio).findById(1);
    }

    @Test
    void eliminarDebeDelegarEnRepositorio() {
        servicio.eliminar(1);
        verify(repositorio).deleteById(1);
    }
}

