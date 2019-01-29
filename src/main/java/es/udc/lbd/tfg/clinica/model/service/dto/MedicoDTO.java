package es.udc.lbd.tfg.clinica.model.service.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import es.udc.lbd.tfg.clinica.model.domain.Medico;

public class MedicoDTO {

	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String apellido1;

	@NotEmpty
	private String apellido2;

	@NotNull
	private Integer NSS;

	@NotEmpty
	private String contraseña;
	
	
	public MedicoDTO(){
		
	}
	
	public MedicoDTO(Medico medico){
		this.id = medico.getId();
		this.nombre = medico.getNombre();
		this.apellido1 = medico.getApellido1();
		this.apellido2 = medico.getApellido2();
		this.NSS = medico.getNSS();
		this.contraseña = medico.getContraseña();
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

	public Integer getNSS() {
		return NSS;
	}

	public void setNSS(Integer nSS) {
		NSS = nSS;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
