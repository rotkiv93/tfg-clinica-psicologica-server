package es.udc.lbd.tfg.clinica.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;
import es.udc.lbd.tfg.clinica.model.domain.Sesion;
import es.udc.lbd.tfg.clinica.model.repository.MedicoDAO;
import es.udc.lbd.tfg.clinica.model.repository.PacienteDAO;
import es.udc.lbd.tfg.clinica.model.repository.SesionDAO;
import es.udc.lbd.tfg.clinica.model.service.dto.SesionDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SesionService {

	@Autowired
	private SesionDAO sesionDAO;

	@Autowired
	private MedicoDAO medicoDAO;

	@Autowired
	private PacienteDAO pacienteDAO;

	public List<SesionDTO> findAll() {
		return sesionDAO.findAll().stream().map(post -> new SesionDTO(post)).collect(Collectors.toList());
	}

	public List<SesionDTO> findAllSesionsOfPacientAndMedic(Long pacienteId, Long medicoId) {
		Paciente pac = pacienteDAO.findById(pacienteId);
		Medico med = medicoDAO.findById(medicoId);
		if ((pac != null) && (med != null)) {
			return sesionDAO.findAllSesionsOfPacientAndMedic(pac, med).stream().map(post -> new SesionDTO(post))
					.collect(Collectors.toList());
		} else
			return null;
	}

	public List<SesionDTO> findAllSesionsOfPacient(Long pacienteId) {
		Paciente pac = pacienteDAO.findById(pacienteId);
		if ((pac != null)) {
			return sesionDAO.findAllSesionsOfPacient(pac).stream().map(post -> new SesionDTO(post))
					.collect(Collectors.toList());
		} else
			return null;
	}

	public List<SesionDTO> findAllSesionsOfMedic(Long medicoId) {
		Medico med = medicoDAO.findById(medicoId);
		if ((med != null)) {
			return sesionDAO.findAllSesionsOfMedic(med).stream().map(post -> new SesionDTO(post))
					.collect(Collectors.toList());
		} else
			return null;
	}

	public SesionDTO findById(Long id) {
		return new SesionDTO(sesionDAO.findById(id));
	}

	@Transactional(readOnly = false)
	public SesionDTO save(SesionDTO sesion) {
		Sesion bdSesion = new Sesion(sesion.getFecha_realizacion(), sesion.getEstado());
		bdSesion.setMedico(medicoDAO.findById(sesion.getMedico().getId()));
		bdSesion.setPaciente(pacienteDAO.findById(sesion.getPaciente().getId()));

		sesionDAO.save(bdSesion);
		return new SesionDTO(bdSesion);
	}

	@Transactional(readOnly = false)
	public SesionDTO update(SesionDTO sesion) {
		Sesion bdSesion = sesionDAO.findById(sesion.getId());
		bdSesion.setFecha_realizacion(sesion.getFecha_realizacion());
		bdSesion.setEstado(sesion.getEstado());
		bdSesion.setMedico(medicoDAO.findById(sesion.getMedico().getId()));
		bdSesion.setPaciente(pacienteDAO.findById(sesion.getPaciente().getId()));

		sesionDAO.save(bdSesion);
		return new SesionDTO(bdSesion);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		sesionDAO.deleteById(id);
	}

}
