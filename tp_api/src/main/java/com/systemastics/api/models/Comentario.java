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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "comentarios")
public class Comentario implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private Long id_usuario;
	private String texto;
	private String video;
	private String foto;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fecha;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserPosts userposts;
	
	@OneToMany(mappedBy = "userposts", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Like> likes;
	
	public Comentario() {
		userposts = new UserPosts();
		likes = new ArrayList<Like>();
	}
	
	

	public List<Like> getLikes() {
		return likes;
	}



	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}



	public String getTexto() {
		return texto;
	}



	public void setTexto(String texto) {
		this.texto = texto;
	}



	public String getVideo() {
		return video;
	}



	public void setVideo(String video) {
		this.video = video;
	}



	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public UserPosts getUserposts() {
		return userposts;
	}

	public void setUserposts(UserPosts userposts) {
		this.userposts = userposts;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}