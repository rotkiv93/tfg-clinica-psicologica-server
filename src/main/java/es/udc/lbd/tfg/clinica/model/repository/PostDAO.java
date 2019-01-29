package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.Post;

public interface PostDAO {
    List<Post> findAll();

    Post findById(Long id);

    void save(Post post);

    void deleteById(Long id);
}
