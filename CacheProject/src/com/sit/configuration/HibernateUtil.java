package com.sit.configuration;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Environment;

import com.sit.model.Student;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory=null;
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
		Map<Object, String> map =new HashMap<>();
		map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/Cache_project");
		map.put(Environment.USER, "root");
		map.put(Environment.PASS, "root");
		map.put(Environment.SHOW_SQL, "true");
		map.put(Environment.FORMAT_SQL, "true");
		map.put(Environment.HBM2DDL_AUTO, "update");
		map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		/*
		 * in hibernate there are two cache available such as first level cache and
		 * second level cache first level cache is default enabled and second level is
		 * manually enabled
		 * 1st level is depends on session and 2nd level is depends on sessionfactory
		 */
		
		
		//After adding the ecahche jar files from lib->optional->echcahe->add files all
		map.put(Environment.USE_SECOND_LEVEL_CACHE , "true");
		map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");
		StandardServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(map).build();
		MetadataSources mds=new MetadataSources(registry);
			mds.addAnnotatedClass(Student.class);
		Metadata metadata = mds.getMetadataBuilder().build();
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		}
		return sessionFactory;
		
	}
}
