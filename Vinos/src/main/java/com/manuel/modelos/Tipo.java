package com.manuel.modelos;

import java.util.Objects;

public class Tipo {

	private Long id;
	private String tipo;
	public Tipo(Long id, String tipo) {
		setId(id);
		setTipo(tipo);
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo other = (Tipo) obj;
		return Objects.equals(id, other.id) && Objects.equals(tipo, other.tipo);
	}
	@Override
	public String toString() {
		return "Tipo [id=" + id + ", tipo=" + tipo + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
	