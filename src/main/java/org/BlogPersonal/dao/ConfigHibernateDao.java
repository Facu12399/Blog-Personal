package org.BlogPersonal.dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.BlogPersonal.entidad.Articulo;
import org.BlogPersonal.entidad.Comentarios;
import org.BlogPersonal.entidad.Etiquetas;
import org.BlogPersonal.entidad.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class ConfigHibernateDao {

    private SessionFactory sessionFactory;

    public ConfigHibernateDao() {
        // Configuración de Hibernate
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    public Session abrirSesion() {
        // Abrir sesion
        return sessionFactory.openSession();
    }
    
    public void guardarUsuario(Usuario usuario) {
    	//Guardar la entidad
        Session session = abrirSesion();
        session.beginTransaction();

        try {
            session.save(usuario);
            System.out.println("El usuario se ha guardado con éxito.");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error al guardar un usuario: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void publicarArticulo(Articulo articulo) {
    	//Guardar la entidad
        Session session = abrirSesion();
        session.beginTransaction();

        try {
            session.save(articulo);
            System.out.println("El articulo se ha publicado con exito.");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error al publicar el articulo: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    

    public void agregarEtiquetas(Etiquetas etiqueta) {
    	//Guardar la entidad
        Session session = abrirSesion();
        session.beginTransaction();

        try {
            session.save(etiqueta);
            System.out.println("La etiqueta se ha agregado con exito.");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error al intentar agregar etiquetas: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void hacerComentario(Comentarios comentario) {
    	//Guardar la entidad
        Session session = abrirSesion();
        session.beginTransaction();

        try {
            session.save(comentario);
            System.out.println("Usted ha realizado un comentario al articulo.");
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Error al realizar un comentario al articulo: " + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public void leerArticulos() {
    	Session session = abrirSesion();
    	session.beginTransaction();
    	
    	try {
    		List<Articulo> lista = (List<Articulo>) session.createQuery("FROM Articulo").list();
    		
    		for(Articulo articulo: lista) {
    			System.out.println("Publicado por: " + articulo.getUsuario().getUsername() );
    			System.out.println("Autor: " + articulo.getNombre_autor());
    			System.out.println("Titulo: " + articulo.getTitulo());
    			System.out.println("Contenido: " + articulo.getContenido());
    			System.out.println("Fecha y hora de publicacion: " + articulo.getFecha_de_publicacion() + " " + articulo.getHora_publicacion());
    			System.out.print("Etiquetas: ");
    			for(int i=0;i<articulo.getEtiqueta().size();i++) {
    				System.out.print(articulo.getEtiqueta().get(i).getNombre() + " ");
    			}
    			System.out.println("");
    			for(int i=0;i<articulo.getComentarios().size();i++) {
    				System.out.println("El usuario " + articulo.getComentarios().get(i).getUsuario().getUsername() + " ha comentado: ");
    				System.out.println(articulo.getComentarios().get(i).getComentario());
    				System.out.println("Fecha y hora en que ha comentado: " + articulo.getComentarios().get(i).getFecha_comentario() + " " +
    				articulo.getComentarios().get(i).getHora_comentario());
    			}
    			System.out.println();
    		}
    	}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al leer la entidad Articulo: " + e.getMessage());
    	}finally {
    		session.close();
    	}
    }
    
    public void deleteUsuario(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Usuario usuario = (Usuario) session.get(Usuario.class, id);
			session.delete(usuario);
			System.out.println("El usuario " + usuario.getUsername() + " ha sido eliminado con exito.");	        
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al eliminar el usuario: " + e.getMessage());
    	}finally {
    		session.close();
    	}	
	}
    
    public void deleteArticulo(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Articulo articulo = (Articulo) session.get(Articulo.class, id);
			session.delete(articulo);
			System.out.println("El articulo ha sido eliminado con exito.");	        
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al eliminar el articulo: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
    
    public void deleteComentario(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Comentarios comentario = (Comentarios) session.get(Comentarios.class, id);
			session.delete(comentario);
			System.out.println("El comentario ha sido eliminado con exito.");  
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al eliminar el comentario: " + e.getMessage());
    	}finally {
    		session.close();
    	}
		
	}
    
    public void deleteEtiquetas(Long id) {
        Session session = abrirSesion();
        session.beginTransaction();
		try {
			
			Etiquetas etiqueta = (Etiquetas) session.get(Etiquetas.class, id);
			session.delete(etiqueta);
			System.out.println("La etiqueta ha sido eliminado con exito.");
	        
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al eliminar la etiqueta: " + e.getMessage());
    	}finally {
    		session.close();
    	}
		
	}
    
    public void editUsuario(Long id_usuario, String nuevo_username, String nuevo_email, String nuevo_password) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Usuario usuario = (Usuario) session.get(Usuario.class, id_usuario); 
			usuario.setUsername(nuevo_username);
			usuario.setEmail(nuevo_email);
			usuario.setPassword(nuevo_password);
			
			session.update(usuario);
	        System.out.println("Se ha actualizado el usuario");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al intentar actualizar el usuario: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
    
    public void editArticulo(Long id_articulo, String nuevo_titulo, String nuevo_nombre_autor, String nuevo_contenido,
    		LocalDate nueva_fecha_publicacion, LocalTime nueva_hora_publicacion) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Articulo articulo = (Articulo) session.get(Articulo.class, id_articulo); 
			articulo.setTitulo(nuevo_titulo);
			articulo.setNombre_autor(nuevo_nombre_autor);
			articulo.setContenido(nuevo_contenido);
			articulo.setFecha_de_publicacion(nueva_fecha_publicacion);
			articulo.setHora_publicacion(nueva_hora_publicacion);

			session.update(articulo);
	        System.out.println("Se ha actualizado el articulo");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al intentar actualizar el articulo: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
    
    public void editComentario(Long id_comentario, String nuevo_comentario, LocalDate nueva_fecha_comentario, LocalTime nueva_hora_comentario) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Comentarios comentario = (Comentarios) session.get(Comentarios.class, id_comentario);
			comentario.setComentario(nuevo_comentario);
			comentario.setFecha_comentario(nueva_fecha_comentario);
			comentario.setHora_comentario(nueva_hora_comentario);
			
			session.update(comentario);
	        System.out.println("Se ha actualizado el comentario");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al intentar actualizar el comentario: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
    
    public void editEtiqueta(Long id_etiqueta, String nuevo_nombre) {
		Session session = abrirSesion();
        session.beginTransaction();
        
		try {	
			Etiquetas etiqueta = (Etiquetas) session.get(Etiquetas.class, id_etiqueta);
			etiqueta.setNombre(nuevo_nombre);
			
			session.update(etiqueta);
	        System.out.println("Se ha actualizado la etiqueta");
			
			session.getTransaction().commit();
		}catch (Exception e) {
    		session.getTransaction().rollback();
            System.err.println("Error al intentar actualizar la etiqueta: " + e.getMessage());
    	}finally {
    		session.close();
    	}
	}
    
    public void cerrarSesion() {
        // Cierra la sesión
        sessionFactory.close();
    }
    
}
