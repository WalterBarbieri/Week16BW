package week16BW.tesserautente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtenteDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(UtenteDAO.class);

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		log.info("Utente salvato!");
	}
}
