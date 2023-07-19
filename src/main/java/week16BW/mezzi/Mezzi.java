package week16BW.mezzi;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.manutenzione.Manutenzione;
import week16BW.titoloviaggio.Biglietto;
import week16BW.tratta.StoricoTratte;
import week16BW.tratta.Tratta;

@Entity
@Table(name = "mezzi")
@Getter
@Setter
@NoArgsConstructor

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "mezzi")
@NamedQuery(name = "selectAllNumeroTratte", query = "SELECT a FROM Mezzi a ")
@NamedQuery(name = "selectByCodMezzo", query = "SELECT a FROM Mezzi a WHERE codice_mezzo = :codice_mezzo")
@NamedQuery(name = "selectByCodTratta", query = "SELECT a FROM Mezzi a WHERE tratta.codice_tratta = :codice_tratta")
public abstract class Mezzi {
	@Id
	@GeneratedValue

	private long codice_mezzo;
	private int n_tratte;
	private int n_manutenzioni;
	private int capienza;
	@Enumerated(EnumType.STRING)
	private Stato stato;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	@OneToMany(mappedBy = "mezzo")
	private List<StoricoTratte> storico_tratte;

//	@OneToMany(mappedBy = "mezzo")
//	private List<Abbonamento> abbonamenti;
	@OneToMany(mappedBy = "mezzo")
	private List<Biglietto> biglietti;

	@OneToMany(mappedBy = "mezzo")
	private List<Manutenzione> storico_manutenzione;

	public Mezzi(Stato stato) {
		this.n_tratte = 0;
		this.n_manutenzioni = 0;
		this.stato = stato;
	}


	@Override
	public String toString() {
		return "Mezzo [Codice Mezzo = " + codice_mezzo + ", N. Tratte = " + n_tratte + ", Capienza = " + capienza
				+ ", Stato = " + stato + ", Tratta = " + tratta + "]";
	}

}
