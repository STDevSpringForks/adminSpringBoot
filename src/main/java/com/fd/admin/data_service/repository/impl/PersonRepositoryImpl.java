package com.fd.admin.data_service.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fd.admin.data_service.config.HibernateAnnotationUtil;
import com.fd.admin.data_service.repository.PersonRepository;
import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.ObjectsEntity;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;
import com.fd.adminHome.model.gastos.entity.GastosListDetailsEntity;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepositoryImpl.class);
	
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	@Override
	public PersonListDetailsResult retrievePersonListDetails(PersonListDetailsSearchCriteria searchCriteria) {

		PersonListDetailsResult personListDetailsResult = new PersonListDetailsResult();

		initSession();
		
		// Query personDetails
		List<PersonListDetailsEntity> personListDetailsEntity = session.createQuery("from PersonListDetailsEntity ",PersonListDetailsEntity.class).getResultList();
		displayPersonListDetailsEntity(personListDetailsEntity);

		endSession();

		return personListDetailsResult;
	}

	private void displayPersonListDetailsEntity(List<PersonListDetailsEntity> personListDetailsEntity) {
		for (PersonListDetailsEntity personListDetailsEntity2 : personListDetailsEntity) {
			System.out.println(personListDetailsEntity2);
		}
	}

	@Override
	public boolean savePersonListDetails(PersonListDetailsEntity personListDetailsEntity) {

		initSession();
		
		boolean bResult = false;

		try {
			// start a transaction
			LOGGER.info("Save the object...");
			session.save(personListDetailsEntity);

			// commit transaction
			LOGGER.info("Done...");

			bResult = true;

		}catch(Exception e){
			
			e.printStackTrace();
			session.getTransaction().rollback();
			
		}finally {
			endSession();
		}

		
		return bResult;

	}
	
	private static void initSession() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry	= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration.addAnnotatedClass(PersonListDetailsEntity.class).buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	private static void endSession() {
		session.getTransaction().commit();
		session.close();
		
		StandardServiceRegistryBuilder.destroy(serviceRegistry);		
	}

}