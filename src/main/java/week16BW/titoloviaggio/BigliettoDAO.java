package week16BW.titoloviaggio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import week16BW.emettitori.Emettitore;
import week16BW.emettitori.EmettitoreDAO;
import week16BW.utils.JpaUtil;

public class BigliettoDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(BigliettoDAO.class);

	public BigliettoDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	EntityManager em1 = emf.createEntityManager();
	EmettitoreDAO ed = new EmettitoreDAO(em1);

	// ----------Salva elemento nel DataBase -------------------
	public void save(Biglietto b) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(b);

		t.commit();
		System.out.println("Biglietto registrato correttamente\n");
	}

	public void save(int number) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		try {
			for (int i = 0; i < number; i++) {
				Emettitore emettitore = ed.rndEmettitore();
				Biglietto biglietto = new Biglietto();
				biglietto.setActive(true);
				biglietto.setEmettitore(emettitore);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				long meseEmissioneLong = Math.round(Math.random() * 6 + 1);
				String meseEmissione;
				if (meseEmissioneLong < 10) {
					meseEmissione = "0" + Long.toString(meseEmissioneLong);
				} else
					meseEmissione = Long.toString(meseEmissioneLong);
				long giornoEmissioneLong = Math.round(Math.random() * 20 + 1);
				String giornoEmissione;
				if (giornoEmissioneLong < 10) {
					giornoEmissione = "0" + Long.toString(giornoEmissioneLong);
				} else
					giornoEmissione = Long.toString(giornoEmissioneLong);
				String emissioneStringa = "2023" + "-" + meseEmissione + "-" + giornoEmissione;
				LocalDate emissione = LocalDate.parse(emissioneStringa, formatter);
				biglietto.setData_emissione(emissione);

				em.persist(biglietto);
				log.info("Biglietto emesso correttamente");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore nell'emissione del biglietto");
		}
		t.commit();
	}

	public Biglietto findByCodiceUnivoco(long codice_univoco) {
		Biglietto trova = em.find(Biglietto.class, codice_univoco);
		if (trova != null) {
			return trova;
		} else {
			log.info("Biglietto non trovata");
		}
		return trova;
	}

	public Long findBigliettiByEmettitore(long codice_emettitore) {
		try {
			TypedQuery<Long> query = em.createQuery(
					"SELECT COUNT(c) FROM Biglietto c WHERE emettitore_id = :codiceemettitore", Long.class);
			query.setParameter("codiceemettitore", codice_emettitore);
			return query.getSingleResult();
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

	// ------------ Vidimazione biglietti --------------------

	public void vidimazioneBiglietto(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("UPDATE Biglietto b SET active = false WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		int numeroModificati = q.executeUpdate();

		t.commit();
		if (numeroModificati > 0) {
			log.info("Biglietto vidimato");
		} else {
			log.info("Biglietto non trovato");
		}
	}

	// ------------ Vidimazione biglietti1 --------------------

	public void vidimazioneBiglietto1(long id, long codice_mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		dataVidimazioneBiglietto1(id);
		aggiuntaMezzoInObliterazione1(id, codice_mezzo);
		Query q = em.createQuery("UPDATE Biglietto b SET active = false WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		int numeroModificati = q.executeUpdate();

		t.commit();
		if (numeroModificati > 0) {
			log.info("Biglietto vidimato");
		} else {
			log.info("Biglietto non trovato");
		}
	}

	// ------------ Data vidimazione biglietti --------------------

	public void dataVidimazioneBiglietto(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		LocalDate dataVidimazione = LocalDate.now();
		Query q = em.createQuery(
				"UPDATE Biglietto b SET data_obliterazione = :dataVidimazione WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		q.setParameter("dataVidimazione", dataVidimazione);
		int numeroModificati = q.executeUpdate();

		t.commit();
		if (numeroModificati > 0) {
			log.info("Data vidimazione del biglietto registrata");
		} else {
			log.info("Biglietto non trovato");
		}
	}

	// ------------ Data vidimazione biglietti 1--------------------

	public void dataVidimazioneBiglietto1(long id) {
		LocalDate dataVidimazione = LocalDate.now();
		Query q = em.createQuery(
				"UPDATE Biglietto b SET data_obliterazione = :dataVidimazione WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		q.setParameter("dataVidimazione", dataVidimazione);
		int numeroModificati = q.executeUpdate();

		if (numeroModificati > 0) {
			log.info("Data vidimazione del biglietto registrata");
		} else {
			log.info("Biglietto non trovato");
		}
	}

	// ------------ Biglietti emessi da un dato emettitore --------------------

	public List<Biglietto> trovaBigliettiPerEmettitore(long id) {
		TypedQuery<Biglietto> getAllQuery = em.createQuery("SELECT b FROM Biglietto b WHERE emettitore_id = :id",
				Biglietto.class);
		getAllQuery.setParameter("id", id);
		return getAllQuery.getResultList();
	}

	// ------------ Biglietti vidimati in un arco temporale su un Mezzo
	// --------------------

	public List<Biglietto> trovaBigliettiVimidatiPerMezzoInArcoTemporale(LocalDate inizio, LocalDate fine, long id) {
		TypedQuery<Biglietto> getAllQuery = em.createQuery(
				"SELECT b FROM Biglietto b WHERE data_obliterazione BETWEEN :inizio AND :fine AND mezzo_id = :id",
				Biglietto.class);
		getAllQuery.setParameter("inizio", inizio);
		getAllQuery.setParameter("fine", fine);
		getAllQuery.setParameter("id", id);
		return getAllQuery.getResultList();
	}

	// ------------ Biglietti vidimati in un arco temporale --------------------

	public List<Biglietto> trovaBigliettiVimidatiInArcoTemporale(LocalDate inizio, LocalDate fine) {
		TypedQuery<Biglietto> getAllQuery = em.createQuery(
				"SELECT b FROM Biglietto b WHERE data_obliterazione BETWEEN :inizio AND :fine", Biglietto.class);
		getAllQuery.setParameter("inizio", inizio);
		getAllQuery.setParameter("fine", fine);
		return getAllQuery.getResultList();
	}

	// ------------ Numero biglietti vidimati in un arco temporale su un Mezzo
	// ------------------

	public Long numeroBigliettiVimidatiPerMezzoInArcoTemporale(LocalDate inizio, LocalDate fine, long id) {
		TypedQuery<Long> getAllQuery = em.createQuery(
				"SELECT COUNT(b) FROM Biglietto b WHERE data_obliterazione BETWEEN :inizio AND :fine AND mezzo_id = :id",
				Long.class);
		getAllQuery.setParameter("inizio", inizio);
		getAllQuery.setParameter("fine", fine);
		getAllQuery.setParameter("id", id);
		return getAllQuery.getSingleResult();
	}

	// ------------ Numero biglietti vidimati in un arco temporale
	// ------------------

	public Long numeroBigliettiVimidatiInArcoTemporale(LocalDate inizio, LocalDate fine) {
		TypedQuery<Long> getAllQuery = em.createQuery(
				"SELECT COUNT(b) FROM Biglietto b WHERE data_obliterazione BETWEEN :inizio AND :fine", Long.class);
		getAllQuery.setParameter("inizio", inizio);
		getAllQuery.setParameter("fine", fine);
		return getAllQuery.getSingleResult();
	}

	// aggiunta mezzo in obliterazione
	public void aggiuntaMezzoInObliterazione(long id, long codice_mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Query q = em.createQuery("UPDATE Biglietto b SET mezzo_id = :codice_mezzo WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		q.setParameter("codice_mezzo", codice_mezzo);
		int numeroModificati = q.executeUpdate();

		t.commit();
		if (numeroModificati > 0) {
			log.info("Mezzo salvato in vidimazione");
		} else {
			log.info("Biglietto o mezzo non trovato");
		}
	}

	// Aggiunta mezzo 2
	public void aggiuntaMezzoInObliterazione1(long id, long codice_mezzo) {
		Query q = em.createQuery("UPDATE Biglietto b SET mezzo_id = :codice_mezzo WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		q.setParameter("codice_mezzo", codice_mezzo);
		int numeroModificati = q.executeUpdate();
		if (numeroModificati > 0) {
			log.info("Mezzo salvato in vidimazione");
		} else {
			log.info("Biglietto o mezzo non trovato");
		}
	}
}
