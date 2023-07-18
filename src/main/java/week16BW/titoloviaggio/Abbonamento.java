package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.enu.Tipoabbonamento;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Abbonamento extends Titolo_viaggio {
	LocalDate data_scadenza;
	Tipoabbonamento tipo;
}
