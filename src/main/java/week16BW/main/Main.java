package week16BW.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
//		Tessera tess1 = new Tessera(LocalDate.of(2021, 4, 02), ut1, emettitore1);
//		Tessera tess2 = new Tessera(LocalDate.of(2023, 1, 1), ut2, emettitore2);
//		Tessera tess3 = new Tessera(LocalDate.of(2022, 5, 12), ut3, emettitore2);
//		Tessera tess4 = new Tessera(LocalDate.of(2019, 8, 24), ut4, emettitore3);
//		Tessera tess5 = new Tessera(LocalDate.of(2023, 5, 14), ut5, emettitore4);
//		Tessera tess6 = new Tessera(LocalDate.of(2017, 9, 16), ut6, emettitore3);
//		td.save(tess1);
//		td.save(tess2);
//		td.save(tess3);
//		td.save(tess4);
//		td.save(tess5);
//		td.save(tess6);
////		// Creazione istanze per biglietto
//		Biglietto biglietto1 = new Biglietto(LocalDate.of(2023, 04, 17), emettitore1);
//		Biglietto biglietto2 = new Biglietto(LocalDate.of(2023, 04, 19), emettitore1);
//		Biglietto biglietto3 = new Biglietto(LocalDate.of(2022, 04, 20), emettitore1);
//		Biglietto biglietto4 = new Biglietto(LocalDate.of(2021, 05, 9), emettitore2);
////		// Salvataggio biglietti a DB
//		bd.save(biglietto1);
//		bd.save(biglietto2);
//		bd.save(biglietto3);
//		bd.save(biglietto4);
////
////// Creo Abbonamento
////		// Creazione istanze per abbonamento
//		Abbonamento abbonamento1 = new Abbonamento(LocalDate.of(2023, 2, 14), Tipoabbonamento.MENSILE, tess1,
//				emettitore1);
//		Abbonamento abbonamento2 = new Abbonamento(LocalDate.of(2023, 4, 27), Tipoabbonamento.SETTIMANALE, tess2,
//				emettitore2);
//		Abbonamento abbonamento3 = new Abbonamento(LocalDate.of(2022, 4, 17), Tipoabbonamento.SETTIMANALE, tess3,
//				emettitore1);
////		// Salvataggio abbonamenti a DB
//		ad.save(abbonamento1);
//		ad.save(abbonamento2);
//		ad.save(abbonamento3);
////
////
////
////		// CREAZIONE MANUALE ISTANZE TRATTA
//		Tratta route1 = new Tratta("Punto A", "Punto B", 20.0);
//		Tratta route2 = new Tratta("Punto C", "Punto D", 27.0);
////
//		trd.saveTratta(route1);
//		trd.saveTratta(route2);
////
////		// CREAZIONE MANUALE ISTANZE MEZZI
////
//		Autobus bus1 = new Autobus(Stato.ATTIVO);
//		Tram tram1 = new Tram(Stato.MANUTENZIONE);
//
//		bus1.setTratta(route1);
//		tram1.setTratta(route2);
//		md.saveMezzo(bus1);
//		md.saveMezzo(tram1);
//
////		// CREAZIONE RANDOM ISTANZE STORICO TRATTE
//		for (int i = 0; i < 15; i++) {
//			md.mezzoCorsa(10);
//		}

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

		Scanner input = new Scanner(System.in);
		utilizzatore: while (true) {
			log.info("Chi sei: 1 utente, 2 Ufficio biglietteria, 3 amministratore, 0 per uscire");
			String persona = input.nextLine();
			if (Integer.parseInt(persona) < 0 || Integer.parseInt(persona) > 2) {
				log.info("Hai inserito un numero non valido.");
			}
			switch (Integer.parseInt(persona)) {
			case 0: 
				log.info("Hai finito");
				break utilizzatore;
			case 1:
				operazione: while (true) {
					log.info(
							"Che azione vuoi eseguire: 1 compra un biglietto, 2 compra un abbonamento,\n 3 obliterare il biglietto, 4 attiva abbonamento, 0 per finire");
					String azione = input.nextLine();
					if (Integer.parseInt(azione) < 0 || Integer.parseInt(azione) > 4) {
						log.info("Hai inserito un numero non valido.");
					}
					switch (Integer.parseInt(azione)) {
					case 0:
						log.info("Hai finito");
						break operazione;
					case 1:
						log.info("Sei da un distributore(1) o da un rivenditore auttorizzato(2)?");
						String tipoEmettitore = input.nextLine();
						if (tipoEmettitore.equals("1")) {
							Emettitore emettitore1 = new Emettitore();
							ed.save(emettitore1);
							Biglietto b1 = new Biglietto(LocalDate.now(), emettitore1);
							// random emettitore nella lista distributori
							bd.save(b1);
						} else if (tipoEmettitore.equals("2")) {
							Emettitore emettitore2 = new Emettitore();
							ed.save(emettitore2);
							Biglietto b1 = new Biglietto(LocalDate.now(), emettitore2);
							bd.save(b1);
							// random emettitore nella lista distributori
						} else {
							log.info("Selezione numero errata");
						}
						break;
					case 2:
						log.info("Inserisci il tuo numero tessera");
						String numeroTessera = input.nextLine();
						Long numeroTessera1 = Long.parseLong(numeroTessera);
						Tessera tesseraSelezionata = td.findByCodiceTessera(numeroTessera1);
						log.info("Sei da un distributore(1) o da un rivenditore auttorizzato(2)?");
						String tipoEmettitore2 = input.nextLine();
						if (tipoEmettitore2.equals("1")) {
							Emettitore emettitore1 = new Emettitore();
							ed.save(emettitore1);
							log.info("Scegli il tuo abbonamento: SETTIMANALE(1), MENSILE(2)");
							String tipoAbbonamento = input.nextLine();
							if (tipoAbbonamento.equals("1")) {
								Abbonamento abb1 = new Abbonamento(LocalDate.now(), Tipoabbonamento.SETTIMANALE,
										tesseraSelezionata, emettitore1);
								ad.save(abb1);
								log.info(
										"Conserva il tuo codice abbonamento ti servirà all'attivazione. \n Il codice è: "
												+ abb1.getCodice_univoco());
							} else if (tipoAbbonamento.equals("2")) {
								Abbonamento abb2 = new Abbonamento(LocalDate.now(), Tipoabbonamento.MENSILE,
										tesseraSelezionata, emettitore1);
								ad.save(abb2);
								log.info(
										"Conserva il tuo codice abbonamento ti servirà all'attivazione. \n Il codice è: "
												+ abb2.getCodice_univoco());
							} else {
								log.info("Selezione numero errata");
							}
						}
						if (tipoEmettitore2.equals("2")) {
							Emettitore emettitore1 = new Emettitore();
							ed.save(emettitore1);
							log.info("Scegli il tuo abbonamento: SETTIMANALE(1), MENSILE(2)");
							String tipoAbbonamento = input.nextLine();
							if (tipoAbbonamento.equals("1")) {
								Abbonamento abb1 = new Abbonamento(LocalDate.now(), Tipoabbonamento.SETTIMANALE,
										tesseraSelezionata, emettitore1);
								ad.save(abb1);
							} else if (tipoAbbonamento.equals("2")) {
								Abbonamento abb2 = new Abbonamento(LocalDate.now(), Tipoabbonamento.MENSILE, tesseraSelezionata,
										emettitore1);
								ad.save(abb2);
							} else {
								log.info("Selezione numero errata");
							}
						}
							break;

						case 3:
							log.info(
									"Oblitera il biglietto: inserisci il codice del biglietto, lo trovi scritto in alto a desta");
						String codiceBiglietto = input.nextLine();
						log.info("Inserisci il numero del tuo mezzo");
						String codiceMezzo = input.nextLine();
						bd.vidimazioneBiglietto1(Long.parseLong(codiceBiglietto), Long.parseLong(codiceMezzo));
						break;
					case 4:
						log.info("Attiva l'abbonamento: inserisci il codice del tuo abbonamento");
						String codiceAbbonamento = input.nextLine();
						ad.attivazioneAbbonamento(Long.parseLong(codiceAbbonamento));
//						ad.dataScadenzaAbbonamento(Long.parseLong(codiceAbbonamento));
						break;
					default:
						log.info("Attenzione, inserimento numero sbagliato o carattere sbagliato");
						continue operazione;
					}
					
				}
				break;
			case 2:
				ufficioBiglietteria: while (true) {
					log.info(
							"Che azione vuoi eseguire: 1 aggiungi un utente, 2 crea una tessera, 3 rinnovare la tessera, 4 info tratta, 0 per finire");
					String azione2 = input.nextLine();
					if (Integer.parseInt(azione2) < 0 || Integer.parseInt(azione2) > 4) {
						log.info("Hai inserito un numero non valido.");
					}
					switch (Integer.parseInt(azione2)) {
					case 0:
						log.info("Hai finito");
						break ufficioBiglietteria;
					case 1:
						log.info("Inserisci il nome dell'utente");
						String nome = input.nextLine();
						log.info("Inserisci il cognome dell'utente");
						String cognome = input.nextLine();
						log.info("Inserisci la data di nascita dell'utente");
						String dateString = input.nextLine();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate dataNascita = LocalDate.parse(dateString, formatter);
						Utente ut10 = new Utente(nome, cognome, dataNascita);
						ud.save(ut10);
						log.info(ut10.toString());
						break;
					case 2:
//						LocalDate emissione_tessera, Utente utente, Emettitore emettitore
						log.info("Inserisci l'id dell'utente");
						String numeroid = input.nextLine();
						Long idutente = Long.parseLong(numeroid);
						Utente utenteSelezionato = ud.findById(idutente);
						Emettitore emettitore1 = new Emettitore();
						ed.save(emettitore1);
						// Implementare random
						Tessera tessera1 = new Tessera(LocalDate.now(), utenteSelezionato, emettitore1);
						td.save(tessera1);
						break;
					case 3:
						log.info("Inserisci il codice tessera per rinnovarla");
						String numeroTessera = input.nextLine();
						td.rinnovoTessera(Long.parseLong(numeroTessera));
						break;
					case 4:
						log.info("Nuovo mezzo! Inserisci il tipo di mezzo, 1 Autobus, 2 Tram");
						String mezzoScelto = input.nextLine();
						if (mezzoScelto.equals("1")) {
							log.info("Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
							String statoMezzoScelto = input.nextLine();
							if (statoMezzoScelto.equals("1")) {
								Autobus nuovoAutobus = new Autobus(Stato.ATTIVO);
								md.saveMezzo(nuovoAutobus);
							} else if (statoMezzoScelto.equals("2")) {
								Autobus nuovoAutobus = new Autobus(Stato.MANUTENZIONE);
								md.saveMezzo(nuovoAutobus);
							} else {
								log.info("Il numero inserito non è valido");
							}
						} else if (mezzoScelto.equals("2")) {
							log.info("Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
							String statoMezzoScelto2 = input.nextLine();
							if (statoMezzoScelto2.equals("1")) {
								Tram nuovoAutobus = new Tram(Stato.ATTIVO);
								md.saveMezzo(nuovoAutobus);
							} else if (statoMezzoScelto2.equals("2")) {
								Tram nuovoAutobus = new Tram(Stato.MANUTENZIONE);
								md.saveMezzo(nuovoAutobus);
							} else {
								log.info("Il numero inserito non è valido");
							}
						}
						break;
					default:
						log.info("Attenzione, inserimento numero sbagliato o carattere sbagliato");
						continue ufficioBiglietteria;
					}
				}
				break;
			case 3:
				amministratore: while (true) {
					log.info(
							"Che azione vuoi eseguire: 1 controlla lista manutenzioni, 2 numero biglietti obliterati su un mezzo, "
									+ "3 numero biglietti emessi da emettitore, 4 rinnova tutte le tessere, "
									+ "5 mezzi che percorrono una tratta,6 tempo effettivo che un mezzo impiega,"
									+ " 7 aggiungi una tratta, 8 aggiungi un mezzo, 0 per finire");
					String azione3 = input.nextLine();
					if (Integer.parseInt(azione3) < 0 || Integer.parseInt(azione3) > 8) {
						log.info("Hai inserito un numero non valido.");
					}
					switch (Integer.parseInt(azione3)) {
					case 0:
						log.info("Hai finito");
						break amministratore;
					case 1:
						// Numero biglietti obliterati
						biglietto: while (true) {
							log.info(
									"Inserisci il tipo di operazione: \n 1 n. biglietti vidiminati in un arco temporale\n 2 n. biglietti vidiminati in un arco temporale su un determinato mezzo \n "
											+ "3 n. biglietti emessi da emettitore \n 4 n. biglietti emessi da emettitore in un arco temporale \n 0 per finire");
							String operazione = input.nextLine();
							if (Integer.parseInt(operazione) < 0 || Integer.parseInt(operazione) > 4) {
								log.info("Hai inserito un numero non valido.");
							}
							switch (Integer.parseInt(operazione)) {
							case 0:
								log.info("Hai finito");
								break biglietto;
							case 1:
								log.info("Scegli la data di inizio");
								String inizio = input.nextLine();
								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dataInizio = LocalDate.parse(inizio, formatter);
								log.info("Scegli la data di fine");
								String fine = input.nextLine();
								LocalDate dataFine = LocalDate.parse(fine, formatter);
								Long numeroB = bd.numeroBigliettiVimidatiInArcoTemporale(dataInizio, dataFine);
								log.info("Biglietti emmessi nell'arco temporale " + Long.toString(numeroB));
								break;
							case 2:
								log.info("Scegli la data di inizio");
								String inizio1 = input.nextLine();
								DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dataInizio1 = LocalDate.parse(inizio1, formatter1);
								log.info("Scegli la data di fine");
								String fine1 = input.nextLine();
								LocalDate dataFine1 = LocalDate.parse(fine1, formatter1);
								log.info("\nInsierisci il codice identificativo del mezzo");
								String mezzo = input.nextLine();
								Long numeroBigliettiPerTempoEPerMezzo = bd
										.numeroBigliettiVimidatiPerMezzoInArcoTemporale(
										dataInizio1, dataFine1, Integer.parseInt(mezzo));
								log.info("Biglietti emmessi nell'arco temporale "
										+ Long.toString(numeroBigliettiPerTempoEPerMezzo));
								break;
							case 3:
								log.info("Scegli l'emettitore");
								String emettitore = input.nextLine();
								int contaBigliettiPerEmettitore = bd
										.trovaBigliettiPerEmettitore(Long.parseLong(emettitore)).size();
								log.info("Numero tatale di biglietti emessi: "
										+ Integer.toString(contaBigliettiPerEmettitore));
								break;
							case 4:
								log.info("Scegli la data di inizio");
								String inizio2 = input.nextLine();
								DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
								LocalDate dataInizio2 = LocalDate.parse(inizio2, formatter2);
								log.info("Scegli la data di fine");
								String fine2 = input.nextLine();
								LocalDate dataFine2 = LocalDate.parse(fine2, formatter2);
								log.info("\nInsierisci il codice identificativo dell'emettitore");
								String emettitoreId = input.nextLine();
								Long numeroBigliettiPerTempoEPerEmettitore = bd.findBigliettiByTempoAndEmettitore(
										Long.parseLong(emettitoreId), dataInizio2, dataFine2);
								log.info("Biglietti emmessi nell'arco temporale dall'emettitore scelto: "
										+ Long.toString(numeroBigliettiPerTempoEPerEmettitore));
								break;
							}
						}
					case 2:
						// String partenza, String capolinea, Double t_medio
						log.info("Nuova tratta: Inserisci il punto di partenza del mezzo");
						String partenza = input.nextLine();
						log.info("Inserisci il suo capolinea");
						String capolinea = input.nextLine();
						log.info("Inserisci il tempo di percorrenza");
						String tMedio = input.nextLine();
						Tratta nuovaTratta = new Tratta(partenza, capolinea, Double.parseDouble(tMedio));
						trd.saveTratta(nuovaTratta);
						break;
					case 3:
						// Inserimento mezzo
						log.info("Nuovo mezzo! Inserisci il tipo di mezzo, 1 Autobus, 2 Tram");
						String mezzoScelto = input.nextLine();
						if (mezzoScelto.equals("1")) {
							log.info("Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
							String statoMezzoScelto = input.nextLine();
							if (statoMezzoScelto.equals("1")) {
								Autobus nuovoAutobus = new Autobus(Stato.ATTIVO);
								md.saveMezzo(nuovoAutobus);
							} else if (statoMezzoScelto.equals("2")) {
								Autobus nuovoAutobus = new Autobus(Stato.MANUTENZIONE);
								md.saveMezzo(nuovoAutobus);
							} else {
								log.info("Il numero inserito non è valido");
							}
						} else if (mezzoScelto.equals("2")) {
							log.info("Nuovo mezzo! Inserisci lo stato del tuo mezzo, 1 attivo, 2 manutenzione");
							String statoMezzoScelto2 = input.nextLine();
							if (statoMezzoScelto2.equals("1")) {
								Tram nuovoAutobus = new Tram(Stato.ATTIVO);
								md.saveMezzo(nuovoAutobus);
							} else if (statoMezzoScelto2.equals("2")) {
								Tram nuovoAutobus = new Tram(Stato.MANUTENZIONE);
								md.saveMezzo(nuovoAutobus);
							} else {
								log.info("Il numero inserito non è valido");
							}
						}
						break;
					}
					break;
				}
				break;
			default:
				log.info("Attenzione, inserimento numero sbagliato o carattere sbagliato");
				continue utilizzatore;
	
			// input.close();
//			em.close();
//			emf.close();
		}

		}
		
	}
}

