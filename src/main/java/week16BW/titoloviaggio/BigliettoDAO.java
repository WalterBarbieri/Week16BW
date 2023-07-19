package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BigliettoDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);

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

	public Long findBigliettiByEmettitore(long codice_emettitore) {
		try {
			TypedQuery<Long> query = em
					.createQuery(
							"SELECT COUNT(c) FROM Biglietto c WHERE emettitore_id = :codiceemettitore",
							Long.class);
			query.setParameter("codiceemettitore", codice_emettitore);
			return  query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Nessun biglietto trovato");
		}
		return null;
	}

	public Long findBigliettiByTempo(LocalDate inizio, LocalDate fine) {
		try {
			TypedQuery<Long> query = em.createQuery(
					"SELECT COUNT(c) FROM Biglietto c WHERE data_emissione between :inizio and :fine ", Long.class);
			query.setParameter("inizio", inizio);
			query.setParameter("fine", fine);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Nessun biglietto trovato");
		}
		return null;
	}

	public Long findBigliettiByTempoAndEmettitore(long codice_emettitore, LocalDate inizio, LocalDate fine) {
		try {
			TypedQuery<Long> query = em.createQuery(
					"SELECT COUNT(c) FROM Biglietto c WHERE emettitore_id = :codiceemettitore and data_emissione between :inizio and :fine ",
					Long.class);
			query.setParameter("inizio", inizio);
			query.setParameter("fine", fine);
			query.setParameter("codiceemettitore", codice_emettitore);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Nessun biglietto trovato");
		}
		return null;
	}

}
