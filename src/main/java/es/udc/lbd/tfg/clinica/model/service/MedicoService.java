package es.udc.lbd.tfg.clinica.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.lbd.tfg.clinica.model.domain.Medico;
import es.udc.lbd.tfg.clinica.model.repository.MedicoDAO;
import es.udc.lbd.tfg.clinica.model.service.dto.MedicoDTO;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MedicoService {

	@Autowired
	MedicoDAO medicoDAO;

	public List<MedicoDTO> findAll() {
		return medicoDAO.findAll().stream().map(post -> new MedicoDTO(post)).collect(Collectors.toList());
	}

	public MedicoDTO findById(Long id) {
		return new MedicoDTO(medicoDAO.findById(id));
	}

	@Transactional(readOnly = false)
	public MedicoDTO save(MedicoDTO medico) {
		Medico bdMedico = new Medico(medico.getNombre(), medico.getApellido1(), medico.getApellido2(), medico.getNSS());

		medicoDAO.save(bdMedico);
		return new MedicoDTO(bdMedico);
	}

	@Transactional(readOnly = false)
	public MedicoDTO update(MedicoDTO medico) {
		Medico bdMedico = medicoDAO.findById(medico.getId());
		bdMedico.setNombre(medico.getNombre());
		bdMedico.setApellido1(medico.getApellido1());
		bdMedico.setApellido2(medico.getApellido2());
		bdMedico.setNSS(medico.getNSS());
		bdMedico.setContraseña(medico.getContraseña());
		
		medicoDAO.save(bdMedico);
		return new MedicoDTO(bdMedico);
	}

	@Transactional(readOnly = false)
	public void deleteById(Long id) {
		medicoDAO.deleteById(id);
	}

}
