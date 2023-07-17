package week16BW.entities;

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
	private long codiceUnivoco;
	private LocalDate dataEmissione;
	private boolean active;
	private LocalDate dataObliterazione;
}