package week16BW.mezzi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import week16BW.tratta.StoricoTratte;

public class MezziDao {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(MezziDao.class);

	public MezziDao(EntityManager em) {
		this.em = em;
	}

	public void saveMezzo(Autobus bus) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		try {

			em.persist(bus);

			log.info("Autobus inserito con successo");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento dell'autobus");
		}
		t.commit();

	}

	public void saveMezzo(Tram tram) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		try {

			em.persist(tram);

			log.info("Tram inserito con successo");
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento del tram");
		}
		t.commit();

	}

	public Mezzi getMezzoByCodice(long codice_mezzo) {
		try {
			TypedQuery<Mezzi> getQuery = em.createQuery("SELECT a FROM Mezzi a WHERE codice_mezzo = :codice_mezzo",
					Mezzi.class);
			getQuery.setParameter("codice_mezzo", codice_mezzo);
			Mezzi mezzoByCod = getQuery.getSingleResult();
			log.info("Mezzo numero " + codice_mezzo + " trovato");
			log.info(mezzoByCod.toString());
			return mezzoByCod;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Nessun mezzo trovato");
		}
		return null;

	}

	public void mezzoCorsa(Mezzi mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Random rnd = new Random();
		try {
			StoricoTratte storicoTratta = new StoricoTratte();

			Double tMedio = mezzo.getTratta().getT_medio();
			Double intervallo = (rnd.nextDouble() * 10) - 5;
			Double tEffettivo = tMedio + intervallo;
			storicoTratta.setT_effettivo(tEffettivo);

			storicoTratta.setMezzo(mezzo);

			em.persist(storicoTratta);

			if (mezzo.getStorico_tratte() == null) {
				mezzo.setStorico_tratte(new ArrayList<>());
			}
			mezzo.getStorico_tratte().add(storicoTratta);
			mezzo.setN_tratte(mezzo.getN_tratte() + 1);
			em.merge(mezzo);

			log.info("Storico Tratta relativo al mezzo " + mezzo.getCodice_mezzo() + " inserito con successo");

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante l'inserimento dello Storico Tratta");
		}

		t.commit();
	}

	public void printStoricoCorse(Mezzi mezzo) {
		try {
			List<StoricoTratte> storicoMezzo = mezzo.getStorico_tratte();
			storicoMezzo.forEach(el -> log.info(el.toString()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
