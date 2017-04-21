package com.fd.admin.data_service.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fd.admin.data_service.repository.PersonRepository;
import com.fd.admin.model.criteria.PersonListDetailsSearchCriteria;
import com.fd.admin.model.entity.PersonListDetailsEntity;
import com.fd.admin.model.result.PersonListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class PersonRepositoryImpl implements PersonRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(PersonRepositoryImpl.class);
	
	@Override
	public PersonListDetailsResult retrievePersonListDetails(PersonListDetailsSearchCriteria searchCriteria) {

		PersonListDetailsResult personListDetailsResult = new PersonListDetailsResult();

		SessionFactory sessionFactory = null;
		/*
		Session session = null;
		Transaction tx = null;
		*/
		try {
			
			/*
			
			// Get Session
			sessionFactory = HibernateAnnotationUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			System.out.println("Session created");
			// start transaction
			tx = session.beginTransaction();
			
			*/
			
			// Create a session factory
			sessionFactory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(PersonListDetailsEntity.class).buildSessionFactory();

			// Create session
			Session session = sessionFactory.getCurrentSession();
			
			// create a student object
			session.beginTransaction();

			// Save the Model objects
			// session.save(cart);
			// session.save(item1);
			// session.save(item2);

			// Query personDetails
			List<PersonListDetailsEntity> personListDetailsEntity = session.createQuery("from PersonListDetailsEntity ",PersonListDetailsEntity.class).getResultList();
			displayPersonListDetailsEntity(personListDetailsEntity);

			session.getTransaction().commit();
			
			/*
			// Commit transaction
			tx.commit();
			*/

		} catch (Exception e) {
			System.out.println("Exception occured. " + e.getMessage());
			e.printStackTrace();
		} finally {
			if (!sessionFactory.isClosed()) {
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}

		return personListDetailsResult;
	}

	private void displayPersonListDetailsEntity(List<PersonListDetailsEntity> personListDetailsEntity) {
		for (PersonListDetailsEntity personListDetailsEntity2 : personListDetailsEntity) {
			System.out.println(personListDetailsEntity2);
		}
	}

	@Override
	public boolean savePersonListDetails(PersonListDetailsEntity personListDetailsEntity) {

		boolean bResult = false;

		// Create a session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(PersonListDetailsEntity.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			session.beginTransaction();

			// start a transaction
			LOGGER.info("Save the object...");
			session.save(personListDetailsEntity);

			// save the student object
			session.getTransaction().commit();

			// commit transaction
			LOGGER.info("Done...");

			bResult = true;

		} finally {
			factory.close();
		}

		return bResult;

	}

}