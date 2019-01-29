package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.Paciente;

public interface PacienteDAO {

    List<Paciente> findAll();

    Paciente findById(Long id);
    
    Paciente findByDNI(String DNI);

    void save(Paciente medico);

    void deleteById(Long id);
}
