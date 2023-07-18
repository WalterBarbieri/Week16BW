package week16BW.tesserautente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class TesseraDAO {
	private final EntityManager em;

	public TesseraDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Tessera e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Tessera salvata!");
	}

	public Utente findByCodiceTessera(Long codice_tessera) {
		Utente trova = em.find(Utente.class, codice_tessera);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Tessera non trovata");
		}
		return trova;
	}
}
