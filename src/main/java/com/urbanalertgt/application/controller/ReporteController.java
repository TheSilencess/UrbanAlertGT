package com.urbanalertgt.application.controller;

import com.urbanalertgt.application.model.Reporte;
import com.urbanalertgt.application.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    // GET /api/reportes — obtener todos los reportes
    @GetMapping
    public ResponseEntity<List<Reporte>> obtenerTodos() {
        return ResponseEntity.ok(reporteService.obtenerTodos());
    }

    // GET /api/reportes/{id} — obtener reporte por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reporte> obtenerPorId(@PathVariable Long id) {
        return reporteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/reportes — crear nuevo reporte
    @PostMapping
    public ResponseEntity<Reporte> crear(@RequestBody Reporte reporte) {
        Reporte nuevo = reporteService.guardar(reporte);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    // PUT /api/reportes/{id} — actualizar reporte
    @PutMapping("/{id}")
    public ResponseEntity<Reporte> actualizar(@PathVariable Long id, @RequestBody Reporte reporte) {
        try {
            Reporte actualizado = reporteService.actualizar(id, reporte);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/reportes/{id} — eliminar reporte
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    // GET /api/reportes/usuario/{usuarioId}
    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reporte>> obtenerPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(reporteService.obtenerPorUsuario(usuarioId));
    }

    // GET /api/reportes/categoria/{categoriaId}
    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<Reporte>> obtenerPorCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(reporteService.obtenerPorCategoria(categoriaId));
    }

    // GET /api/reportes/estado/{estadoId}
    @GetMapping("/estado/{estadoId}")
    public ResponseEntity<List<Reporte>> obtenerPorEstado(@PathVariable Long estadoId) {
        return ResponseEntity.ok(reporteService.obtenerPorEstado(estadoId));
    }
}
