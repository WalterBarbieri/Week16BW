package week16BW.titoloviaggio;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.emettitori.Emettitore;
import week16BW.enu.Tipoabbonamento;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Abbonamento extends Titolo_viaggio {
	// Definizione attributi
	LocalDate data_scadenza;
	@Enumerated(EnumType.STRING)
	Tipoabbonamento tipo;

	@ManyToOne
	@JoinColumn(name = "emettitore_id", referencedColumnName = "codice_emettitore")
	private Emettitore emettitore;

	// Definizione costruttore
	public Abbonamento(LocalDate data_emissione, Tipoabbonamento tipo_abbonamento) {
		super(data_emissione);
		this.tipo = tipo_abbonamento;
		this.data_scadenza = impostaScandenzaAbbonamento(data_emissione, tipo_abbonamento);
	}

	private LocalDate impostaScandenzaAbbonamento(LocalDate data_emissione, Tipoabbonamento tipo_abbonamento) {
		if (tipo_abbonamento == Tipoabbonamento.SETTIMANALE)
			return data_emissione.plusDays(7);
		else
			return data_emissione.plusMonths(1);
	}
}
