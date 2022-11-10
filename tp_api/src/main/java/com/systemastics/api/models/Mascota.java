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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String raza;
	private String caracteristicas_especiales;	
	private boolean enabled;
	private String foto;
	private Integer peso;
	private Integer edad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuarios;
	
	@OneToMany(mappedBy = "mascotas", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Foto> fotos;
	
	@OneToOne(mappedBy ="mascotas_id", cascade = CascadeType.ALL)	
	private Vacuna vacuna;
	
	public Mascota() {
		vacuna = new Vacuna();
	};

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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCaracteristicas_especiales() {
		return caracteristicas_especiales;
	}

	public void setCaracteristicas_especiales(String caracteristicas_especiales) {
		this.caracteristicas_especiales = caracteristicas_especiales;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}
	

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Vacuna getVacunas() {
		return vacuna;
	}

	public void setVacunas(Vacuna vacunas) {
		this.vacuna = vacunas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}