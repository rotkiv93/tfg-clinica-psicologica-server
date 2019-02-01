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

import es.udc.lbd.tfg.clinica.model.service.PacienteService;
import es.udc.lbd.tfg.clinica.model.service.dto.PacienteDTO;
import es.udc.lbd.tfg.clinica.web.exception.IdAndBodyNotMatchingOnUpdateException;
import es.udc.lbd.tfg.clinica.web.exception.RequestBodyNotValidException;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteResource {
	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public List<PacienteDTO> findAll() {
		return pacienteService.findAll();
	}

	@GetMapping("/{id}")
	public PacienteDTO findOne(@PathVariable Long id) {
		return pacienteService.findById(id);
	}

	@PostMapping
	public PacienteDTO save(@RequestBody @Valid PacienteDTO paciente, Errors errors) throws RequestBodyNotValidException {
		errorHandler(errors);
		return pacienteService.save(paciente);
	}

	@PutMapping("/{id}")
	public PacienteDTO update(@PathVariable Long id, @RequestBody @Valid PacienteDTO paciente, Errors errors)
			throws IdAndBodyNotMatchingOnUpdateException, RequestBodyNotValidException {
		errorHandler(errors);
		if (id != paciente.getId()) {
		}
		return pacienteService.update(paciente);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		pacienteService.deleteById(id);
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
