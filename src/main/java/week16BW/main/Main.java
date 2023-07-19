package week16BW.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import week16BW.emettitori.Distributore;
import week16BW.emettitori.Emettitore;
import week16BW.emettitori.EmettitoreDAO;
import week16BW.enu.Tipoabbonamento;
import week16BW.mezzi.Autobus;
import week16BW.mezzi.MezziDao;
import week16BW.mezzi.Stato;
import week16BW.mezzi.Tram;
import week16BW.tesserautente.Tessera;
import week16BW.tesserautente.TesseraDAO;
import week16BW.tesserautente.Utente;
import week16BW.tesserautente.UtenteDAO;
import week16BW.titoloviaggio.Abbonamento;
import week16BW.titoloviaggio.AbbonamentoDAO;
import week16BW.titoloviaggio.Biglietto;
import week16BW.titoloviaggio.BigliettoDAO;
import week16BW.tratta.Tratta;
import week16BW.tratta.TrattaDao;
import week16BW.utils.JpaUtil;

public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UtenteDAO ud = new UtenteDAO(em);
		TesseraDAO td = new TesseraDAO(em);
		EmettitoreDAO ed = new EmettitoreDAO(em);
		BigliettoDAO bd = new BigliettoDAO(em);
		AbbonamentoDAO ad = new AbbonamentoDAO(em);

		Utente ut1 = new Utente("B", "G", LocalDate.of(1993, 05, 28));
		Utente ut2 = new Utente("C", "A", LocalDate.of(1988, 07, 06));
		ud.save(ut1);
		ud.save(ut2);
		MezziDao md = new MezziDao(em);
		TrattaDao trd = new TrattaDao(em);

		Emettitore emettitore1 = new Emettitore();

		Distributore emettitore2 = new Distributore(true);
		ed.save(emettitore1);
		ed.save(emettitore2);

		Tessera tess1 = new Tessera(LocalDate.of(2021, 04, 02), ut1, emettitore1);
		Tessera tess2 = new Tessera(LocalDate.of(2023, 07, 14), ut2, emettitore2);
		td.save(tess1);
		td.save(tess2);

		// Creazione istanze per biglietto
		Biglietto biglietto1 = new Biglietto(LocalDate.of(2023, 4, 17));
		Biglietto biglietto2 = new Biglietto(LocalDate.of(2023, 4, 19));
		// Salvataggio biglietti a DB
		bd.save(biglietto1);
		bd.save(biglietto2);

		// Creazione istanze per abbonamento
		Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2023, 2, 14), Tipoabbonamento.MENSILE);
		Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2023, 4, 27), Tipoabbonamento.SETTIMANALE);
		// Salvataggio abbonamenti a DB
		ad.save(abbonamento1);
		ad.save(abbonamento2);

		Tratta route1 = new Tratta("Punto A", "Punto B", 20.0);
		Tratta route2 = new Tratta("Punto C", "Punto D", 27.0);

		trd.saveTratta(route1);
		trd.saveTratta(route2);

		Autobus bus1 = new Autobus(Stato.ATTIVO);
		Tram tram1 = new Tram(Stato.MANUTENZIONE);

		bus1.setTratta(route1);
		tram1.setTratta(route2);

		md.saveMezzo(bus1);
		md.saveMezzo(tram1);

//		Metodo per la vidimazione del singolo biglietto
		bd.vidimazioneBiglietto(2);
//		Metodo per la registrazioine della vidimazione del singolo biglietto		
		bd.dataVidimazioneBiglietto(2);

		// Metodo per l'attivazione di un abbonamento
		ad.attivazioneAbbonamento(12);
		// Metodo per la registrazioine della data di attivazione di un abbonamento
		ad.dataAttivazioneAbbonamento(12);

//		Mezzi autobus1 = md.getMezzoByCodice(3);
//		for (int i = 0; i < 15; i++) {
//			md.mezzoCorsa(autobus1);
//		}
//		md.printStoricoCorse(bus1);

		// Tenere traccia del numero di biglietti vidimati in totale in un arco
		// temporale per mezzo
		System.out.println(
				"\nTenere traccia dei biglietti vidimati in totale in un arco temporale per mezzo \n");
		bd.trovaBigliettiVimidatiPerMezzoInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3), 7)
				.forEach(b -> System.out.println(b.toString()));

		// Tenere traccia dei biglietti vidimati in totale in un arco
		// temporale
		System.out.println("\nTenere traccia dei biglietti vidimati in totale in un arco temporale  \n");
		bd.trovaBigliettiVimidatiInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3))
				.forEach(b -> System.out.println(b.toString()));

		// Numero biglietti vidimati in un arco temporale su un Mezzo
		System.out.println("\nNumero di biglietti vidimati in totale in un arco temporale su un mezzo \n");
		long numeroBigliettiVidimatiSuMezzoInArcoTemporale = bd.numeroBigliettiVimidatiPerMezzoInArcoTemporale(
				LocalDate.now().minusDays(3),
				LocalDate.now().plusDays(3), 7);
		System.out.println(numeroBigliettiVidimatiSuMezzoInArcoTemporale);

		// // Numero biglietti vidimati in un arco temporale in totale
		System.out.println("\nNumero di biglietti vidimati in totale in un arco temporale\n");
		long numeroBigliettiVidimatiInArcoTemporale = bd
				.numeroBigliettiVimidatiInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3));
		System.out.println(numeroBigliettiVidimatiInArcoTemporale);
		
		// Biglietti stampati per emettitore
		System.out.println("\nBiglietti per emettitore\n");
		bd.trovaBigliettiPerEmettitore(4).forEach(b -> System.out.println(b.toString()));
		

		em.close();
		emf.close();
	}
}
