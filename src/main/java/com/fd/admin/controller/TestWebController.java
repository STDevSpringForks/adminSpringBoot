package com.fd.admin.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fd.admin.data_service.utils.HibernateUtil;
import com.fd.admin.model.entity.Person;
import com.fd.admin.model.entity.Prestamo;
import com.fd.admin.model.internet.entity.InternetEmailAccounts;
import com.fd.admin.model.internet.entity.InternetPages;

/**
 * Controller para resalizar algunas pruebas de código.
 * @author Muguruza
 *
 */
@Controller
@RequestMapping(value = "/test")
public class TestWebController {
	
	@GetMapping("/hibernateSaveInternetEmailAccounts")
	public String probandoSaveHibernateInternetEmailAccounts(){

    	Session session = HibernateUtil.getSessionfactory().openSession();
    	session.beginTransaction();
    	
    	//Crear Instancia
    	InternetEmailAccounts iea = new InternetEmailAccounts("elcorreo@gmail.com");
    	
    	//Insert                  Hibernate: insert into InternetEmailAccounts (email) values (?)
    	session.save(iea);
    	
    	session.getTransaction().commit();
    	session.close();
    	
    	return "test/viewTest";
	}
	
	@GetMapping("/hibernateSaveInternetPages")
	public String probandoSaveHibernateInternetPages(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	session.beginTransaction();
    	
    	//Crear Instancia
    	InternetPages iea = new InternetPages("http://www.lapagina.com/");
    	
    	//Insert                  Hibernate: insert into InternetPages (urlPage) values (?)
    	session.save(iea);
    	
    	session.getTransaction().commit();
    	session.close();
		
		return "test/viewTest";
	}
	
	/**
	 * HQL
	 * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhere")
	public String probandoSaveHibernateInternetPagesWhere(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	session.beginTransaction();
    	
    	Query query = session.createQuery("from InternetEmailAccounts where email = :email ");
    	query.setParameter("email", "cm850101@gmail.com");
    	
    	List<InternetEmailAccounts> listEmails = query.getResultList();
    	System.out.println(listEmails.toString());
    	
    	session.getTransaction().commit();
    	session.close();
		
		return "test/viewTest";
	}
	
	/**
	 * HQL
	 * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhere2")
	public String probandoSaveHibernateInternetPagesWhere2(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	session.beginTransaction();
    	
    	CriteriaBuilder builder = session.getCriteriaBuilder();

    	CriteriaQuery<InternetPages> criteria = builder.createQuery( InternetPages.class );
    	Root<InternetPages> root = criteria.from( InternetPages.class );
    	criteria.select( root );
    	criteria.where( builder.equal( root.get("urlPage"), "global.com" ) );
    	
    	//hibernate-jpamodelgen pom
    	//criteria.where( builder.equal( root.get(InternetPages_.urlPage), "global.com" ) );

    	List<InternetPages> listEmails = session.createQuery( criteria ).getResultList();
    	
    	System.out.println(listEmails.toString());
    	
    	session.getTransaction().commit();
    	session.close();
		
		return "test/viewTest";
	}
	/**
	 * HQL
	 * https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhereTransaction")
	public String probandoSaveHibernateInternetPagesWhereTransaction(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		//Fábrica para las piezas individuales de la criteria.
    		CriteriaBuilder builder = session.getCriteriaBuilder();
    		CriteriaQuery<InternetPages> criteria = builder.createQuery( InternetPages.class );
    		
    		//Definir el tipo de entidad que retorna la consulta
    		Root<InternetPages> root = criteria.from( InternetPages.class );
    		
    		//Construyendo la consulta
    		criteria.select( root );
        	criteria.where( builder.equal( root.get("urlPage"), "http://www.globaltestmarket.com/" ) );
    		
        	InternetPages internetPages = session.createQuery(criteria).getSingleResult();
        	System.out.println(internetPages);
        	
        	
        	//Actualizar el estado del tramite
        	internetPages.setUrlPage("www.globaltestmarket.com");
        	/*session.update(internetPages);*/
        	
        	InternetPages internetPagesInsert = new InternetPages("yahoo.com.mx33");

        	session.saveOrUpdate(internetPagesInsert);
        	session.saveOrUpdate(internetPages);
        	
        	
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}
	
	/**
	 * Tupla
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhereTransactionTupla")
	public String probandoSaveHibernateInternetPagesWhereTransactionTupla(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		//Fábrica para las piezas individuales de la criteria.
    		CriteriaBuilder builder = session.getCriteriaBuilder();
    		CriteriaQuery<Tuple> criteria = builder.createQuery(Tuple.class);
    		
    		Root<InternetPages> root = criteria.from( InternetPages.class );
    		Path<Integer> idInternetPagesPath = root.get("idInternetPages");
    		Path<String> urlPagePath = root.get("urlPage");
    		
    		
    		//Construyendo la consulta
    		criteria.multiselect(idInternetPagesPath,urlPagePath)
        			.where( builder.and(
        					builder.like(root.get("urlPage"), "%.com%" )),
        					builder.lessThan(root.<Integer>get("idInternetPages"), 100)
        			);
    		
        	List<Tuple> internetPages = session.createQuery(criteria).getResultList();
        	internetPages.forEach(item -> {
        		System.out.println(item.get(idInternetPagesPath) + " " + item.get(urlPagePath));
        	});
        	
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}
	
	@GetMapping("/hibernateSaveInternetPagesWhereTransactionRelacion")
	public String probandoSaveHibernateInternetPagesWhereTransactionRelacion(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		Person person = new Person("Leonel", "Sevilla", "M","leonel.sevilla@correo.com");
    		session.save(person);
    		
    		Prestamo prestamo = new Prestamo("#comida", new BigDecimal("50.00"), new Date());
        	prestamo.setPerson(person);
        	
        	session.save(prestamo);
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}
	
	@GetMapping("/hibernateSaveInternetPagesWhereTransactionload")
	public String probandoSaveHibernateInternetPagesWhereTransactionload(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		Person p = session.load(Person.class, 2);
    		System.out.println(p);
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}
	
	/**
	 * Delete en cascada 
	 * -------------------- @OneToOne(mappedBy = "personId",cascade = CascadeType.REMOVE)
	   -------------------- private Tarea tarea;
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhereTransactionDeleteEnCascada")
	public String hibernateSaveInternetPagesWhereTransactionDeleteEnCascada(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
//    		Person p = new Person("Rafael","Guzman","M","r@correo.com");
//    		session.save(p);
    		
    		Person p = session.load(Person.class,15);
//    		
//    		Tarea tarea = new Tarea("La primera tarea");
//    		tarea.setPersonId(p);
//    		session.save(tarea);
    		
    		session.remove(p);
    		
    		
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}
	
	/**
	 * Esperando respuesta de JOIn para testear.
	 * @return
	 */
	@GetMapping("/hibernateSaveInternetPagesWhereTransactionJOIN")
	public String hibernateSaveInternetPagesWhereTransactioJOIN(){
		
		Session session = HibernateUtil.getSessionfactory().openSession();
    	Transaction tx = null;
    	try{
    		tx = session.beginTransaction();
    		
    		CriteriaBuilder builder = session.getCriteriaBuilder();
    		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
    		Root<Person> root = criteria.from(Person.class);
    		
    		
    		//Join<Person,Tarea> join = root.join( root.get("tarea"));
    	    criteria.select(root).distinct(true);	
    		
        	
    		tx.commit();
    	}catch(Exception ex){
    		
    		if(tx != null){
    			tx.rollback();
    		}
    		ex.printStackTrace();
    	}
    	finally{
    		session.close();
    	}
		
		return "test/viewTest";
	}

}
