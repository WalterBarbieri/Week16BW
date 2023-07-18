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
	private long codice_tratta;
	private String partenza;
	private String capolinea;
	private Double t_medio;
	private Double t_effettivo;
	@OneToMany(mappedBy = "tratta")
	private List<Mezzi> mezzi;

	public Tratta(String partenza, String capolinea, Double t_medio, Double t_effettivo) {
		this.partenza = partenza;
		this.capolinea = capolinea;
		this.t_medio = t_medio;
		this.t_effettivo = t_effettivo;
	}

}
