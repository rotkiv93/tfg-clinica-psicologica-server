package es.udc.lbd.tfg.clinica.web;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.udc.lbd.tfg.clinica.model.service.SesionService;
import es.udc.lbd.tfg.clinica.model.service.dto.SesionDTO;
import es.udc.lbd.tfg.clinica.web.exception.IdAndBodyNotMatchingOnUpdateException;
import es.udc.lbd.tfg.clinica.web.exception.RequestBodyNotValidException;

@RestController
@RequestMapping("/api/sesiones")
public class SesionResource {

	@Autowired
	private SesionService sesionService;
	
	@GetMapping
	public List<SesionDTO> findAll(@RequestParam(required = false) Long pacienteId,
    		@RequestParam(required = false) Long medicoId) {
		if ((medicoId != null) && (pacienteId != null)){
			return sesionService.findAllSesionsOfPacientAndMedic(pacienteId, medicoId);
		} else if (pacienteId != null){
			return sesionService.findAllSesionsOfPacient(pacienteId);
		} else if (medicoId != null){
			return sesionService.findAllSesionsOfMedic(medicoId);
		} else
			return sesionService.findAll();
	}  

	@GetMapping("/{id}")
	public SesionDTO findOne(@PathVariable Long id) {
		return sesionService.findById(id);
	}

	@PostMapping
	public SesionDTO save(@RequestBody @Valid SesionDTO sesion, Errors errors) throws RequestBodyNotValidException {
		errorHandler(errors);
		return sesionService.save(sesion);
	}

	@PutMapping("/{id}")
	public SesionDTO update(@PathVariable Long id, @RequestBody @Valid SesionDTO sesion, Errors errors)
			throws IdAndBodyNotMatchingOnUpdateException, RequestBodyNotValidException {
		errorHandler(errors);
		if (id != sesion.getId()) {
		}
		return sesionService.update(sesion);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		sesionService.deleteById(id);
	}

	private void errorHandler(Errors errors) throws RequestBodyNotValidException {
		if (errors.hasErrors()) {
			String errorMsg = errors.getFieldErrors().stream()
					.map(fe -> String.format("%s.%s %s", fe.getObjectName(), fe.getField(), fe.getDefaultMessage()))
					.collect(Collectors.joining("; "));
			throw new RequestBodyNotValidException(errorMsg);
		}
	}
	
	
}
