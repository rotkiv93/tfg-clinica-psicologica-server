package es.udc.lbd.tfg.clinica.model.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.udc.lbd.tfg.clinica.model.domain.GeneroEnum;
import es.udc.lbd.tfg.clinica.model.domain.Paciente;

public class PacienteDTO {

	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido1;

	@NotEmpty
	private String apellido2;

	@NotEmpty
	private String DNI;

	@NotNull
	private GeneroEnum genero;

	@NotEmpty
	private String correo;

	@NotNull
	private LocalDate fecha_nacimiento;

	@NotEmpty
	private String dirección;

	@NotNull
	private Integer num_telefono;

	public PacienteDTO() {

	}

	public PacienteDTO(Paciente paciente) {
		this.id = paciente.getId();
		this.nombre = paciente.getNombre();
		this.apellido1 = paciente.getApellido1();
		this.apellido2 = paciente.getApellido2();
		this.DNI = paciente.getDNI();
		this.genero = paciente.getGenero();
		this.correo = paciente.getCorreo();
		this.fecha_nacimiento = paciente.getFecha_nacimiento();
		this.dirección = paciente.getDirección();
		this.num_telefono = paciente.getNum_telefono();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public LocalDate getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDirección() {
		return dirección;
	}

	public void setDirección(String dirección) {
		this.dirección = dirección;
	}

	public Integer getNum_telefono() {
		return num_telefono;
	}

	public void setNum_telefono(Integer num_telefono) {
		this.num_telefono = num_telefono;
	}

}
