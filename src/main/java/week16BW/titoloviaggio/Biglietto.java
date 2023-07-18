package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.emettitori.Emettitore;
import week16BW.mezzi.Mezzi;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Biglietto extends Titolo_viaggio {
	// Definizione attributi
	@ManyToOne
	@JoinColumn(name = "emettitore_id", referencedColumnName = "codice_emettitore")
	private Emettitore emettitore;

	@ManyToOne
	@JoinColumn(name = "mezzo_id", referencedColumnName = "codice_mezzo")
	private Mezzi mezzo;

	// Definizione costruttore
	public Biglietto(LocalDate data_emissione) {
		super(data_emissione);
	}

}
