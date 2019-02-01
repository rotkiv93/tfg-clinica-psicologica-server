package es.udc.lbd.tfg.clinica.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sesion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private LocalDate fecha_realizacion;

	@Enumerated(EnumType.STRING)
	private EstadoSesion estado;

	@ManyToOne(fetch = FetchType.LAZY)
	private Medico medico;

	@ManyToOne(fetch = FetchType.LAZY)
	private Paciente paciente;

	public Sesion() {

	}

	public Sesion(LocalDate fecha_realizacion, EstadoSesion estado, Medico medico, Paciente paciente) {
		super();
		this.fecha_realizacion = fecha_realizacion;
		this.estado = estado;
		this.medico = medico;
		this.paciente = paciente;
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

}
