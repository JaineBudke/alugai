package br.ufrn.alugai.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;


public class Banco {

	private static Banco singleton = new Banco();
	
	private static EntityManager em;
	
	private Banco() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexao");
		em = emf.createEntityManager();
	}
	
	public static Banco getInstance() {return singleton;}
	public static EntityManager getEntityManager() {return em;}
}
