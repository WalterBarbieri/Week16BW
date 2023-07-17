package week16BW.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main {
	private static EntityManagerFactory emf = week16BW.utils.JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		System.out.println("Ciao");
	}
}
