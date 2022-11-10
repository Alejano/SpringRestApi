
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuariosp")
public class UserPlus implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre_empresa;
	private String ine;
	private String stripe_id;
	

	
	@OneToMany(mappedBy = "usuariosp", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ProductService> ProductServices;

	@ManyToMany
	@JoinTable(
			name="usuariosp_servicios",
			joinColumns = @JoinColumn(name = "id_usuariosp"),
			inverseJoinColumns = @JoinColumn(name = "id_servicios")
		)
	private List<Servicio> serviciosUsuariosp = new ArrayList<>();

	@OneToOne()
	@JoinColumn(name = "usuario", referencedColumnName = "id")
	@JsonIgnore
	private Usuario usuario;

	public UserPlus() {
	}
	
	
	
	public String getStripe_id() {
		return stripe_id;
	}



	public void setStripe_id(String stripe_id) {
		this.stripe_id = stripe_id;
	}



	public void addservice(Servicio servicio) {
		serviciosUsuariosp.add(servicio);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String getNombre_empresa() {
		return nombre_empresa;
	}

	public void setNombre_empresa(String nombre_empresa) {
		this.nombre_empresa = nombre_empresa;
	}

	public List<Servicio> getServiciosUsuariosp() {
		return serviciosUsuariosp;
	}

	public void setServiciosUsuariosp(List<Servicio> serviciosUsuariosp) {
		this.serviciosUsuariosp = serviciosUsuariosp;
	}

	public List<ProductService> getProductServices() {
		return ProductServices;
	}

	public void setProductServices(List<ProductService> productServices) {
		ProductServices = productServices;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}