package com.fd.criptocurrency.data_service.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.fd.adminHome.model.gastos.entity.GastoEntity;
import com.fd.criptocurrency.data_service.repository.FaucetsRepository;
import com.fd.criptocurrency.model.criteria.FaucetsSearchCriteria;
import com.fd.criptocurrency.model.entity.FaucetEntity;
import com.fd.criptocurrency.model.result.FaucetsSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class FaucetsRepositoryImpl implements FaucetsRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(FaucetsRepositoryImpl.class);
	
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	@Override
	public FaucetsSearchResult retriveFaucets(FaucetsSearchCriteria sc) {
		initSession();

		List<FaucetEntity> list = session.createQuery("from FaucetEntity ",FaucetEntity.class).getResultList();
		
		endSession(true);
		
		System.out.println(list);
		
		FaucetsSearchResult result = new FaucetsSearchResult();
		result.setFaucetSearchResult(list);
		
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
	public boolean saveFaucet(FaucetEntity fEntity) {
		initSession();
		try{
			session.save(fEntity);
			endSession(true);
		}catch(Exception e){
			LOGGER.error("saveFaucet", e);
			endSession(false);
		}
		return true;
	}

}
