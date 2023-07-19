package week16BW.tesserautente;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TesseraDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(TesseraDAO.class);

	public TesseraDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Tessera e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		log.info("Tessera salvata!");
	}

	public Utente findByCodiceTessera(Long codice_tessera) {
		Utente trova = em.find(Utente.class, codice_tessera);
		if (trova != null) {
			return trova;
		} else {
			log.info("Tessera non trovata");
		}
		return trova;
	}

	public Tessera rinnovoTessera(int codice_tessera) {
		Tessera trova = em.find(Tessera.class, codice_tessera);
		EntityTransaction t = em.getTransaction();
		t.begin();
		if (trova != null) {
			if (trova.getScadenza_tessera().isBefore(LocalDate.now())) {
				trova.setEmissione_tessera(LocalDate.now());
				trova.setScadenza_tessera(LocalDate.now().plusDays(365));
				em.persist(trova);
				log.info("La tessera è stata rinnovata");
			} else {
				log.info("La tessera è ancora valida");
			}
		} else {
			System.out.println("Tessera non trovata");
		}
		t.commit();
		return trova;
	}
}
