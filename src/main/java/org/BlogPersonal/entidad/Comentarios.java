package org.BlogPersonal.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentarios implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_comentario;
	private String comentario;
	private LocalDate fecha_comentario;
	private LocalTime hora_comentario;
	
	@ManyToOne
	private Articulo articulo;
	
	@ManyToOne
	private Usuario usuario;
	
	public Comentarios() {}

	public Comentarios(Long id_comentario, String comentario, LocalDate fecha_comentario,
			LocalTime hora_comentario, Articulo articulo, Usuario usuario) {
		super();
		this.id_comentario = id_comentario;
		this.comentario = comentario;
		this.fecha_comentario = fecha_comentario;
		this.hora_comentario = hora_comentario;
		this.articulo = articulo;
		this.usuario = usuario;
	}



	public Long getId_comentario() {
		return id_comentario;
	}

	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDate getFecha_comentario() {
		return fecha_comentario;
	}

	public void setFecha_comentario(LocalDate fecha_comentario) {
		this.fecha_comentario = fecha_comentario;
	}

	public LocalTime getHora_comentario() {
		return hora_comentario;
	}

	public void setHora_comentario(LocalTime hora_comentario) {
		this.hora_comentario = hora_comentario;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
