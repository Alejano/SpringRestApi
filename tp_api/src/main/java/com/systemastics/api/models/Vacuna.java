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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vacunas")
public class Vacuna implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String foto_cartilla;
	private String parvovirus;
	private String moquillo;
	private String hepatitis;
	private String leptosporosis;
	private String parainfluenza;
	private String rabia;
	
	
	@OneToOne()
	@JoinColumn(name ="mascotas_id",referencedColumnName = "id")
	@JsonIgnore
	private Mascota mascotas_id;
	
	public Vacuna() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoto_cartilla() {
		return foto_cartilla;
	}

	public void setFoto_cartilla(String foto_cartilla) {
		this.foto_cartilla = foto_cartilla;
	}

	public String getParvovirus() {
		return parvovirus;
	}

	public void setParvovirus(String parvovirus) {
		this.parvovirus = parvovirus;
	}

	public String getMoquillo() {
		return moquillo;
	}

	public void setMoquillo(String moquillo) {
		this.moquillo = moquillo;
	}

	public String getHepatitis() {
		return hepatitis;
	}

	public void setHepatitis(String hepatitis) {
		this.hepatitis = hepatitis;
	}

	public String getLeptosporosis() {
		return leptosporosis;
	}

	public void setLeptosporosis(String leptosporosis) {
		this.leptosporosis = leptosporosis;
	}

	public String getParainfluenza() {
		return parainfluenza;
	}

	public void setParainfluenza(String parainfluenza) {
		this.parainfluenza = parainfluenza;
	}

	public String getRabia() {
		return rabia;
	}

	public void setRabia(String rabia) {
		this.rabia = rabia;
	}

	public Mascota getMascota() {
		return mascotas_id;
	}

	public void setMascota(Mascota mascota) {
		this.mascotas_id = mascota;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}