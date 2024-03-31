package org.BlogPersonal.entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="articulo")
public class Articulo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_articulo;
	private String titulo;
	private String nombre_autor;
	private String contenido;
	private LocalDate fecha_de_publicacion;
	private LocalTime hora_publicacion;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "articulo", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comentarios> comentarios;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="etiquetas_articulos",joinColumns= {@JoinColumn(name="id_articulo")},inverseJoinColumns={@JoinColumn(name="id_etiqueta")})
	private List<Etiquetas> etiqueta;
	
	public Articulo() {
		
	}

	public Articulo(Long id_articulo, String titulo, String nombre_autor, String contenido,
			LocalDate fecha_de_publicacion, LocalTime hora_publicacion, Usuario usuario, 
			List<Comentarios> comentarios, List<Etiquetas> etiqueta) {
		super();
		this.id_articulo = id_articulo;
		this.titulo = titulo;
		this.nombre_autor = nombre_autor;
		this.contenido = contenido;
		this.fecha_de_publicacion = fecha_de_publicacion;
		this.usuario = usuario;
		this.comentarios = comentarios;
		this.etiqueta = etiqueta;
	}



	public Long getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(Long id_articulo) {
		this.id_articulo = id_articulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNombre_autor() {
		return nombre_autor;
	}

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDate getFecha_de_publicacion() {
		return fecha_de_publicacion;
	}

	public void setFecha_de_publicacion(LocalDate fecha_de_publicacion) {
		this.fecha_de_publicacion = fecha_de_publicacion;
	}

	public LocalTime getHora_publicacion() {
		return hora_publicacion;
	}

	public void setHora_publicacion(LocalTime hora_publicacion) {
		this.hora_publicacion = hora_publicacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Comentarios> getComentarios() {
		if (comentarios == null) {
			comentarios = new ArrayList<>();
	    }
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Etiquetas> getEtiqueta() {
		if (etiqueta == null) {
			etiqueta = new ArrayList<>();
	    }
		return etiqueta;
	}

	public void setEtiqueta(List<Etiquetas> etiqueta) {
		this.etiqueta = etiqueta;
	}

}
