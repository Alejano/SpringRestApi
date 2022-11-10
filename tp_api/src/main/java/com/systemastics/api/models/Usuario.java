package com.systemastics.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String correo;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private boolean enabled;
	private String contrasena;
	private String foto;
	private String telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date datebirth;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date creatdate;
	private String edad;
	private String biog;
	private String info;
	private String apodo;

	@ManyToOne(fetch = FetchType.EAGER)
	private Authority authority;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Mascota> mascotas;

	@OneToMany(mappedBy = "amigo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Amigo> amigo;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<PedidoServicio> pedidoservicio;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Notificacion> notificaciones;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<UserPosts> userposts;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Direccion> direcciones;

	@OneToMany(mappedBy = "usuarios", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Foto> fotos;

	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private UserPlus usuarioplus;

	public Usuario() {

		mascotas = new ArrayList<Mascota>();
		usuarioplus = new UserPlus();
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Amigo> getAmigo() {
		return amigo;
	}

	public void setAmigo(List<Amigo> amigo) {
		this.amigo = amigo;
	}

	public List<PedidoServicio> getPedidoservicio() {
		return pedidoservicio;
	}

	public void setPedidoservicio(List<PedidoServicio> pedidoservicio) {
		this.pedidoservicio = pedidoservicio;
	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefon) {
		telefono = telefon;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getBiog() {
		return biog;
	}

	public void setBiog(String biog) {
		this.biog = biog;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public List<Foto> getFotos() {
		return fotos;
	}

	public void setFotos(List<Foto> fotos) {
		this.fotos = fotos;
	}

	public Date getDatebirth() {
		return datebirth;
	}

	public void setDatebirth(Date datebirth) {
		this.datebirth = datebirth;
	}

	public List<UserPosts> getUserposts() {
		return userposts;
	}

	public void setUserposts(List<UserPosts> userposts) {
		this.userposts = userposts;
	}

	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public UserPlus getUsuarioplus() {
		return usuarioplus;
	}

	public void setUsuarioplus(UserPlus usuarioplus) {
		this.usuarioplus = usuarioplus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}