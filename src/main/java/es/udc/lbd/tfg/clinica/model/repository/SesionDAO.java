package es.udc.lbd.tfg.clinica.model.repository;

import java.util.List;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.domain.Sesion;

public interface SesionDAO {
	List<Sesion> findAll();

	List<Sesion> findAllSesionsOfPacientAndMedic(Paciente paciente, Medico medico);
	
	Sesion findById(Long id);

	void save(Sesion sesion);

	void deleteById(Long id);
}
