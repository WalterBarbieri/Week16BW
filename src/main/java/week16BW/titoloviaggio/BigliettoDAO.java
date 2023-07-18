package week16BW.titoloviaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BigliettoDAO {
	private final EntityManager em;

	public BigliettoDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	// Salva elemento nel DataBase
	public void save(Biglietto b) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(b);

		t.commit();
		System.out.println("Biglietto registrato correttamente\n");
	}

}
