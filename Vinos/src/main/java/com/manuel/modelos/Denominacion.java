package com.manuel.modelos;

import java.util.Objects;

public class Denominacion {
	private Long id;
	private String denominacion;
	public Denominacion(Long id, String denominacion) {
		setId(id);
		setDenominacion(denominacion);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	@Override
	public String toString() {
		return "Denominacion [id=" + id + ", denominacion=" + denominacion + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(denominacion, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Denominacion other = (Denominacion) obj;
		return Objects.equals(denominacion, other.denominacion) && Objects.equals(id, other.id);
	}
	

}
