package week16BW.emettitori;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

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

	public Emettitore findByCodiceEmettitore(long codice_emettitore) {
		Emettitore trova = em.find(Emettitore.class, codice_emettitore);
		if (trova != null) {
			return trova;
		} else {
			log.info("Emettitore non trovato");
		}
		return trova;
	}

	public Emettitore rndEmettitore() {
		Random rnd = new Random();
		try {
			TypedQuery<Emettitore> getAllQuery = em.createQuery("SELECT a FROM Emettitore a", Emettitore.class);
			List<Emettitore> emettitori = getAllQuery.getResultList();
			Emettitore rndEmettitore = emettitori.get(Math.abs(rnd.nextInt(emettitori.size())));
			return rndEmettitore;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore nella ricerca dell'emettitore");
			return null;
		}

	}

//	public List<Emettitore> findBigliettiByEmettByTempo(long codice_emettitore, ) {
//		TypedQuery<Emettitore> query = em.createQuery("SELECT a FROM Emettitore a WHERE YEAR(a.data_emissione) = :mese",
//				Emettitore.class);
//		query.setParameter("anno", annopubbl);
//		return query.getResultList();
//	}

}
