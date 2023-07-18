package week16BW.titoloviaggio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AbbonamentoDAO {
	private final EntityManager em;

	public AbbonamentoDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	// Salva elemento nel DataBase
	public void save(Abbonamento a) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(a);

		t.commit();
		System.out.println("Abbonamento registrato correttamente\n");
	}

}
