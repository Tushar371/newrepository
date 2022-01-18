package com.demo.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.demo.pojo.Customer;

public class CustomerDAO {
	
	public static Session getSession() {

		StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		SessionFactory sessionFactory= metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession(); // start a transaction			
		return session;
	}
	
	public void addCustomer(Customer cust) {
		
		Session session=getSession();
		Transaction tr=session.beginTransaction();
		session.save(cust);
		tr.commit();
	}

}
