package com.fd.admin.data_service.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public interface HibernateUtil {

	public static Session getHibernateSession() {
		final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		final Session session = sf.openSession();
		return session;
	}

}
