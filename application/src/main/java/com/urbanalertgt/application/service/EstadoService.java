package com.urbanalertgt.application.service;

import com.urbanalertgt.application.model.Estado;
import com.urbanalertgt.application.repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    private final EstadoRepository estadoRepository;

    public EstadoService(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public List<Estado> obtenerTodos() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> obtenerPorId(Long id) {
        return estadoRepository.findById(id);
    }

    public Estado crear(Estado estado) {
        if (estadoRepository.existsByNombre(estado.getNombre())) {
            throw new RuntimeException("Ya existe un estado con el nombre: " + estado.getNombre());
        }
        return estadoRepository.save(estado);
    }

    public Estado actualizar(Long id, Estado datosNuevos) {

        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estado no encontrado con ID: " + id));

        if (!estado.getNombre().equals(datosNuevos.getNombre())
                && estadoRepository.existsByNombre(datosNuevos.getNombre())) {
            throw new RuntimeException("Ya existe un estado con ese nombre");
        }

        estado.setNombre(datosNuevos.getNombre());
        estado.setDescripcion(datosNuevos.getDescripcion());

        return estadoRepository.save(estado);
    }

    public void eliminar(Long id) {
        if (!estadoRepository.existsById(id)) {
            throw new RuntimeException("Estado no encontrado con ID: " + id);
        }

        estadoRepository.deleteById(id);
    }
}
