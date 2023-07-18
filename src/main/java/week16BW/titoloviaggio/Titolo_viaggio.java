package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class Titolo_viaggio {
	@Id
	@GeneratedValue
	private long codice_univoco;
	private LocalDate data_emissione;
	private boolean active;
	private LocalDate data_obliterazione;

//	@ManyToOne
//	@JoinColumn(name = "emettitore_id", referencedColumnName = "codice_emettitore")
//	private Emettitore emettitore;

	public Titolo_viaggio(LocalDate data_emissione) {
		this.data_emissione = data_emissione;
	}
}