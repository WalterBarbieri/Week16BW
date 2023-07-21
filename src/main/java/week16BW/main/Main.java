package week16BW.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import week16BW.emettitori.EmettitoreDAO;
import week16BW.manutenzione.ManutenzioneDAO;
import week16BW.mezzi.MezziDao;
import week16BW.tesserautente.TesseraDAO;
import week16BW.tesserautente.UtenteDAO;
import week16BW.titoloviaggio.AbbonamentoDAO;
import week16BW.titoloviaggio.BigliettoDAO;
import week16BW.tratta.TrattaDao;
import week16BW.utils.JpaUtil;

public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	private static Logger log = LoggerFactory.getLogger(EmettitoreDAO.class);

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UtenteDAO ud = new UtenteDAO(em);
		TesseraDAO td = new TesseraDAO(em);
		EmettitoreDAO ed = new EmettitoreDAO(em);
		BigliettoDAO bd = new BigliettoDAO(em);
		AbbonamentoDAO ad = new AbbonamentoDAO(em);
		MezziDao md = new MezziDao(em);
		TrattaDao trd = new TrattaDao(em);
		ManutenzioneDAO ma = new ManutenzioneDAO(em);

		// CREAZIONE RANDOM ISTANZE Personaggi
		for (int i = 0; i < 100; i++) {
			ud.save(ud.creaUtente(i));
		}
		// CREAZIONE RANDOM ISTANZE EMETTITORE
		ed.save(15);

		// CREAZIONE RANDOM ISTANZE TESSERE
		td.save(5);

		// CREAZIONE RANDOM ISTANZE BIGLIETTO
		bd.save(60);

		// CREAZIONE RANDOM ISTANZE ABBONAMENTO
		ad.save(40);
		// Creazione utente, emettitore
//		Utente ut1 = new Utente("B", "G", LocalDate.of(1993, 05, 28));
//		Utente ut2 = new Utente("C", "H", LocalDate.of(1988, 07, 06));
//		Utente ut3 = new Utente("D", "I", LocalDate.of(2008, 10, 15));
//		Utente ut4 = new Utente("E", "L", LocalDate.of(1996, 03, 26));
//		Utente ut5 = new Utente("F", "M", LocalDate.of(1989, 04, 16));
//		Utente ut6 = new Utente("G", "N", LocalDate.of(2000, 8, 6));
//		Emettitore emettitore1 = new Emettitore();
//		Emettitore emettitore3 = new Emettitore();
//		Distributore emettitore2 = new Distributore(true);
//		Distributore emettitore4 = new Distributore(true);
//		ud.save(ut1);
//		ud.save(ut2);
//		ud.save(ut3);
//		ud.save(ut4);
//		ud.save(ut5);
//		ud.save(ut6);
//		ed.save(emettitore1);
//		ed.save(emettitore2);
//		ed.save(emettitore3);
//		ed.save(emettitore4);

//
////		// Crea tessera e biglietto
////		Tessera tess1 = new Tessera(LocalDate.of(2021, 4, 02), ut1, emettitore1);
////		Tessera tess2 = new Tessera(LocalDate.of(2023, 1, 1), ut2, emettitore2);
////		Tessera tess3 = new Tessera(LocalDate.of(2022, 5, 12), ut3, emettitore2);
////		Tessera tess4 = new Tessera(LocalDate.of(2019, 8, 24), ut4, emettitore3);
////		Tessera tess5 = new Tessera(LocalDate.of(2023, 5, 14), ut5, emettitore4);
////		Tessera tess6 = new Tessera(LocalDate.of(2017, 9, 16), ut6, emettitore3);
//		td.save(tess1);
//		td.save(tess2);
//		td.save(tess3);
//		td.save(tess4);
//		td.save(tess5);
//		td.save(tess6);
		// Creazione istanze per biglietto
//		Biglietto biglietto1 = new Biglietto(LocalDate.of(2023, 04, 17), emettitore1);
//		Biglietto biglietto2 = new Biglietto(LocalDate.of(2023, 04, 19), emettitore1);
//		Biglietto biglietto3 = new Biglietto(LocalDate.of(2022, 04, 20), emettitore1);
//		Biglietto biglietto4 = new Biglietto(LocalDate.of(2021, 05, 9), emettitore2);
//		// Salvataggio biglietti a DB
//		bd.save(biglietto1);
//		bd.save(biglietto2);
//		bd.save(biglietto3);
//		bd.save(biglietto4);

		// Creo Abbonamento
		// Creazione istanze per abbonamento
//		Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2023, 2, 14), Tipoabbonamento.MENSILE, tess1,
//				emettitore1);
//		Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2023, 4, 27), Tipoabbonamento.SETTIMANALE, tess2,
//				emettitore2);
//		Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2022, 4, 17), Tipoabbonamento.SETTIMANALE, tess3,
//				emettitore1);
//		// Salvataggio abbonamenti a DB
//		ad.save(abbonamento1);
//		ad.save(abbonamento2);
//		ad.save(abbonamento3);
		// CREAZIONE RANDOM ISTANZE TRATTA
		trd.saveTratta(10);
//		// CREAZIONE MANUALE ISTANZE TRATTA

//		Tratta route1 = new Tratta("Punto A", "Punto B", 20.0);
//		Tratta route2 = new Tratta("Punto C", "Punto D", 27.0);
//
//		trd.saveTratta(route1);
//		trd.saveTratta(route2);
//		// CREAZIONE RANDOM ISTANZE MEZZI
		md.saveMezzo(20);

//		// CREAZIONE MANUALE ISTANZE MEZZI
//
//		Autobus bus1 = new Autobus(Stato.ATTIVO);
//		Tram tram1 = new Tram(Stato.ATTIVO);
//
//		bus1.setTratta(route1);
//		tram1.setTratta(route2);
//		md.saveMezzo(bus1);
//		md.saveMezzo(tram1);

		// CREAZIONE RANDOM ISTANZE STORICO TRATTE E MANUTENZIONE PER OGNI MEZZO
		md.mezzoCorsa(30);
		// CREAZIONE RANDOM ISTANZE STORICO TRATTE E MANUTENZIONE PER SINGOLO MEZZO
		// TRAMITE CODICE MEZZO
//		for (int i = 0; i < 20; i++) {
//			md.mezzoCorsa(10);
//		}
//		for (int i = 0; i < 30; i++) {
//			md.mezzoCorsa(11);
//		}

		// CREAZIONE MANUALE ISTANZA STORICO TRATTE E MANUTENZIONE
//		md.mezzoCorsa(25.0, 10);
//		md.mezzoManutenzione(11, "si è sfasciato il database");

		// RICERCA NUMERO TRATTE:
		// 1) TUTTE
//		md.selectAllNumeroTratte();
//		// 2) BY MEZZO
//		md.selectNumeroTratteByCodiceMezzo(79);
//		// 3) BY TRATTA
//		md.selectNumeroTrattebyTratta(77);
//
//		// RICERCA TEMPO PERCORRENZA EFFETTIVO:
//		// 1) TUTTE
//		md.selectAllTempoEffettivo();
//		// 2) BY MEZZO
//		md.selectTempoEffettivoCodiceMezzo(79);
//		// 3) BY TRATTA
//		md.selectTempoEffettivoCodiceTratta(78);

//		// RICERCA MANUTENZIONI
//		// 1) TUTTE
//		ma.selectAllNumeroManutenzioni();
//		// 2) BY MEZZO
//		ma.selectManutenzioniByMezzo(11);
//		// 3) BY TRATTA
//		ma.selectManutenzioniByTratta(9);
//		Long nbiglietti = bd.findBigliettiByEmettitore(1);
//		log.info("Numero biglietti emessi:" + nbiglietti.toString());
//
//		Long nbigliettiTempo = bd.findBigliettiByTempo(LocalDate.of(2023, 3, 17), LocalDate.of(2023, 5, 17));
//		log.info("Numero biglietti emessi nel periodo di tempo selezionato:" + nbigliettiTempo.toString());
//
//		Long nbigliettiTempoeEmettitore = bd.findBigliettiByTempoAndEmettitore(2, LocalDate.of(2021, 01, 1),
//				LocalDate.of(2022, 01, 1));
//		log.info("Numero biglietti emessi nel periodo di tempo selezionato ed emettitore:"
//				+ nbigliettiTempoeEmettitore.toString());

//		Tessera tesseraRinnovo = td.rinnovoTessera(1);
////		Metodo per la vidimazione del singolo biglietto
//		bd.vidimazioneBiglietto(2);
////		Metodo per la registrazioine della vidimazione del singolo biglietto		
//		bd.dataVidimazioneBiglietto(2);
//
//		// Metodo per l'attivazione di un abbonamento
//		ad.attivazioneAbbonamento(12);
//		// Metodo per la registrazioine della data di attivazione di un abbonamento
//		ad.dataAttivazioneAbbonamento(12);

//		// Tenere traccia del numero di biglietti vidimati in totale in un arco
//		// temporale per mezzo
//		System.out.println(
//				"\nTenere traccia dei biglietti vidimati in totale in un arco temporale per mezzo \n");
//		bd.trovaBigliettiVimidatiPerMezzoInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3), 7)
//				.forEach(b -> System.out.println(b.toString()));
//
//		// Tenere traccia dei biglietti vidimati in totale in un arco
//		// temporale
//		System.out.println("\nTenere traccia dei biglietti vidimati in totale in un arco temporale  \n");
//		bd.trovaBigliettiVimidatiInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3))
//				.forEach(b -> System.out.println(b.toString()));
//
//		// Numero biglietti vidimati in un arco temporale su un Mezzo
//		System.out.println("\nNumero di biglietti vidimati in totale in un arco temporale su un mezzo \n");
//		long numeroBigliettiVidimatiSuMezzoInArcoTemporale = bd.numeroBigliettiVimidatiPerMezzoInArcoTemporale(
//				LocalDate.now().minusDays(3),
//				LocalDate.now().plusDays(3), 7);
//		System.out.println(numeroBigliettiVidimatiSuMezzoInArcoTemporale);
//
//		// // Numero biglietti vidimati in un arco temporale in totale
//		System.out.println("\nNumero di biglietti vidimati in totale in un arco temporale\n");
//		long numeroBigliettiVidimatiInArcoTemporale = bd
//				.numeroBigliettiVimidatiInArcoTemporale(LocalDate.now().minusDays(3), LocalDate.now().plusDays(3));
//		System.out.println(numeroBigliettiVidimatiInArcoTemporale);
//		
//		// Biglietti stampati per emettitore
//		System.out.println("\nBiglietti per emettitore\n");
//		bd.trovaBigliettiPerEmettitore(4).forEach(b -> System.out.println(b.toString()));

//		bd.vidimazioneBiglietto1(2, 11);
//		bd.vidimazioneBiglietto(1);
//		bd.dataVidimazioneBiglietto(1);
//		bd.aggiuntaMezzoInObliterazione(1, 10);
//		td.rinnovoTutteTessereScadute();

//		ad.controlloAbbonamento(3);

//		String letters = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
//		String doubleValidator = "\"^[0-9]*\\\\.([0-9]+)+$\"";
//		Scanner input = new Scanner(System.in);
//		utilizzatore: while (true) {
//			try {
//				log.info(
//						"Benvenuto, chi sei?\n 1 utente,\n 2 Ufficio biglietteria,\n 3 amministratore,\n 4 controllore,\n 0 per uscire");
//				String persona = input.nextLine();
//				if (Integer.parseInt(persona) < 0 || Integer.parseInt(persona) > 4) {
//					log.info("Hai inserito un numero non valido.");
//				} else if (Integer.parseInt(persona) >= 0 || Integer.parseInt(persona) <= 4) {
//					switch (Integer.parseInt(persona)) {
//					case 0:
//						log.info("Hai finito");
//						break utilizzatore;
//					case 1:
//						operazione: while (true) {
//							try {
//								log.info("Benvenuto utente: che azione vuoi eseguire:\n 1 compra un biglietto,\n "
//										+ "2 compra un abbonamento,\n 3 obliterare il biglietto,\n "
//										+ "4 attiva abbonamento,\n 0 per finire");
//								String azione = input.nextLine();
//								if (Integer.parseInt(azione) < 0 || Integer.parseInt(azione) > 4) {
//									log.info("Hai inserito un numero non valido.");
//								} else if (Integer.parseInt(azione) >= 0 || Integer.parseInt(azione) <= 4) {
//									switch (Integer.parseInt(azione)) {
//									case 0:
//										log.info("Hai finito");
//										break operazione;
//									case 1:
//										try {
//											log.info(
//													"Compra il biglietto: Sei da \n 1 distributore \n 2 rivenditore auttorizzato");
//											String tipoEmettitore = input.nextLine();
//											if (tipoEmettitore.equals("1")) {
//												Emettitore emettitore7 = new Emettitore();
//												ed.save(emettitore7);
//												Biglietto b1 = new Biglietto(LocalDate.now(), emettitore7);
//												// random emettitore nella lista distributori
//												bd.save(b1);
//											} else if (tipoEmettitore.equals("2")) {
//												Emettitore emettitore8 = new Emettitore();
//												ed.save(emettitore8);
//												Biglietto b1 = new Biglietto(LocalDate.now(), emettitore8);
//												bd.save(b1);
//												// random emettitore nella lista distributori
//											} else {
//												log.info("Selezione numero errata");
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante la scelta dell'emettitore");
//										}
//										break;
//									case 2:
//										try {
//											log.info("Compra abbonamento: Inserisci il tuo numero tessera");
//											String numeroTessera = input.nextLine();
//											Long numeroTessera1 = Long.parseLong(numeroTessera);
//											Tessera tesseraSelezionata = td.findByCodiceTessera(numeroTessera1);
//											if (tesseraSelezionata != null) {
//												log.info("Sei da \n 1 distributore \n 2 rivenditore auttorizzato");
//												String tipoEmettitore2 = input.nextLine();
//												if (tipoEmettitore2.equals("1")) {
//													Emettitore emettitore7 = new Emettitore();
//													ed.save(emettitore7);
//													log.info("Scegli il tuo abbonamento:\n 1 SETTIMANALE,\n 2 MENSILE");
//													String tipoAbbonamento = input.nextLine();
//													if (tipoAbbonamento.equals("1")) {
//														Abbonamento abb1 = new Abbonamento(LocalDate.now(),
//																Tipoabbonamento.SETTIMANALE, tesseraSelezionata,
//																emettitore7);
//														ad.save(abb1);
//														log.info(
//																"Conserva il tuo codice abbonamento ti servirà all'attivazione. \n Il codice è: "
//																		+ abb1.getCodice_univoco());
//													} else if (tipoAbbonamento.equals("2")) {
//														Abbonamento abb2 = new Abbonamento(LocalDate.now(),
//																Tipoabbonamento.MENSILE, tesseraSelezionata,
//																emettitore7);
//														ad.save(abb2);
//														log.info(
//																"Conserva il tuo codice abbonamento ti servirà all'attivazione. \n Il codice è: "
//																		+ abb2.getCodice_univoco());
//													} else {
//														log.info("Selezione numero errata");
//													}
//												}
//												if (tipoEmettitore2.equals("2")) {
//													Emettitore emettitore7 = new Emettitore();
//													ed.save(emettitore7);
//													log.info("Scegli il tuo abbonamento: SETTIMANALE(1), MENSILE(2)");
//													String tipoAbbonamento = input.nextLine();
//													if (tipoAbbonamento.equals("1")) {
//														Abbonamento abb1 = new Abbonamento(LocalDate.now(),
//																Tipoabbonamento.SETTIMANALE, tesseraSelezionata,
//																emettitore7);
//														ad.save(abb1);
//													} else if (tipoAbbonamento.equals("2")) {
//														Abbonamento abb2 = new Abbonamento(LocalDate.now(),
//																Tipoabbonamento.MENSILE, tesseraSelezionata,
//																emettitore7);
//														ad.save(abb2);
//													} else {
//														log.info("Selezione numero errata");
//													}
//												} else {
//													log.info("Inserimento emettitore errato");
//												}
//											} else {
//												log.info("Tessera non trovata");
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per comprare la tessera");
//										}
//										break;
//									case 3:
//										try {
//											log.info(
//													"Oblitera il biglietto: inserisci il codice del biglietto, lo trovi scritto in alto a desta");
//											String codiceBiglietto = input.nextLine();
//											Biglietto cercaBiglietto = bd
//													.findByCodiceUnivoco(Long.parseLong(codiceBiglietto));
//											if (cercaBiglietto.getData_obliterazione() != null) {
//												log.info("Il biglietto è già stato usato");
//											} else {
//												log.info("Inserisci il numero del tuo mezzo");
//												String codiceMezzo = input.nextLine();
//												bd.vidimazioneBiglietto1(Long.parseLong(codiceBiglietto),
//														Long.parseLong(codiceMezzo));
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per obliterare il biglietto");
//										}
//										break;
//									case 4:
//										try {
//											log.info("Attiva l'abbonamento: inserisci il codice del tuo abbonamento");
//											String codiceAbbonamento = input.nextLine();
//											Abbonamento cercaAbbonamento = ad
//													.findByCodiceUnivoco(Long.parseLong(codiceAbbonamento));
//											if (cercaAbbonamento.getData_obliterazione() != null) {
//												log.info("Il tuo abbonamento è già stato attivato!");
//											} else {
//												ad.attivazioneAbbonamento(Long.parseLong(codiceAbbonamento));
//												ad.dataScadenzaAbbonamento(Long.parseLong(codiceAbbonamento));
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per comprare l'abbonamento");
//										}
//										break;
//									default:
//										log.info("Hai inserito un numero non elencato");
//										break;
//									}
//								} else {
//									log.info("Hai inserito un carattere non valido nella scelta dell'operazione");
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//								log.info("Errore durante la scelta dell'operazione utente");
//							}
//						}
//						break;
//					case 2:
//						ufficioBiglietteria: while (true) {
//							try {
//								log.info(
//										"Ufficio Biglietteria: Che azione vuoi eseguire:\n 1 aggiungi un utente,\n 2 crea una tessera,\n 3 rinnovare la tessera,\n 4 informazioni tratta,\n 0 per finire");
//								String azione2 = input.nextLine();
//								if (Integer.parseInt(azione2) < 0 || Integer.parseInt(azione2) > 4) {
//									log.info("Hai inserito un numero non valido.");
//								} else if (Integer.parseInt(azione2) >= 0 || Integer.parseInt(azione2) <= 4) {
//									switch (Integer.parseInt(azione2)) {
//									case 0:
//										log.info("Hai finito");
//										break ufficioBiglietteria;
//									case 1:
//										try {
//											log.info("Creare l'utente: Inserisci il nome dell'utente");
//											String nome = input.nextLine();
//											if (nome.matches(letters)) {
//												log.info("Inserisci il cognome dell'utente");
//												String cognome = input.nextLine();
//												if (cognome.matches(letters)) {
//													log.info("Inserisci la data di nascita dell'utente");
//													String dateString = input.nextLine();
//													DateTimeFormatter formatter = DateTimeFormatter
//															.ofPattern("yyyy-MM-dd");
//													LocalDate dataNascita = LocalDate.parse(dateString, formatter);
//													Utente ut10 = new Utente(nome, cognome, dataNascita);
//													ud.save(ut10);
//													log.info(ut10.toString());
//												} else {
//													log.info("Inserisci un cognome senza numeri o caratteri speciali");
//												}
//											} else {
//												log.info("Inserisci un nome senza numeri o caratteri speciali");
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per creare l'utente");
//										}
//										break;
//									case 2:
//										try {
//											log.info("Creare la tessera: Inserisci l'id dell'utente");
//											String numeroid = input.nextLine();
//											Long idutente = Long.parseLong(numeroid);
//											Utente utenteSelezionato = ud.findById(idutente);
//											Emettitore emettitore7 = new Emettitore();
//											ed.save(emettitore7);
//											// Implementare random
//											Tessera tessera1 = new Tessera(LocalDate.now(), utenteSelezionato,
//													emettitore7);
//											td.save(tessera1);
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per creare la tessera");
//										}
//										break;
//									case 3:
//										try {
//											log.info(
//													"Rinnovamento tessera: \n Inserisci il codice tessera per rinnovarla");
//											String numeroTessera = input.nextLine();
//											td.rinnovoTessera(Long.parseLong(numeroTessera));
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info(
//													"Errore durante il rinnovamento tessera, controlla il tuo codice tessera");
//										}
//										break;
//									case 4:
//										try {
//											log.info(
//													"Informazioni tratta: vuoi sapere quali mezzi ti portano alla tua destinazione?");
//											log.info("Inserisci la tua destinazione");
//											String destinazione = input.nextLine();
//											if (destinazione.matches(letters)) {
//												List<Tratta> destinazioneCercata = trd.findByCapolinea(destinazione);
//												for (Tratta elementi : destinazioneCercata) {
//													List<Mezzi> listaMezziTrovati = elementi.getMezzi();
//													for (Mezzi mezzo : listaMezziTrovati) {
//														log.info("Mezzi che portano a " + destinazione
//																+ " sono i numeri: " + mezzo.getCodice_mezzo() + "\n");
//													}
//												}
//											} else {
//												log.info(
//														"Errore, inserisci la tua destinazione senza numeri o caratteri speciali");
//											}
//
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante la ricerca del capolinea");
//										}
//										break;
//									default:
//										log.info("Hai inserito un numero non elencato");
//									}
//								} else {
//									log.info(
//											"Hai inserito un carattere non valido nella scelta dell'azione della Biglietteria");
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//								log.info("Errore durante la scelta dell'operazione biglietteria");
//							}
//
//						}
//						break;
//					case 3:
//						amministratore: while (true) {
//							try {
//								log.info(
//										"Che azione vuoi eseguire:\n 1 controlla lista manutenzioni,\n 2 numero biglietti obliterati su un mezzo,\n "
//												+ "3 rinnova tutte le tessere, "
//												+ "\n 4 mezzi che percorrono una tratta,\n 5 tempo effettivo che un mezzo impiega,"
//												+ "\n 6 aggiungi una tratta,\n 7 aggiungi un mezzo, \n 0 per finire");
//								String azione3 = input.nextLine();
//								if (Integer.parseInt(azione3) < 0 || Integer.parseInt(azione3) > 7) {
//									log.info("Hai inserito un numero non valido.");
//								} else if (Integer.parseInt(azione3) >= 0 || Integer.parseInt(azione3) <= 7) {
//									switch (Integer.parseInt(azione3)) {
//									case 0:
//										log.info("Hai finito");
//										break amministratore;
//									case 1:
//										try {
//											log.info("Manutenzioni: Inserisci il numero di mezzo che vuoi controllare");
//											String mezzoControllato1 = input.nextLine();
//											Mezzi findMezzo = md.getMezzoByCodice(Long.parseLong(mezzoControllato1));
//											List<Manutenzione> manutenzioneMezzo = findMezzo.getStorico_manutenzione();
//											for (Manutenzione elementi : manutenzioneMezzo) {
//												log.info("Il mezzo è stato in manutenzione per: "
//														+ elementi.getDurata_in_giorni()
//														+ " giorni, è tornato attivo il giorno: "
//														+ elementi.getFine_manutenzione()
//														+ "\n Codice della manutenzione: "
//														+ elementi.getCodice_manutenzione());
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore nell'inserimento per la ricerca del mezzo");
//										}
//										break;
//									case 2:
//										biglietto: while (true) {
//											try {
//												log.info(
//														"Inserisci il tipo di operazione: \n 1 n. biglietti vidiminati in un arco temporale\n 2 n. biglietti vidiminati in un arco temporale su un determinato mezzo \n "
//																+ "3 n. biglietti emessi da emettitore \n 4 n. biglietti emessi da emettitore in un arco temporale \n 0 per finire");
//												String operazione = input.nextLine();
//												if (Integer.parseInt(operazione) < 0
//														|| Integer.parseInt(operazione) > 4) {
//													log.info("Hai inserito un numero non valido.");
//												} else if (Integer.parseInt(operazione) >= 0
//														|| Integer.parseInt(operazione) <= 4) {
//													switch (Integer.parseInt(operazione)) {
//													case 0:
//														log.info("Hai finito");
//														break biglietto;
//													case 1:
//														try {
//															log.info(
//																	"Numero biglietti validati in un determinato periodo di tempo:\n Scegli la data di inizio");
//															String inizio = input.nextLine();
//															DateTimeFormatter formatter = DateTimeFormatter
//																	.ofPattern("yyyy-MM-dd");
//															LocalDate dataInizio = LocalDate.parse(inizio, formatter);
//															log.info("Scegli la data di fine");
//															String fine = input.nextLine();
//															LocalDate dataFine = LocalDate.parse(fine, formatter);
//															Long numeroB = bd.numeroBigliettiVimidatiInArcoTemporale(
//																	dataInizio, dataFine);
//															log.info("Biglietti emmessi nell'arco temporale "
//																	+ Long.toString(numeroB));
//														} catch (Exception e) {
//															e.printStackTrace();
//															log.info(
//																	"Errore durante l'inserimento per cercare i biglietti");
//														}
//														break;
//													case 2:
//														try {
//															log.info(
//																	"Biglietti validati su un mezzo e in un determinato periodo di tempo:\n Scegli la data di inizio");
//															String inizio1 = input.nextLine();
//															DateTimeFormatter formatter1 = DateTimeFormatter
//																	.ofPattern("yyyy-MM-dd");
//															LocalDate dataInizio1 = LocalDate.parse(inizio1,
//																	formatter1);
//															log.info("Scegli la data di fine");
//															String fine1 = input.nextLine();
//															LocalDate dataFine1 = LocalDate.parse(fine1, formatter1);
//															log.info("\nInsierisci il codice identificativo del mezzo");
//															String mezzo = input.nextLine();
//															Long numeroBigliettiPerTempoEPerMezzo = bd
//																	.numeroBigliettiVimidatiPerMezzoInArcoTemporale(
//																			dataInizio1, dataFine1,
//																			Integer.parseInt(mezzo));
//															log.info("Biglietti emmessi nell'arco temporale "
//																	+ Long.toString(numeroBigliettiPerTempoEPerMezzo));
//														} catch (Exception e) {
//															e.printStackTrace();
//															log.info(
//																	"Errore durante l'inserimento per cercare i biglietti");
//														}
//														break;
//													case 3:
//														try {
//															log.info(
//																	"Numero di biglietti emessi:\n Scegli l'emettitore");
//															String emettitore = input.nextLine();
//															int contaBigliettiPerEmettitore = bd
//																	.trovaBigliettiPerEmettitore(
//																			Long.parseLong(emettitore))
//																	.size();
//															log.info("Numero tatale di biglietti emessi: "
//																	+ Integer.toString(contaBigliettiPerEmettitore));
//														} catch (Exception e) {
//															e.printStackTrace();
//															log.info(
//																	"Errore durante l'inserimento per cercare gli emettitori");
//														}
//														break;
//													case 4:
//														try {
//															log.info(
//																	"Numero di biglietti emessi in un determinato periodo di tempo:\n Scegli la data di inizio");
//															String inizio2 = input.nextLine();
//															DateTimeFormatter formatter2 = DateTimeFormatter
//																	.ofPattern("yyyy-MM-dd");
//															LocalDate dataInizio2 = LocalDate.parse(inizio2,
//																	formatter2);
//															log.info("Scegli la data di fine");
//															String fine2 = input.nextLine();
//															LocalDate dataFine2 = LocalDate.parse(fine2, formatter2);
//															log.info(
//																	"\nInsierisci il codice identificativo dell'emettitore");
//															String emettitoreId = input.nextLine();
//															Long numeroBigliettiPerTempoEPerEmettitore = bd
//																	.findBigliettiByTempoAndEmettitore(
//																			Long.parseLong(emettitoreId), dataInizio2,
//																			dataFine2);
//															log.info(
//																	"Biglietti emmessi nell'arco temporale dall'emettitore scelto: "
//																			+ Long.toString(
//																					numeroBigliettiPerTempoEPerEmettitore));
//														} catch (Exception e) {
//															e.printStackTrace();
//															log.info(
//																	"Errore durante l'inserimento per cercare il numero di biglietti emessi");
//														}
//														break;
//													default:
//														log.info("Hai inserito un numero non elencato");
//													}
//												} else {
//													log.info(
//															"Hai inserito un carattere non valido nella scelta operazione Biglietto");
//												}
//											} catch (Exception e) {
//												e.printStackTrace();
//												log.info("Errore durante la scelta dell'operazione biglietto");
//											}
//
//										}
//										break;
//									case 3:
//										log.info("Stai per rinnovare tutte le tessere, vuoi procedere? 1 Si, 2 No");
//										String rinnovare = input.nextLine();
//										if (rinnovare.equals("1")) {
//											td.rinnovoTutteTessereScadute();
//											log.info("Operazione eseguita con successo!");
//										} else if (rinnovare.equals("2")) {
//											log.info("Annulla l'operazione");
//										} else {
//											log.info("Errore durante il rinnovo tessere, inserire il numero richiesto");
//										}
//										break;
//									case 4:
//										try {
//											log.info(
//													"Mezzi in una tratta:\n Inserisci il numero di tratta che vuoi controllare");
//											String trattaControllata = input.nextLine();
//											Tratta findTratta = trd
//													.findByCodiceTratta(Long.parseLong(trattaControllata));
//											List<Mezzi> findMezzi = findTratta.getMezzi();
//											for (Mezzi elementi : findMezzi) {
//												System.out.println(
//														"Mezzo che percorre la tratta:" + elementi.getCodice_mezzo());
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento del numero di tratta");
//										}
//										break;
//									case 5:
//										try {
//											log.info("Tempo effettivo: Inserisci il mezzo che vuoi controllare");
//											String mezzoControllato = input.nextLine();
//											md.selectTempoEffettivoCodiceMezzo(Long.parseLong(mezzoControllato));
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento del mezzo");
//										}
//										break;
//									case 6:
//										try {
//											log.info("Nuova tratta: Inserisci il punto di partenza del mezzo");
//											String partenza = input.nextLine();
//											if (partenza.matches(letters)) {
//												log.info("Inserisci il suo capolinea");
//												String capolinea = input.nextLine();
//												if (capolinea.matches(letters)) {
//													log.info("Inserisci il tempo di percorrenza");
//													String tMedio = input.nextLine();
//													if (tMedio.matches(doubleValidator)) {
//														Tratta nuovaTratta = new Tratta(partenza, capolinea,
//																Double.parseDouble(tMedio));
//														trd.saveTratta(nuovaTratta);
//													} else {
//														log.info("Inserisci un tempo medio valido");
//													}
//												} else {
//													log.info("Inserisci un capolinea valido");
//												}
//											} else {
//												log.info("Inserisci una partenza valida");
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info(
//													"Errore durante l'inserimento per l'inserimento della nuova tratta");
//										}
//										break;
//									case 7:
//										try {
//											log.info("Nuovo mezzo! Inserisci il tipo di mezzo, 1 Autobus, 2 Tram");
//											String mezzoScelto = input.nextLine();
//											if (mezzoScelto.equals("1")) {
//												log.info(
//														"Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
//												String statoMezzoScelto = input.nextLine();
//												if (statoMezzoScelto.equals("1")) {
//													Autobus nuovoAutobus = new Autobus(Stato.ATTIVO);
//													md.saveMezzo(nuovoAutobus);
//												} else if (statoMezzoScelto.equals("2")) {
//													Autobus nuovoAutobus = new Autobus(Stato.MANUTENZIONE);
//													md.saveMezzo(nuovoAutobus);
//												} else {
//													log.info("Il numero inserito non è valido");
//												}
//											} else if (mezzoScelto.equals("2")) {
//												log.info(
//														"Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
//												String statoMezzoScelto2 = input.nextLine();
//												if (statoMezzoScelto2.equals("1")) {
//													Tram nuovoAutobus = new Tram(Stato.ATTIVO);
//													md.saveMezzo(nuovoAutobus);
//												} else if (statoMezzoScelto2.equals("2")) {
//													Tram nuovoAutobus = new Tram(Stato.MANUTENZIONE);
//													md.saveMezzo(nuovoAutobus);
//												} else {
//													log.info("Il numero inserito non è valido");
//												}
//											} else {
//												log.info("Inserimento errato durante la creazione del mezzo!");
//											}
//										} catch (Exception e) {
//											e.printStackTrace();
//											log.info("Errore durante l'inserimento per l'inserimento del nuovo mezzo");
//										}
//										break;
//									default:
//										log.info("Hai inserito un numero non elencato");
//										continue;
//									}
//								} else {
//									log.info(
//											"Hai inserito un carattere non valido nella scelta dell'azione della Biglietteria");
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//								log.info("Errore durante la scelta dell'operazione dell'amministratore");
//							}
//						}
//						break;
//					case 4:
//						log.info("Sei stato beccato dal controllore! Hai un abbonameno o un biglietto valido?");
//						log.info(
//								"Inserisci:\n 1 per mostrare il biglietto,\n 2 per mostrare l'abbonamento,\n Qualunue altro numero per tentare la fuga!");
//						String evitaLaMulta = input.nextLine();
//						try {
//							if (evitaLaMulta.equals("1")) {
//								log.info("Hai validato il tuo biglietto?");
//								log.info("Inserisci il tuo codice biglietto");
//								String evitaMultaBiglietto = input.nextLine();
//								Biglietto cercaBiglietto1 = bd.findByCodiceUnivoco(Long.parseLong(evitaMultaBiglietto));
//								if (cercaBiglietto1.getData_obliterazione() != null) {
//									if (cercaBiglietto1.getData_obliterazione().equals(LocalDate.now())) {
//										log.info("Il tuo biglietto è valido, sei salvo!");
//									} else {
//										log.info(
//												"Stai viaggiando con un biglietto vecchio! 100 euro volano via dal porafoglio!");
//									}
//								} else {
//									log.info(
//											"Furbetto, non hai validato il tuo biglietto... 100 euro volano via dal porafoglio!");
//								}
//							} else if (evitaLaMulta.equals("2")) {
//								log.info("Hai scelto l'abbonamento: inserisci il tuo codice di tessera");
//								String evitaLaMultaAbbonamento = input.nextLine();
//								ad.controlloAbbonamento(Long.parseLong(evitaLaMultaAbbonamento));
//							} else {
//								log.info(
//										"Tentativo fallito!!\n Totale Multa = 110 euro (10 euro in più per la tentata fuga!), \n Vergognati!");
//							}
//						} catch (Exception e) {
//							e.printStackTrace();
//							log.info("Errore durante l'inserimento del biglietto");
//							log.info("Sei riuscito a fuggire!");
//						}
//						break;
//
//					default:
//						log.info("Hai inserito un numero non elencato");
//					}
//				} else {
//					log.info("Hai inserito un carattere non valido nella scelta dell'utilizzatore");
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				log.info("Errore durante l'inserimento della persona");
//			}
//		}
//		input.close();
		em.close();
		emf.close();

	}
}
