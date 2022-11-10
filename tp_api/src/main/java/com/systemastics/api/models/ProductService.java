package com.systemastics.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos_servicios")
public class ProductService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Long precio;
	private String tiempo_servicio;
	private String foto;
	private String descripcion;
	private Long tipo;

	@ManyToOne(fetch = FetchType.LAZY)
	private UserPlus usuariosp;
	
	@OneToMany(mappedBy = "productos_servicios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Calificacion> calificaciones;
	
	@OneToMany(mappedBy = "productos_servicios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Direccion> direcciones;
	
	public ProductService() {
	calificaciones = new ArrayList<Calificacion>();
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

	public Long getPrecio() {
		return precio;
	}

	public void setPrecio(Long precio) {
		this.precio = precio;
	}

	public String getTiempo_servicio() {
		return tiempo_servicio;
	}

	public void setTiempo_servicio(String tiempo_servicio) {
		this.tiempo_servicio = tiempo_servicio;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UserPlus getUsuariosp() {
		return usuariosp;
	}

	public void setUsuariosp(UserPlus usuariospremium) {
		this.usuariosp = usuariospremium;
	}
	
	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}