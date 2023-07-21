package week16BW.tratta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public Tratta findByCodiceTratta(long codice_tratta) {
		Tratta trova = em.find(Tratta.class, codice_tratta);
		if (trova != null) {
			return trova;
		} else {
			log.info("Tratta non trovata");
		}
		return trova;
	}

	public List<Tratta> findByPartenza(String partenza) {
		TypedQuery<Tratta> query = em.createQuery("SELECT a FROM Tratta a WHERE partenza = :partenza", Tratta.class);
		query.setParameter("partenza", partenza);
		return query.getResultList();
	}

	public List<Tratta> findByCapolinea(String capolinea) {
		TypedQuery<Tratta> query = em.createQuery("SELECT a FROM Tratta a WHERE capolinea = :capolinea", Tratta.class);
		query.setParameter("capolinea", capolinea);
		return query.getResultList();

	}

}
