package com.fd.adminHome.data_service.gastos.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

import com.fd.adminHome.data_service.gastos.repository.GastosRepository;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.GastosListDetailsEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class GastosRepositoryImpl implements GastosRepository {

	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	@Override
	public GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria) {
		initSession();
//		GastosListDetailsEntity gasto = (GastosListDetailsEntity) session.get(GastosListDetailsEntity.class, 1);
		
		//Start OK ---
//		Query query = session.createQuery("FROM GastosListDetailsEntity");
//		List<GastosListDetailsEntity> list = (List<GastosListDetailsEntity>)query.list();
		//End OK ---

		List<GastosListDetailsEntity> list = session.createQuery("from GastosListDetailsEntity ",GastosListDetailsEntity.class).getResultList();
		
		endSession();
		
		GastosListDetailsResult result = new GastosListDetailsResult();
		result.setGastosListDetailsEntity(list);
		
		return result;
	}
	
	private static void initSession() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry	= new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration.addAnnotatedClass(GastosListDetailsEntity.class).buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	private static void endSession() {
		session.getTransaction().commit();
		session.close();
		
		StandardServiceRegistryBuilder.destroy(serviceRegistry);		
	}

}
