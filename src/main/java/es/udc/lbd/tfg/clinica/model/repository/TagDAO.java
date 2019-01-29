package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.Tag;

public interface TagDAO {

    void save(Tag tag);

    List<Tag> findAll();

    Tag findById(Long id);
}
