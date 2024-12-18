package ec.edu.ups.ppw.demo65.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Telefono {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private String tipo;
	private String numero;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	@Override
	public String toString() {
		return "Telefono [codigo=" + codigo + ", tipo=" + tipo + ", numero=" + numero + "]";
	}
	
	
	

	
	
	
}
