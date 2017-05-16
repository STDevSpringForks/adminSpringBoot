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
import com.fd.criptocurrency.data_service.repository.ExchangesRepository;
import com.fd.criptocurrency.model.criteria.ExchangesSearchCriteria;
import com.fd.criptocurrency.model.entity.ExchangeEntity;
import com.fd.criptocurrency.model.result.ExchangesSearchResult;

/**
 * 
 * @author Muguruza
 *
 */
@Repository
public class ExchangesRepositoryImpl implements ExchangesRepository {
private static final Logger LOGGER = LoggerFactory.getLogger(ExchangesRepositoryImpl.class);
	
	private static ServiceRegistry serviceRegistry;
	private static Session session;
	
	@Override
	public ExchangesSearchResult retriveExchanges(ExchangesSearchCriteria sc) {
		initSession();

		List<ExchangeEntity> list = session.createQuery("from ExchangeEntity ",ExchangeEntity.class).getResultList();
		
		endSession(true);
		
		System.out.println(list);
		
		ExchangesSearchResult result = new ExchangesSearchResult();
		result.setExchangeEntityList(list);
		
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
	public boolean saveExchange(ExchangeEntity eEntity) {
		initSession();
		try{
			session.save(eEntity);
			endSession(true);
		}catch(Exception e){
			LOGGER.error("saveExchange", e);
			endSession(false);
		}
		return true;
	}
}
