package week16BW.tesserautente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.javafaker.Faker;

public class UtenteDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(UtenteDAO.class);

	Faker faker = new Faker();

	public UtenteDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Utente e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
		log.info("Utente salvato!");
	}

	public Utente findById(long codice_id) {
		Utente trova = em.find(Utente.class, codice_id);
		if (trova != null) {
			return trova;
		} else {
			log.info("Utente non trovato");
		}
		return trova;
	}

	public Utente creaUtente(int i) {
		String[] nome = faker.harryPotter().character().split(" ");
		int indiceCognome = nome.length - 1;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String annoNascita = Long.toString(Math.round(1960 + Math.random() * 60));
		long meseNascitaLong = Math.round(Math.random() * 11 + 1);
		String meseNascita;
		if (meseNascitaLong < 10) {
			meseNascita = "0" + Long.toString(meseNascitaLong);
		} else
			meseNascita = Long.toString(meseNascitaLong);
		long giornoNascitaLong = Math.round(Math.random() * 27 + 1);
		String giornoNascita;
		if (giornoNascitaLong < 10) {
			giornoNascita = "0" + Long.toString(giornoNascitaLong);
		} else
			giornoNascita = Long.toString(giornoNascitaLong);
		String dataNascitaStringa = annoNascita + "-" + meseNascita + "-" + giornoNascita;
		LocalDate dataNascita = LocalDate.parse(dataNascitaStringa, formatter);
		return new Utente(nome[0], nome[indiceCognome], dataNascita);
		

	}
}
