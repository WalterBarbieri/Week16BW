package week16BW.manutenzione;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.mezzi.Mezzi;
//import week16BW.mezzi.Mezzi;

@Entity
@Getter
@Setter
@NoArgsConstructor

@NamedQuery(name = "selectAllManutenzioni", query = "SELECT a FROM Manutenzione a")
@NamedQuery(name = "selectManutenzioniByMezzo", query = "SELECT a FROM Mezzi a WHERE codice_mezzo = :codice_mezzo")
@NamedQuery(name = "selectManutenzioniByTratta", query = "SELECT a FROM Mezzi a WHERE tratta.codice_tratta = :codice_tratta")
public class Manutenzione {
	// Definizione attributi
	@Id
	@GeneratedValue
	private long codice_manutenzione;
	@ManyToOne
	@JoinColumn(name = "mezzo_manutenzione", referencedColumnName = "codice_mezzo")
	private Mezzi mezzo;
	@Enumerated(EnumType.STRING)
	private Tipo_manutenzione tipo_manutenzione;
	private String descrizione;
	private LocalDate inizio_manutenzione;
	private LocalDate fine_manutenzione;
	private int durata_in_giorni;

	// Definizione costruttore
	public Manutenzione(Mezzi mezzo, Tipo_manutenzione tipo_manutenzione, LocalDate inizio_manutenzione) {
		this.mezzo = mezzo;
		this.tipo_manutenzione = tipo_manutenzione;
		this.inizio_manutenzione = inizio_manutenzione;
	}

	@Override
	public String toString() {
		return "Manutenzione [Codice Manutenzione = " + codice_manutenzione + ", Tipo Manutenzione = "
				+ tipo_manutenzione + ", Descrizione = " + descrizione + ", Inizio Manutenzione = "
				+ inizio_manutenzione + ", Fine Manutenzione=" + fine_manutenzione + ", Durata In Giorni="
				+ durata_in_giorni + "]";
	}

}
