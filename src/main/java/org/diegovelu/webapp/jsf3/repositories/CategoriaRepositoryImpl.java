package org.diegovelu.webapp.jsf3.repositories;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.diegovelu.webapp.jsf3.models.Categoria;

import java.util.List;

@RequestScoped
public class CategoriaRepositoryImpl implements CrudRepository<Categoria> {

    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> listar() {
        return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
    }

    @Override
    public Categoria porId(Long id) {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria c) {
        if(c.getId() != null & c.getId() > 0) {
            em.merge(c);
        } else {
            em.persist(c);
        }
    }

    @Override
    public void eliminar(Long id) {
        em.remove(porId(id));
    }
}
