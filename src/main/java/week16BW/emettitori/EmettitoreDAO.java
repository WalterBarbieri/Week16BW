package week16BW.emettitori;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmettitoreDAO {
	private final EntityManager em;

	private static Logger log = LoggerFactory.getLogger(EmettitoreDAO.class);
	public EmettitoreDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Emettitore e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		log.info("Emettitore salvato!");
	}

	public Emettitore findByCodiceTessera(Long codice_emettitore) {
		Emettitore trova = em.find(Emettitore.class, codice_emettitore);
		if (trova != null) {
			return trova;
		} else {
			log.info("Emettitore non trovato");
		}
		return trova;
	}
}
