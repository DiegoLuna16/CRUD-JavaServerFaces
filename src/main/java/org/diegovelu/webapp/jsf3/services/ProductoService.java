package org.diegovelu.webapp.jsf3.services;

import jakarta.ejb.Local;
import org.diegovelu.webapp.jsf3.models.Categoria;
import org.diegovelu.webapp.jsf3.models.Producto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> porId(Long id);
    void guardar(Producto producto);
    void eliminar(Long id);
    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}
