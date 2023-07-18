package week16BW.emettitori;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EmettitoreDAO {
	private final EntityManager em;

	public EmettitoreDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Emettitore e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		System.out.println("Emettitore salvato!");
	}

	public Emettitore findByCodiceTessera(Long codice_emettitore) {
		Emettitore trova = em.find(Emettitore.class, codice_emettitore);
		if (trova != null) {
			return trova;
		} else {
			System.out.println("Emettitore non trovato");
		}
		return trova;
	}
}
