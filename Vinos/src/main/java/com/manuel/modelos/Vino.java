package com.manuel.modelos;

import java.util.Objects;

public class Vino {
	private Long id;
	private String marca;
	private String bodega;
	private Long cosecha;
	private String denominacion;
	private String tipo;
	private Long precio;
	private Long stock;
	private String localizacion;
	private String se_vende;
	
	
	public Vino(Long id, String marca, String bodega, Long cosecha, String denominacion, String tipo, Long precio,
			Long stock, String localizacion, String se_vende) {
		super();
		setId(id);
		setMarca(marca);
		setBodega(bodega);
		setCosecha(cosecha);
		setDenominacion(denominacion);
		setTipo(tipo);
		setPrecio(precio);
		setStock(stock);
		setLocalizacion(localizacion);
		setSe_vende(se_vende);
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getBodega() {
		return bodega;
	}
	public void setBodega(String bodega) {
		this.bodega = bodega;
	}
	public Long getCosecha() {
		return cosecha;
	}
	public void setCosecha(Long cosecha) {
		this.cosecha = cosecha;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getPrecio() {
		return precio;
	}
	public void setPrecio(Long precio) {
		this.precio = precio;
	}
	public Long getStock() {
		return stock;
	}
	public void setStock(Long stock) {
		this.stock = stock;
	}
	public String getLocalizacion() {
		return localizacion;
	}
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	public String getSe_vende() {
		return se_vende;
	}
	public void setSe_vende(String se_vende) {
		this.se_vende = se_vende;
	}
	@Override
	public String toString() {
		return "Vino [id=" + id + ", marca=" + marca + ", bodega=" + bodega + ", cosecha=" + cosecha + ", denominacion="
				+ denominacion + ", tipo=" + tipo + ", precio=" + precio + ", stock=" + stock + ", localizacion="
				+ localizacion + ", se_vende=" + se_vende + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bodega, cosecha, denominacion, id, localizacion, marca, precio, se_vende, stock, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vino other = (Vino) obj;
		return Objects.equals(bodega, other.bodega) && Objects.equals(cosecha, other.cosecha)
				&& Objects.equals(denominacion, other.denominacion) && Objects.equals(id, other.id)
				&& Objects.equals(localizacion, other.localizacion) && Objects.equals(marca, other.marca)
				&& Objects.equals(precio, other.precio) && Objects.equals(se_vende, other.se_vende)
				&& Objects.equals(stock, other.stock) && Objects.equals(tipo, other.tipo);
	}
	
}
