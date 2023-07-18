package week16BW.tratta;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrattaDao {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(TrattaDao.class);

	public TrattaDao(EntityManager em) {

		this.em = em;
	}

	public void saveTratta(Tratta tratta) {
		try {
			EntityTransaction t = em.getTransaction();
			t.begin();

			em.persist(tratta);

			t.commit();

			log.info("Tratta inserita con successo");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento della traccia");
		}
	}

}
