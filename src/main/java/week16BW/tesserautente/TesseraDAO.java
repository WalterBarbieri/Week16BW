package week16BW.tesserautente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public Utente findByCodiceTessera(long codice_tessera) {
		Utente trova = em.find(Utente.class, codice_tessera);
		if (trova != null) {
			return trova;
		} else {
			log.info("Tessera non trovata");
		}
		return trova;
	}

	public Tessera rinnovoTessera(long codice_tessera) {
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
			log.info("Tessera non trovata");
		}
		t.commit();
		return trova;
	}

	public void rinnovoTutteTessereScadute() {
		try {
			TypedQuery<Tessera> getAllQuery = em.createNamedQuery("selectAllTessere", Tessera.class);
		List<Tessera> tessere = getAllQuery.getResultList();
		EntityTransaction t = em.getTransaction();
		t.begin();
		log.info("Elenco completo delle tessere");
		for (Tessera tessera : tessere) {
			if (tessera.getScadenza_tessera().isBefore(LocalDate.now())) {
				tessera.setEmissione_tessera(LocalDate.now());
				tessera.setScadenza_tessera(LocalDate.now().plusDays(365));
				em.persist(tessera);
				log.info("\"La tessera numero: " + tessera.getCodice_tessera() + " dell'utente "
						+ tessera.getUtente().getNome() + " " + tessera.getUtente().getCognome()
						+ " è stata rinnovata fino a = "
						+ tessera.getScadenza_tessera());
			} else {
				log.info("La tessera numero " + tessera.getCodice_tessera() + " dell'utente "
						+ tessera.getUtente().getNome() + " " + tessera.getUtente().getCognome() + " è ancora valida");
			}	
			continue;
		}
		t.commit();
	} catch (Exception e) {
		e.printStackTrace();
		log.info("Errore durante la ricerca dell'elenco tessere");
	}
}

}
