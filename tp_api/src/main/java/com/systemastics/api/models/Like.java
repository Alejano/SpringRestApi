package com.systemastics.api.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "likes")
public class Like implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		
	private Long id_usuario;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserPosts userposts;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Comentario comentario;
	
	public Like() {
		userposts = new UserPosts();
		comentario = new Comentario();
	}
	
	
	

	public Comentario getComentario() {
		return comentario;
	}



	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
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
		

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}