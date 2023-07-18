package week16BW.mezzi;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.tratta.Tratta;

@Entity
@Table(name = "mezzi")
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "mezzi")
public abstract class Mezzi {
	@Id
	@GeneratedValue
	private long codice_mezzo;
	private int n_tratte;
	private int capienza;
	private Stato stato;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	public Mezzi(int n_tratte, Stato stato) {
		this.n_tratte = n_tratte;
		this.stato = stato;
	}

}
