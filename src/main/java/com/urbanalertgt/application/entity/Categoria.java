package com.urbanalertgt.application.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias")

public class Categoria {

    @Column(name = "id_categoria")
    private int IDCategoria;
    @Column
    private String nombreCategoria;
    @Column
    private String descripcionCategoria;


    public Categoria(){
    }

    public Categoria(int IDCategoria, String nombreCategoria, String descripcionCategoria) {
        this.IDCategoria = IDCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
    }

    public int getIDCategoria() {
        return IDCategoria;
    }

    public void setIDCategoria(int IDCategoria) {
        this.IDCategoria = IDCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

}
