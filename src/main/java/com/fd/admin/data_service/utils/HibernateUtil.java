package com.fd.admin.data_service.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase se utilidad para la gestión del framework de persistencia ORM (Object Relational Mapping) Hibernatae.
 * Object Relational Mapping : Mapear las tablas con los objetos.
 * Hibernate tmb se apoya en las anotaciones JPA.
 * @author Muguruza
 *
 */
public class HibernateUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();

	/**
	 * Construyendo la session factory como método privado.
	 * @return
	 */
	private static SessionFactory buildSessionFactory() {
		try{
			//Hibernate 5.x
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
			
			return metaData.getSessionFactoryBuilder().build();
		}catch(Throwable ex){
			LOGGER.error("Fallo en la creación de SessionFactory-Hibernate.",ex);
			//Lanzando exception declarando que hubo un error en una inicialización estatica.
			throw new ExceptionInInitializerError(ex);
		}
		
	}

	/**
	 * Método Get del objto SessionFactory.
	 * @return
	 */
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	

}
