package es.udc.lbd.tfg.clinica.model.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paciente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private String apellido1;
	
	@Column(nullable = false)
	private String apellido2;
	
	@Column(nullable = false, unique = true)
	private String DNI;
	
	@Enumerated(EnumType.STRING)
	private GeneroEnum genero;
	
	@Column(unique = true)
	private String correo;

	@Column(nullable = false)
	private LocalDate fecha_nacimiento;
	
	/*usages of localDate
		LocalDate localDate = LocalDate.now();
		LocalDate.of(2015, 02, 20); 
		LocalDate.parse("2015-02-20");
	*/
	
	@Column(nullable = false)
	private String dirección;
	
	@Column(nullable = false, unique = true)
	private Integer num_telefono;

	
	public Paciente(){
		
	}
	
	public Paciente(String nombre, String apellido1, String apellido2, String DNI, GeneroEnum genero,
			String correo, LocalDate fecha_nacimiento, String dirección, Integer num_telefono) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.DNI = DNI;
		this.genero = genero;
		this.correo = correo;
		this.fecha_nacimiento = fecha_nacimiento;
		this.dirección = dirección;
		this.num_telefono = num_telefono;
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

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", DNI=" + DNI + ", genero=" + genero + ", correo=" + correo + ", fecha_nacimiento="
				+ fecha_nacimiento + ", dirección=" + dirección + ", num_telefono=" + num_telefono + "]";
	}
	
	
}
