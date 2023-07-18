package week16BW.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import week16BW.emettitori.Distributore;
import week16BW.emettitori.Emettitore;
import week16BW.emettitori.EmettitoreDAO;
import week16BW.tesserautente.Tessera;
import week16BW.tesserautente.TesseraDAO;
import week16BW.tesserautente.Utente;
import week16BW.tesserautente.UtenteDAO;
import week16BW.utils.JpaUtil;

public class Main {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();
		UtenteDAO ud = new UtenteDAO(em);
		TesseraDAO td = new TesseraDAO(em);
		EmettitoreDAO ed = new EmettitoreDAO(em);

		Utente ut1 = new Utente("B", "G", LocalDate.of(1993, 05, 28));
		Utente ut2 = new Utente("C", "A", LocalDate.of(1988, 07, 06));
		ud.save(ut1);
		ud.save(ut2);
	    
		Tessera tess1 = new Tessera("B", "G", LocalDate.of(2021, 04, 02), ut1);
		Tessera tess2 = new Tessera("C", "A", LocalDate.of(2023, 07, 14), ut2);
		td.save(tess1);
		td.save(tess2);

		Emettitore emettitore1 = new Emettitore();
		ed.save(emettitore1);
		Distributore emettitore2 = new Distributore(true);
		ed.save(emettitore2);
		em.close();
		emf.close();
	}
}
