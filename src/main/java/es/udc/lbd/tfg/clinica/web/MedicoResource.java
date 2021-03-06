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

import es.udc.lbd.tfg.clinica.model.service.MedicoService;
import es.udc.lbd.tfg.clinica.model.service.dto.MedicoDTO;
import es.udc.lbd.tfg.clinica.web.exception.IdAndBodyNotMatchingOnUpdateException;
import es.udc.lbd.tfg.clinica.web.exception.RequestBodyNotValidException;

@RestController
@RequestMapping("/api/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService medicoService;

	@GetMapping
	public List<MedicoDTO> findAll() {
		return medicoService.findAll();
	}

	@GetMapping("/{id}")
	public MedicoDTO findOne(@PathVariable Long id) {
		return medicoService.findById(id);
	}

	@PostMapping
	public MedicoDTO save(@RequestBody @Valid MedicoDTO medico, Errors errors) throws RequestBodyNotValidException {
		errorHandler(errors);
		return medicoService.save(medico);
	}

	@PutMapping("/{id}")
	public MedicoDTO update(@PathVariable Long id, @RequestBody @Valid MedicoDTO medico, Errors errors)
			throws IdAndBodyNotMatchingOnUpdateException, RequestBodyNotValidException {
		errorHandler(errors);
		if (id != medico.getId()) {
		}
		return medicoService.update(medico);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestParam Long id) {
		medicoService.deleteById(id);
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
