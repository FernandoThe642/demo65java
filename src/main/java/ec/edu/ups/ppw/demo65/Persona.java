package ec.edu.ups.ppw.demo65;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Persona {
	@Id
	private String cedula;
	
	private String nombre;
	private String email;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", email=" + email + "]";
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Persona(String cedula, String nombre, String email) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.email = email;
	}
	
	
	
	
}
