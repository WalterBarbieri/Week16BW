package week16BW.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import week16BW.utils.JpaUtil;

public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
	}
}
