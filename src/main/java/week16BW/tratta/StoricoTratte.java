package week16BW.tratta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import week16BW.mezzi.Mezzi;

@Entity
@Table(name = "storico_tratte")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StoricoTratte {
	@Id
	@GeneratedValue
	private long codice_storico_tratte;
	private Double t_effettivo;

	@ManyToOne
	@JoinColumn(name = "codice_mezzo")
	private Mezzi mezzo;

	public StoricoTratte(Mezzi mezzo) {
		this.mezzo = mezzo;
	}

	public StoricoTratte(Double t_effettivo, Mezzi mezzo) {
		this.t_effettivo = t_effettivo;
		this.mezzo = mezzo;
	}

}
