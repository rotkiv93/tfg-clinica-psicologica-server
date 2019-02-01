package es.udc.lbd.tfg.clinica.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.repository.PacienteDAO;
import es.udc.lbd.tfg.clinica.model.service.dto.PacienteDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class PacienteService {
	
	@Autowired
	PacienteDAO pacienteDAO;

	public List<PacienteDTO> findAll() {
		return pacienteDAO.findAll().stream().map(post -> new PacienteDTO(post)).collect(Collectors.toList());
	}

	public PacienteDTO findById(Long id) {
		return new PacienteDTO(pacienteDAO.findById(id));
	}

	@Transactional(readOnly = false)
	public PacienteDTO save(PacienteDTO paciente) {
		Paciente bdPaciente = new Paciente(paciente.getNombre(), paciente.getApellido1(), paciente.getApellido2(),
				paciente.getDNI(), paciente.getGenero(), paciente.getCorreo(), paciente.getFecha_nacimiento(),
				paciente.getDirección(), paciente.getNum_telefono());

		pacienteDAO.save(bdPaciente);
		return new PacienteDTO(bdPaciente);
	}

	@Transactional(readOnly = false)
	public PacienteDTO update(PacienteDTO paciente) {
		Paciente bdPaciente = pacienteDAO.findById(paciente.getId());
		bdPaciente.setNombre(paciente.getNombre());
		bdPaciente.setApellido1(paciente.getApellido1());
		bdPaciente.setApellido2(paciente.getApellido2());
		bdPaciente.setDNI(paciente.getDNI());
		bdPaciente.setGenero(paciente.getGenero());
		bdPaciente.setCorreo(paciente.getCorreo());
		bdPaciente.setFecha_nacimiento(paciente.getFecha_nacimiento());
		bdPaciente.setDirección(paciente.getDirección());
		bdPaciente.setNum_telefono(paciente.getNum_telefono());

		pacienteDAO.save(bdPaciente);
		return new PacienteDTO(bdPaciente);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		pacienteDAO.deleteById(id);
	}
}
