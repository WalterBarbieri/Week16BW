package week16BW.titoloviaggio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import week16BW.emettitori.Emettitore;
import week16BW.emettitori.EmettitoreDAO;
import week16BW.enu.Tipoabbonamento;
import week16BW.tesserautente.Tessera;
import week16BW.tesserautente.TesseraDAO;
import week16BW.utils.JpaUtil;

public class AbbonamentoDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(AbbonamentoDAO.class);

	public AbbonamentoDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	EntityManager em1 = emf.createEntityManager();
	EmettitoreDAO ed = new EmettitoreDAO(em1);
	TesseraDAO td = new TesseraDAO(em1);

	// Salva elemento nel DataBase
	public void save(Abbonamento a) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(a);

		t.commit();
		System.out.println("Abbonamento registrato correttamente\n");
	}

	public void save(int number) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Emettitore emettitore = ed.rndEmettitore();
		Tessera tessera = td.rndTessera();
		Random rnd = new Random();
		try {
			for (int i = 0; i < number; i++) {
				Abbonamento abbonamento = new Abbonamento();
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
				abbonamento.setData_emissione(emissione);
				abbonamento.setTessera(tessera);
				abbonamento.setEmettitore(emettitore);
				int randomN = rnd.nextInt(100) + 1;
				if (randomN % 2 == 0) {
					abbonamento.setTipo(Tipoabbonamento.MENSILE);
				} else {
					abbonamento.setTipo(Tipoabbonamento.SETTIMANALE);
				}
				em.persist(abbonamento);
				log.info("Abbonamento emesso con successo");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore nell'emissione dell'abbonamento");
		}
		t.commit();
	}

	public Abbonamento findByCodiceUnivoco(long codice_univoco) {
		Abbonamento trova = em.find(Abbonamento.class, codice_univoco);
		if (trova != null) {
			return trova;
		} else {
			log.info("Abbonamento non trovato");
		}
		return trova;
	}

	// Attivazione Abbonamento
	public void attivazioneAbbonamento(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		dataAttivazioneAbbonamento(id);
		Query q = em.createQuery("UPDATE Abbonamento a SET active = true WHERE codice_univoco = :id ");
		q.setParameter("id", id);
		int numeroModificati = q.executeUpdate();
		t.commit();
		if (numeroModificati > 0) {
			System.out.println("Abbonamento attivato");
		} else {
			System.out.println("Abbonamento non trovato");
		}
	}

	// Definiione data attivazione abbonamento Abbonamento
	public void dataAttivazioneAbbonamento(long id) {
		LocalDate dataAttivazione = LocalDate.now();
		Query q2 = em.createQuery(
				"UPDATE Abbonamento a SET data_obliterazione = :dataAttivazione WHERE codice_univoco = :id ");
		q2.setParameter("id", id);
		q2.setParameter("dataAttivazione", dataAttivazione);
		int numeroModificati = q2.executeUpdate();
		if (numeroModificati > 0) {
			System.out.println("Data abbonamento attivato registrata");
		} else {
			System.out.println("Abbonamento non trovato");
		}

	}

	// Definiione data attivazione abbonamento Abbonamento
	public void dataScadenzaAbbonamento(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		TypedQuery<Abbonamento> query = em.createQuery("SELECT a FROM Abbonamento a WHERE codice_univoco = :numero",
				Abbonamento.class);
		query.setParameter("numero", id);
		Abbonamento trovato = query.getSingleResult();
		LocalDate dataScadenza;
		if (trovato.getTipo().equals(Tipoabbonamento.SETTIMANALE)) {
			dataScadenza = LocalDate.now().plusDays(7);
		} else {
			dataScadenza = LocalDate.now().plusMonths(1);
		}
		Query q2 = em.createQuery("UPDATE Abbonamento a SET data_scadenza = :dataScadenza WHERE codice_univoco = :id ");
		q2.setParameter("id", id);
		q2.setParameter("dataScadenza", dataScadenza);
		int numeroModificati = q2.executeUpdate();
		if (numeroModificati > 0) {
			System.out.println("Data abbonamento attivato registrata");
		} else {
			System.out.println("Abbonamento non trovato");
		}
		t.commit();
	}

	public void controlloAbbonamento(long abbonamenti_tessera) {
		try {
			TypedQuery<Abbonamento> query = em
					.createQuery("SELECT a FROM Abbonamento a WHERE abbonamenti_tessera = :numero", Abbonamento.class);
			query.setParameter("numero", abbonamenti_tessera);
			Abbonamento attivo = query.getSingleResult();
			if (attivo.isActive()) {
				if (attivo.getData_scadenza().isBefore(LocalDate.now())) {
					log.info("L'abbonamento della tessera " + attivo.getTessera().getCodice_tessera() + " dell'utente "
							+ attivo.getTessera().getUtente().getNome() + " "
							+ attivo.getTessera().getUtente().getCognome() + " non è attivo o è scaduto");
					log.info("Ti becchi la multa! 100 euro volano via dal portafoglio!");
				} else {
					log.info("L'abbonamento della tessera " + attivo.getTessera().getCodice_tessera() + " dell'utente "
							+ attivo.getTessera().getUtente().getNome() + " "
							+ attivo.getTessera().getUtente().getCognome() + " è valido valida");
					log.info("Sei salvo! Sei stato fortunato!");
				}
			} else {
				log.info("L'abbonamento non è stato attivato");
				log.info("Ti becchi la multa! 100 euro volano via dal portafoglio!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante la ricerca dell'abbonamento");
		}

	}

}
