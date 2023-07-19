package week16BW.emettitori;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.titoloviaggio.Abbonamento;
import week16BW.titoloviaggio.Biglietto;

@Entity
@Table(name = "emettitori")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_emettitore")
@Getter
@Setter
@NoArgsConstructor
public class Emettitore {
	@Id
	@SequenceGenerator(name = "sequence4", sequenceName = "sequence4", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence4")
	private long codice_emettitore;

//	@OneToMany(mappedBy = "emettitore")
//	private Set<Tessera> tessera;
	@OneToMany(mappedBy = "emettitore")
	private Set<Abbonamento> abbonamenti_emessi = new HashSet<>();

	@OneToMany(mappedBy = "emettitore")
	private Set<Biglietto> biglietti_emessi = new HashSet<>();

//	@OneToMany(mappedBy = "emettitore")
//	private Set<Titolo_viaggio> titoli_viaggio_emessi = new HashSet<>();

	@Override
	public String toString() {
		return "Emettitore [codiceEmettitore=" + codice_emettitore + "]" + "\n";
	}
}
