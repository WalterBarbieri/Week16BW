package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class AbbonamentoDAO {
	private final EntityManager em;

	public AbbonamentoDAO(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	// Salva elemento nel DataBase
	public void save(Abbonamento a) {
		EntityTransaction t = em.getTransaction();
		t.begin();

		em.persist(a);

		t.commit();
		System.out.println("Abbonamento registrato correttamente\n");
	}

	// Attivazione Abbonamento
	public void attivazioneAbbonamento(long id) {
		EntityTransaction t = em.getTransaction();
		t.begin();
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
		EntityTransaction t = em.getTransaction();
		t.begin();
		LocalDate dataAttivazione = LocalDate.now();
		Query q2 = em
				.createQuery(
						"UPDATE Abbonamento a SET data_obliterazione = :dataAttivazione WHERE codice_univoco = :id ");
		q2.setParameter("id", id);
		q2.setParameter("dataAttivazione", dataAttivazione);
		int numeroModificati = q2.executeUpdate();
		t.commit();
		if (numeroModificati > 0) {
			System.out.println("Data abbonamento attivato registrata");
		} else {
			System.out.println("Abbonamento non trovato");
		}

	}
}
