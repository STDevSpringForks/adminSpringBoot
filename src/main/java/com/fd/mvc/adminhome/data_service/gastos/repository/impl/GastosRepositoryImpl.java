package com.fd.mvc.adminhome.data_service.gastos.repository.impl;

import com.fd.mvc.adminhome.data_service.gastos.repository.GastosRepository;
import com.fd.mvc.adminhome.model.gastos.criteria.GastosListDetailsSearchCriteria;
import com.fd.mvc.adminhome.model.gastos.entity.GastoEntity;
import com.fd.mvc.adminhome.model.gastos.result.GastosListDetailsResult;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

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
			LOGGER.error("saveGastosListDetails", e);
			endSession(false);
		}
		return true;
	}

}
