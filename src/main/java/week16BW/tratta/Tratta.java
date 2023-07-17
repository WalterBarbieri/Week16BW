package week16BW.tratta;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.mezzi.Mezzi;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tratta {
	@Id
	@GeneratedValue
	private long codiceTratta;
	private String partenza;
	private String capolinea;
	private Double tMedio;
	private Double tEffettivo;
	@OneToMany(mappedBy = "tratta")
	private List<Mezzi> mezzi;

	public Tratta(String partenza, String capolinea, Double tMedio, Double tEffettivo) {
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.tMedio = tMedio;
		this.tEffettivo = tEffettivo;
	}

}
