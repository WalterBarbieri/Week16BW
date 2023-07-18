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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import week16BW.tratta.StoricoTratte;
import week16BW.tratta.Tratta;

@Entity
@Table(name = "mezzi")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "mezzi")
public abstract class Mezzi {
	@Id
	@GeneratedValue

	private long codice_mezzo;
	private int n_tratte;
	private int capienza;
	@Enumerated(EnumType.STRING)
	private Stato stato;

	@ManyToOne
	@JoinColumn(name = "codice_tratta")
	private Tratta tratta;

	@OneToMany(mappedBy = "mezzo")
	private List<StoricoTratte> storico_tratte;

	public Mezzi(Stato stato) {
		this.n_tratte = 0;
		this.stato = stato;
	}

}
