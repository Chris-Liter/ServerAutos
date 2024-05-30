package Automoviles.autos.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Autos{

	//private static final long serialVersionUID = 1L;
	
	@Id	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autos_seq")
    @SequenceGenerator(name = "autos_seq", sequenceName = "autos_seq", allocationSize = 1)
	private int codigo;
	private String marca;
	private String color;
	private String placa;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	
	@Override
	public String toString() {
		return "Autos [codigo=" + codigo + ", marca=" + marca + ", color=" + color + ", placa=" + placa + "]";
	}
	
	
}
