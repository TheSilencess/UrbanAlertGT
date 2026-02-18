package com.urbanalertgt.application.controller;

import com.urbanalertgt.application.entity.Categoria;
import com.urbanalertgt.application.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repo;

    public CategoriaController(CategoriaRepository repo) {
        this.repo = repo;
    }

    //listar categoriad
    @GetMapping
    public List<Categoria> listar(){
        return repo.findAll();
    }

    //guardar nueva categoria
    @PostMapping
    public Categoria guardar(@RequestBody Categoria c){
        return repo.save(c);
    }

    // Actualizar categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria categoria){
        if(!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        categoria.setIDCategoria(id);
        return ResponseEntity.ok(repo.save(categoria));
    }

    //buscar caterodia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id){
        return repo.findById(id)
                .map(categoria -> ResponseEntity.ok(categoria))
                .orElse(ResponseEntity.notFound().build());
    }

    //eliminar una categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id){
        if(!repo.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

