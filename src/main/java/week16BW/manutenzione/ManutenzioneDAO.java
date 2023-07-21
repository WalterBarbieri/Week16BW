package week16BW.manutenzione;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import week16BW.mezzi.Mezzi;

public class ManutenzioneDAO {
	private final EntityManager em;
	private static Logger log = LoggerFactory.getLogger(ManutenzioneDAO.class);

	public ManutenzioneDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Manutenzione m) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(m);
		t.commit();
		log.info("Manutenzione salvata!");
	}

	public void selectAllNumeroManutenzioni() {

		try {
			TypedQuery<Manutenzione> getAllQuery = em.createNamedQuery("selectAllManutenzioni", Manutenzione.class);
			List<Manutenzione> manutenzioni = getAllQuery.getResultList();
			log.info("Numero totale Manutenzioni = " + manutenzioni.size() + " Elenco completo manutenzioni per mezzo");
			for (Manutenzione manutenzione : manutenzioni) {
				log.info("Manutenzione numero = " + manutenzione.getCodice_manutenzione() + ", relativa al mezzo = "
						+ manutenzione.getMezzo().getCodice_mezzo() + ", durata: " + manutenzione.getDurata_in_giorni()
						+ " giorni");
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Errore durante la ricerca");
		}

	}

	public void selectManutenzioniByMezzo(long codice_mezzo) {
		TypedQuery<Mezzi> getAllQuery = em.createNamedQuery("selectManutenzioniByMezzo", Mezzi.class);
		getAllQuery.setParameter("codice_mezzo", codice_mezzo);
		Mezzi mezzo = getAllQuery.getSingleResult();
		log.info("Mezzo selezionato numero = " + mezzo.getCodice_mezzo() + ", Numero Manutenzioni = "
				+ mezzo.getN_manutenzioni());
	}

	public void selectManutenzioniByTratta(long codice_tratta) {
		TypedQuery<Mezzi> getallQuery = em.createNamedQuery("selectManutenzioniByTratta", Mezzi.class);
		getallQuery.setParameter("codice_tratta", codice_tratta);
		List<Mezzi> mezzi = getallQuery.getResultList();
		for (Mezzi mezzo : mezzi) {
			log.info("Tratta selezionata numero = " + mezzo.getTratta().getCodice_tratta()
					+ ", Numero manutenzioni sulla tratta = " + mezzo.getN_manutenzioni());
		}
	}
}