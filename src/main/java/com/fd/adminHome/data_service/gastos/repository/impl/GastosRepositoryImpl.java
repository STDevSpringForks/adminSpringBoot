package com.fd.adminHome.data_service.gastos.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fd.adminHome.data_service.gastos.repository.GastosRepository;
import com.fd.adminHome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.adminHome.model.gastos.result.GastosListDetailsResult;

/**
 * Revisar: http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/
 * @author Muguruza
 *
 */
@Repository
public class GastosRepositoryImpl implements GastosRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(GastosRepositoryImpl.class);
	
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	@Override
	public GastosListDetailsResult retrieveGastosListDetails(GastosListDetailsSearchCriteria searchCriteria) {
		initSession();

		List<GastoEntity> list = session.createQuery("from GastoEntity ",GastoEntity.class).getResultList();
		
		endSession(true);
		
		System.out.println(list);
		
		GastosListDetailsResult result = new GastosListDetailsResult();
		result.setGastosListDetailsEntity(list);
		
		return result;
	}
	
	private static void initSession() {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		serviceRegistry	= new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		
		SessionFactory sessionFactory = configuration.addAnnotatedClass(GastoEntity.class).buildSessionFactory(serviceRegistry);
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
	}
	
	private static void endSession(boolean commit) {
		if(commit){
			session.getTransaction().commit();
		}else{
			session.getTransaction().rollback();
		}
		session.close();
		StandardServiceRegistryBuilder.destroy(serviceRegistry);		
	}

	@Override
	public boolean saveGastosListDetails(GastoEntity gEntity) {
		initSession();
		try{
			session.save(gEntity);
			endSession(true);
		}catch(Exception e){
			e.printStackTrace();
			endSession(false);
		}
		return true;
	}

}
