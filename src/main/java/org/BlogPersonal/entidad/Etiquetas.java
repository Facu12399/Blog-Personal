package org.BlogPersonal.entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="etiquetas")
public class Etiquetas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_etiqueta;
	private String nombre;
	
	public Etiquetas() {}

	public Etiquetas(Long id_etiqueta, String nombre) {
		super();
		this.id_etiqueta = id_etiqueta;
		this.nombre = nombre;
	}

	public Long getId_etiqueta() {
		return id_etiqueta;
	}

	public void setId_etiqueta(Long id_etiqueta) {
		this.id_etiqueta = id_etiqueta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
