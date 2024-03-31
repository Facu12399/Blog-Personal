package org.BlogPersonal;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalTime;

import org.BlogPersonal.dao.ConfigHibernateDao;
import org.BlogPersonal.entidad.Articulo;
import org.BlogPersonal.entidad.Comentarios;
import org.BlogPersonal.entidad.Etiquetas;
import org.BlogPersonal.entidad.Usuario;
import org.junit.jupiter.api.Test;

class AppTest {

	@Test
	public void test() {

    	ConfigHibernateDao service = new ConfigHibernateDao();
    	
    	service.abrirSesion();
    	
    	Usuario usuario1 = new Usuario();
        
    	//creo un usuario 1
    	usuario1.setUsername("Facu12399");
    	usuario1.setPassword("guitarra123");
    	usuario1.setEmail("facundonahuelmaza@gmail.com");
    	
    	Usuario usuario2 = new Usuario();
    	
    	//creo un usuario 2
    	
    	usuario2.setUsername("Flor7564");
    	usuario2.setPassword("biblio321");
    	usuario2.setEmail("flors@hotmail.com");
    	
    	Articulo articulo1 = new Articulo();
    	
    	//Formateo la fecha para tener el dia de la publicacion del usuario 1
    	LocalDate fecha_publicacion1 = LocalDate.of(2024, 03, 11);
    	
    	//Formateo la hora de la publicacion del usuario 1
    	LocalTime hora_publicacion1 = LocalTime.of(20, 15, 30);
    	
    	
    	//El usuario 1 publica un articulo
    	articulo1.setTitulo("La música y sus estereotipos que contaminan");
    	articulo1.setNombre_autor("Facundo Nahuel Maza");
    	articulo1.setContenido("La nueva música esta rodeada de malas letras que contaminan el oido de niños y jovenes.");
    	articulo1.setFecha_de_publicacion(fecha_publicacion1);
    	articulo1.setHora_publicacion(hora_publicacion1);
    	
    	//Creo la instancia para publicar el articulo 2
    	Articulo articulo2 = new Articulo();
    	
    	//Formateo la fecha para tener el dia de la publicacion del usuario 1
    	LocalDate fecha_publicacion2 = LocalDate.of(2024, 03, 24);
    	
    	//Formateo la hora de la publicacion del usuario 1
    	LocalTime hora_publicacion2 = LocalTime.of(17, 40, 05);
    	
    	//El usuario 2 publica un articulo
    	articulo2.setTitulo("La importancia de las uñas y no solo para las mujeres");
    	articulo2.setNombre_autor("Florencia Aguirre");
    	articulo2.setContenido("En estos tiempos, las mujeres queremos cuidar mejor nuestras uñas, y al parecer los hombres tambien");
    	articulo2.setFecha_de_publicacion(fecha_publicacion2);
    	articulo2.setHora_publicacion(hora_publicacion2);
    	
    	//Solo hace falta setear el usuario al articulo
    	articulo1.setUsuario(usuario1);
    	
    	//Ahora el articulo 2
    	articulo2.setUsuario(usuario2);
    	
    	//Creo etiquetas para el articulo 1 en total 2
    	Etiquetas etiqueta1 = new Etiquetas();
    	Etiquetas etiqueta2 = new Etiquetas();
    	
    	etiqueta1.setNombre("#educacion");
    	etiqueta2.setNombre("#musica");
    	
    	//Agrego etiquetas a articulo 1
    	articulo1.getEtiqueta().add(etiqueta1);
    	articulo1.getEtiqueta().add(etiqueta2);
    	
    	//Creo etiquetas para el articulo 2 en total 3
    	Etiquetas etiqueta3 = new Etiquetas();
    	Etiquetas etiqueta4 = new Etiquetas();
    	Etiquetas etiqueta5 = new Etiquetas();
    	
    	etiqueta3.setNombre("#mujeres");
    	etiqueta4.setNombre("#uñas");
    	etiqueta5.setNombre("#cutis");
    	
    	//Agrego etiquetas a articulo 2
    	articulo2.getEtiqueta().add(etiqueta3);
    	articulo2.getEtiqueta().add(etiqueta4);
    	articulo2.getEtiqueta().add(etiqueta5);
    	
    	//Creo la instancia para el comentario
    	Comentarios comentario1 = new Comentarios();
    	
    	//Formateo la fecha para tener el dia del comentario
    	LocalDate fecha_comentario1 = LocalDate.of(2024, 03, 12);
    	
    	//Formateo la hora para tener el dia del comentario
    	LocalTime hora_comentario1 = LocalTime.of(19, 50, 30);
    	
    	//El usuario 2 hace un comentario al articulo publicado por el usuario 1
    	comentario1.setComentario("Es verdad, la letra en una epoca fue lo mas hermoso de las canciones.");
    	comentario1.setFecha_comentario(fecha_comentario1);
    	comentario1.setHora_comentario(hora_comentario1);
    	
    	//Agrego el comentario al articulo
    	comentario1.setArticulo(articulo1);
    	
    	//Agrego el usuario al que le pertenece dicho comentario
    	comentario1.setUsuario(usuario2);
    	
    	//Creo la instancia para el comentario 2
    	Comentarios comentario2 = new Comentarios();
    	
    	//Formateo la fecha para tener el dia del comentario
    	LocalDate fecha_comentario2 = LocalDate.of(2024, 03, 12);
    	
    	//Formateo la hora para tener el dia del comentario
    	LocalTime hora_comentario2 = LocalTime.of(22, 00, 30);
    	
    	//El usuario 1 hace un comentario al articulo publicado por el usuario 2
    	comentario2.setComentario("Yo soy músico guitarrista y doy fe de la importancia del cuidado de uñas.");
    	comentario2.setFecha_comentario(fecha_comentario2);
    	comentario2.setHora_comentario(hora_comentario2);
    	
    	//Agrego el comentario al articulo 2
    	comentario2.setArticulo(articulo2);
    	
    	//Agrego el usuario al que le pertenece dicho comentario
    	comentario2.setUsuario(usuario1);
    	
    	//Verificamos que ningun campo sea nulo para poder guardar las entidades
    	//Usuarios
    	assertNotNull("Se esperaba una cadena de texto en el nombre de usuario", usuario1.getUsername());
    	assertNotNull("Se esperaba una cadena de texto en la contraseña de usuario", usuario1.getPassword());
    	assertNotNull("Se esperaba una cadena de texto en el email de usuario", usuario1.getEmail());
    	
    	assertNotNull("Se esperaba una cadena de texto en el nombre de usuario", usuario2.getUsername());
    	assertNotNull("Se esperaba una cadena de texto en la contraseña de usuario", usuario2.getPassword());
    	assertNotNull("Se esperaba una cadena de texto en el email de usuario", usuario2.getEmail());

    	//Articulos
    	assertNotNull("Se esperaba una cadena de texto en el titulo del articulo", articulo1.getTitulo());
    	assertNotNull("Se esperaba una cadena de texto en el nombre del autor del articulo", articulo1.getNombre_autor());
    	assertNotNull("Se esperaba una cadena de texto en el contenido del articulo", articulo1.getContenido());
    	assertNotNull("Se esperaba insertar una fecha en la publicacion del articulo", articulo1.getFecha_de_publicacion());
    	assertNotNull("Se esperaba insertar una hora en la publicacion del articulo", articulo1.getHora_publicacion());
    	
    	assertNotNull("Se esperaba una cadena de texto en el titulo del articulo", articulo2.getTitulo());
    	assertNotNull("Se esperaba una cadena de texto en el nombre del autor del articulo", articulo2.getNombre_autor());
    	assertNotNull("Se esperaba una cadena de texto en el contenido del articulo", articulo2.getContenido());
    	assertNotNull("Se esperaba insertar una fecha en la publicacion del articulo", articulo2.getFecha_de_publicacion());
    	assertNotNull("Se esperaba insertar una hora en la publicacion del articulo", articulo2.getHora_publicacion());
    	
    	//Etiquetas
    	assertNotNull("Se esperaba una cadena de texto en el nombre de la etiqueta", etiqueta1.getNombre());
    	assertNotNull("Se esperaba una cadena de texto en el nombre de la etiqueta", etiqueta2.getNombre());
    	assertNotNull("Se esperaba una cadena de texto en el nombre de la etiqueta", etiqueta3.getNombre());
    	assertNotNull("Se esperaba una cadena de texto en el nombre de la etiqueta", etiqueta4.getNombre());
    	assertNotNull("Se esperaba una cadena de texto en el nombre de la etiqueta", etiqueta5.getNombre());
    	
    	//Comentarios
    	assertNotNull("Se esperaba una cadena de texto en el comentario", comentario2.getComentario());
    	assertNotNull("Se esperaba insertar una fecha para publicar el comentario", comentario2.getFecha_comentario());
    	assertNotNull("Se esperaba insertar una hora en la publicacion del articulo", comentario2.getHora_comentario());
    	

    	//Guardamos al usuario 1, publicamos un articulo y agregamos etiquetas
    	service.guardarUsuario(usuario1);
    	service.publicarArticulo(articulo1);
    	System.out.println();
    	
    	//Guardamos el usuario 2, publicamos un articulo y agregamos etiquetas
    	service.guardarUsuario(usuario2);
    	service.publicarArticulo(articulo2);
    	System.out.println();
    	
    	
    	//Guardamos los dos comentarios
    	service.hacerComentario(comentario1);
    	service.hacerComentario(comentario2);
    	System.out.println();
    	
    	service.cerrarSesion();
	}

}
