package com.urbanalertgt.application.service;

import com.urbanalertgt.application.model.Reporte;
import com.urbanalertgt.application.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    public Optional<Reporte> obtenerPorId(Long id) {
        return reporteRepository.findById(id);
    }

    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte actualizar(Long id, Reporte reporteActualizado) {
        Reporte reporte = reporteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con id: " + id));

        reporte.setTitulo(reporteActualizado.getTitulo());
        reporte.setDescripcion(reporteActualizado.getDescripcion());
        reporte.setUbicacion(reporteActualizado.getUbicacion());
        reporte.setLatitud(reporteActualizado.getLatitud());
        reporte.setLongitud(reporteActualizado.getLongitud());
        reporte.setUsuarioId(reporteActualizado.getUsuarioId());
        reporte.setCategoriaId(reporteActualizado.getCategoriaId());
        reporte.setEstadoId(reporteActualizado.getEstadoId());

        return reporteRepository.save(reporte);
    }

    public void eliminar(Long id) {
        reporteRepository.deleteById(id);
    }

    public List<Reporte> obtenerPorUsuario(Long usuarioId) {
        return reporteRepository.findByUsuarioId(usuarioId);
    }

    public List<Reporte> obtenerPorCategoria(Long categoriaId) {
        return reporteRepository.findByCategoriaId(categoriaId);
    }

    public List<Reporte> obtenerPorEstado(Long estadoId) {
        return reporteRepository.findByEstadoId(estadoId);
    }
}
