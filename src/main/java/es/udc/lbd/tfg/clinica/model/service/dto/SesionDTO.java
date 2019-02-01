package es.udc.lbd.tfg.clinica.model.service.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import es.udc.lbd.tfg.clinica.model.domain.EstadoSesion;
import es.udc.lbd.tfg.clinica.model.domain.Sesion;

public class SesionDTO {

	private Long id;

	@NotNull
	private LocalDate fecha_realizacion;

	@NotNull
	private EstadoSesion estado;

	@NotNull
	private MedicoDTO medico;

	@NotNull
	private PacienteDTO paciente;
	
	public SesionDTO(){
		
	}
	
	public SesionDTO(Sesion sesion){
		this.id = sesion.getId();
		this.estado = sesion.getEstado();
		this.medico = new MedicoDTO(sesion.getMedico());
		this.paciente = new PacienteDTO(sesion.getPaciente());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha_realizacion() {
		return fecha_realizacion;
	}

	public void setFecha_realizacion(LocalDate fecha_realizacion) {
		this.fecha_realizacion = fecha_realizacion;
	}

	public EstadoSesion getEstado() {
		return estado;
	}

	public void setEstado(EstadoSesion estado) {
		this.estado = estado;
	}

	public MedicoDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoDTO medico) {
		this.medico = medico;
	}

	public PacienteDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteDTO paciente) {
		this.paciente = paciente;
	}
	
}
