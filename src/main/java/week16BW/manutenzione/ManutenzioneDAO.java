package week16BW.manutenzione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManutenzioneDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(ManutenzioneDAO.class);

	public ManutenzioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Manutenzione m) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(m);
		t.commit();
		log.info("Manutenzione salvata!");
	}
}