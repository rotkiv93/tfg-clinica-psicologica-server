package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.Medico;

public interface MedicoDAO {
	
    List<Medico> findAll();

    Medico findById(Long id);

    void save(Medico medico);

    void deleteById(Long id);
}
