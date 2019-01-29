package es.udc.lbd.tfg.clinica.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medico {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido1;
	
	@Column
	private String apellido2;
	
	@Column
	private Integer NSS;

	
	
	
	public Medico(){
		
	}
	
	public Medico(Long id, String nombre, String apellido1, String apellido2, Integer NSS) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.NSS = NSS;
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

	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", NSS=" + NSS + "]";
	}
	
}
