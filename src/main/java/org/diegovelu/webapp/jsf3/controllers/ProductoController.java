package org.diegovelu.webapp.jsf3.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.diegovelu.webapp.jsf3.models.Categoria;
import org.diegovelu.webapp.jsf3.models.Producto;
import org.diegovelu.webapp.jsf3.services.ProductoService;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductoController {

    private Producto producto;

    private Long id;

    @Inject
    private ProductoService service;

    @Produces
    @Model
    public String titulo() {
        return "Hola mundo Javaserver Faces 3.0";
    }

    @Produces
    @RequestScoped
    @Named("listado")
    public List<Producto> findAll() {
        return service.listar();
    }

    @Produces
    @Model
    public Producto producto() {
        this.producto = new Producto();
        if(id != null && id > 0){
            service.porId(id).ifPresent(p -> this.producto = p);
        }
        return producto;
    }

    @Produces
    @Model
    public List<Categoria> categorias() {
        return service.listarCategorias();
    }

    public String editar(Long id){
        this.id = id;
        return "form.xhtml";
    }

    public String eliminar(Long id){
        service.eliminar(id);
        return "index.xhtml?faces-redirect=true";
    }

    public String guardar (){
        System.out.println(producto);
         service.guardar(producto);
        return "index.xhtml?faces-redirect=true";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
