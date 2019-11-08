package br.ufrn.alugai.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.cfg.AvailableSettings;
//import org.springframework.boot.devtools.restart.classloader.RestartClassLoader;


public class Banco {

	private static Banco singleton = new Banco();
	@PersistenceContext
	private static EntityManager em;
	
	private Banco() {
		Collection<ClassLoader> classLoaders = new ArrayList<ClassLoader>();
	    //classLoaders.add(RestartClassLoader.getPlatformClassLoader());
	    Map<String, Object> properties = new HashMap<String, Object>();
	    properties.put(AvailableSettings.CLASSLOADERS, classLoaders);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao", properties);
		em = emf.createEntityManager();
	}
	
	public static Banco getInstance() {return singleton;}
	public static EntityManager getEntityManager() {return em;}
}
