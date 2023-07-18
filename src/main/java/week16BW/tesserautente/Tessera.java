package week16BW.tesserautente;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tessere")
@Getter
@Setter
@NoArgsConstructor
public class Tessera {
	@Id
	@SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private int codice_tessera;
	private String nome;
	private String cognome;
	private LocalDate emissione_tessera;
	private LocalDate scadenza_tessera;
	

	@OneToOne(mappedBy = "codice_tessera")
	private Utente utente;

	public Tessera(String nome, String cognome, LocalDate emissione_tessera, Utente utente) {
		this.utente = utente;
		this.nome = nome;
		this.cognome = cognome;
		this.emissione_tessera = emissione_tessera;
		this.scadenza_tessera = this.emissione_tessera.plusDays(365);
	}

	@Override
	public String toString() {
		return "Tessera [nome=" + nome + ",\n cognome=" + cognome + ",\n Codice Tessera=" + codice_tessera
				+ ",\n emissione della Tessera=" + emissione_tessera + ", \n scadenza della Tessera=" + scadenza_tessera
				+ "]" + "\n";
	}
}

