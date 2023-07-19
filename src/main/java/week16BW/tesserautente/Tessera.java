package week16BW.tesserautente;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import week16BW.emettitori.Emettitore;
import week16BW.titoloviaggio.Abbonamento;

@Entity
@Table(name = "tessere")
@Getter
@Setter
@NoArgsConstructor
public class Tessera {
	@Id
	@SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	private long codice_tessera;
//	private String nome;
//	private String cognome;
	private LocalDate emissione_tessera;
	private LocalDate scadenza_tessera;
	
	@OneToOne
	private Utente utente;

	@ManyToOne
	@JoinColumn(name = "tessera_emettitore", referencedColumnName = "codice_emettitore")
	private Emettitore emettitore;

	@OneToMany(mappedBy = "tessera")
	private Set<Abbonamento> abbonamento = new HashSet<>();

	public Tessera(LocalDate emissione_tessera, Utente utente, Emettitore emettitore) {
		this.utente = utente;
//		this.nome = nome;
//		this.cognome = cognome;
		this.emissione_tessera = emissione_tessera;
		this.scadenza_tessera = this.emissione_tessera.plusDays(365);
		this.emettitore = emettitore;
	}

	@Override
//	public String toString() {
//		return "Tessera [nome=" + nome + ",\n cognome=" + cognome + ",\n Codice Tessera=" + codice_tessera
//				+ ",\n emissione della Tessera=" + emissione_tessera + ", \n scadenza della Tessera=" + scadenza_tessera
//				+ "]" + "\n";
//	}
	public String toString() {
		return "Tessera [ Codice Tessera=" + codice_tessera
				+ ",\n emissione della Tessera=" + emissione_tessera + ", \n scadenza della Tessera=" + scadenza_tessera
				+ "]" + "\n";
	}
}

