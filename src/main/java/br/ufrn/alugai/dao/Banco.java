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
	
	private static EntityManagerFactory emf;
	
	private Banco() {
		emf = Persistence.createEntityManagerFactory("conexao");
	}
	
	public static Banco getInstance() {return singleton;}
	public static EntityManager getEntityManager() {return emf.createEntityManager();}
}
