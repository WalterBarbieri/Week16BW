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

//**************METODO PER SALVARE MEZZI - POLIMORFISMO***********************
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

	// **************METODO PER RICERCARE MEZZO TRAMITE CODICE
	// MEZZO***********************
	public Mezzi getMezzoByCodice(long codice_mezzo) {
		try {
			TypedQuery<Mezzi> getQuery = em.createNamedQuery("selectByCodMezzo", Mezzi.class);
			getQuery.setParameter("codice_mezzo", codice_mezzo);
			Mezzi mezzoByCod = getQuery.getSingleResult();
			return mezzoByCod;
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Nessun mezzo trovato");
		}
		return null;

	}

	// **************METODO PER CREARE E SALVARE N STORICO TRATTA RANDOM TRAMITE
	// CODICE MEZZO***********************
	public void mezzoCorsa(long codice_mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Random rnd = new Random();
		Mezzi mezzo = getMezzoByCodice(codice_mezzo);
		try {
			StoricoTratte storicoTratta = new StoricoTratte();

			Double tMedio = mezzo.getTratta().getT_medio();
			Double intervallo = ((rnd.nextDouble() * 10) - 5);
			Double intervalloApp = Math.round(intervallo * 100.0) / 100.0;
			Double tEffettivo = tMedio + intervalloApp;
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

	// **************METODO PER CREARE E SALVARE UNO STORICO TRATTA TRAMITE TEMPO
	// EFFETTIVO
	// E CODICE MEZZO***********************

	public void mezzoCorsa(Double t_effettivo, long codice_mezzo) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Mezzi mezzo = getMezzoByCodice(codice_mezzo);
		try {
			StoricoTratte storicoTratta = new StoricoTratte();

			storicoTratta.setT_effettivo(t_effettivo);

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

	// **************METODO PER RICERCARE NUMERO TRATTE ***********************
	// **************ALL ***********************
	public void selectAllNumeroTratte() {

		try {
			TypedQuery<Mezzi> getAllQuery = em.createNamedQuery("selectAllNumeroTratte", Mezzi.class);
			List<Mezzi> mezzi = getAllQuery.getResultList();
			log.info("Elenco completo numero tratte per mezzo");
			for (Mezzi mezzo : mezzi) {
				log.info("Codice Mezzo = " + mezzo.getCodice_mezzo() + ", Codice Tratta = "
						+ mezzo.getTratta().getCodice_tratta() + ", Numero Tratte Percorse = " + mezzo.getN_tratte());
			}
		} catch (Exception e) {
			log.info("Errore durante la ricerca");
		}

	}

	// **************BY CODICE MEZZO ***********************
	public void selectNumeroTratteByCodiceMezzo(long codice_mezzo) {
		try {
			TypedQuery<Mezzi> getQuery = em.createNamedQuery("selectByCodMezzo", Mezzi.class);
			getQuery.setParameter("codice_mezzo", codice_mezzo);
			Mezzi mezzo = getQuery.getSingleResult();
			log.info("Codice Mezzo = " + mezzo.getCodice_mezzo() + ", Codice Tratta = "
					+ mezzo.getTratta().getCodice_tratta() + ", Numero Tratte Percorse = " + mezzo.getN_tratte());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante la ricerca");
		}

	}

	// **************BY CODICE TRATTA ***********************
	public void selectNumeroTrattebyTratta(long codice_tratta) {
		try {
			TypedQuery<Mezzi> getQuery = em.createNamedQuery("selectByCodTratta", Mezzi.class);
			getQuery.setParameter("codice_tratta", codice_tratta);
			Mezzi mezzo = getQuery.getSingleResult();
			log.info("Codice Mezzo = " + mezzo.getCodice_mezzo() + ", Codice Tratta = "
					+ mezzo.getTratta().getCodice_tratta() + ", Numero Tratte Percorse = " + mezzo.getN_tratte());
		} catch (Exception e) {
			log.info("Errore durante la ricerca");
		}

	}

	// **************METODO PER RICERCARE TEMPO PERCORRENZA
	// EFFETTIVO***********************

	public void selectAllTempoEffettivo() {
		try {
			TypedQuery<StoricoTratte> getAllQuery = em.createNamedQuery("selectAll", StoricoTratte.class);
			List<StoricoTratte> storicoEffettivi = getAllQuery.getResultList();
			log.info("Elenco completo tempi effettivi");
			for (StoricoTratte effettivo : storicoEffettivi) {
				log.info("Codice Storico Tratta = " + effettivo.getCodice_storico_tratte()
						+ ", Tempo Percorrenza Effettivo = " + effettivo.getT_effettivo() + ", Codice Tratta = "
						+ effettivo.getMezzo().getTratta().getCodice_tratta() + ", Codice Mezzo: "
						+ effettivo.getMezzo().getCodice_mezzo());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// **************BY CODICE MEZZO***********************
	public void selectTempoEffettivoCodiceMezzo(long codice_mezzo) {
		Mezzi mezzo = getMezzoByCodice(codice_mezzo);
		try {
			List<StoricoTratte> storicoMezzo = mezzo.getStorico_tratte();
			storicoMezzo.forEach(el -> log.info("Codice Mezzo = " + el.getMezzo().getCodice_mezzo()
					+ ", Codice Tratta = " + el.getMezzo().getTratta().getCodice_tratta()
					+ ", Tempo Percorrenza Effettivo = " + el.getT_effettivo()));
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante la ricerca");
		}
	}

	// **************BY CODICE TRATTA***********************
	public void selectTempoEffettivoCodiceTratta(long codice_tratta) {

		try {
			TypedQuery<Mezzi> getQuery = em.createNamedQuery("selectByCodTratta", Mezzi.class);
			getQuery.setParameter("codice_tratta", codice_tratta);
			Mezzi mezzo = getQuery.getSingleResult();
			List<StoricoTratte> storicoTratte = mezzo.getStorico_tratte();
			storicoTratte.forEach(el -> log.info("Codice Mezzo = " + el.getMezzo().getCodice_mezzo()
					+ ", Codice Tratta = " + el.getMezzo().getTratta().getCodice_tratta()
					+ ", Tempo Percorrenza Effettivo = " + el.getT_effettivo()));
		} catch (Exception e) {
			log.info("Errore durante la ricerca");
		}
	}
}
