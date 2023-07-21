package week16BW.tratta;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class TrattaDao {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(TrattaDao.class);

	public TrattaDao(EntityManager em) {

		this.em = em;
	}

	public void saveTratta(Tratta tratta) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		try {

			em.persist(tratta);

			log.info("Tratta inserita con successo");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento della traccia");
		}
		t.commit();
	}

	public void saveTratta(int number) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Faker faker = new Faker();
		try {
			for (int i = 0; i < number; i++) {
				Tratta tratta = new Tratta();
				tratta.setPartenza(faker.address().streetName());
				tratta.setCapolinea(faker.address().streetName());
				tratta.setT_medio(faker.number().randomDouble(2, 10, 50));
				em.persist(tratta);
				log.info("Tratta inserita con successo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento della traccia");
		}
		t.commit();
	}

	public Tratta findByCodiceTratta(long codice_tratta) {
		try {
			Tratta trova = em.find(Tratta.class, codice_tratta);
			return trova;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Tratta non trovata");
			return null;
		}

	}

	public List<Tratta> findByPartenza(String partenza) {
		try {
			TypedQuery<Tratta> query = em.createQuery("SELECT a FROM Tratta a WHERE partenza = :partenza",
					Tratta.class);
			query.setParameter("partenza", partenza);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Tratta non trovata");
			return null;
		}

	}

	public List<Tratta> findByCapolinea(String capolinea) {
		try {
			TypedQuery<Tratta> query = em.createQuery("SELECT a FROM Tratta a WHERE capolinea = :capolinea",
					Tratta.class);
			query.setParameter("capolinea", capolinea);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Tratta non trovata");
			return null;
		}

	}

	public Tratta rndTratta() {
		Random rnd = new Random();
		try {
			TypedQuery<Tratta> getAllQuery = em.createQuery("SELECT a FROM Tratta a", Tratta.class);
			List<Tratta> tratte = getAllQuery.getResultList();
			Tratta rndTratta = tratte.get(Math.abs(rnd.nextInt(tratte.size())));
			return rndTratta;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore nella ricerca dell'emettitore");
			return null;
		}
	}

}
