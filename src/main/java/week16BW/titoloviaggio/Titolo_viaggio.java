package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
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
}