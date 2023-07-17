package TesseraUtente;

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
	protected int codiceTessera;
	protected String nome;
	protected String cognome;
	protected LocalDate dataNascita;
	protected LocalDate emissioneTessera;
	protected LocalDate scadenzaTessera;
	

	@OneToOne(mappedBy = "tessera")
	protected Utente utente;

	public Tessera(String nome, String cognome, LocalDate dataNascita, LocalDate emissioneTessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.emissioneTessera = emissioneTessera;
		this.scadenzaTessera = this.emissioneTessera.plusDays(365);
	}

	@Override
	public String toString() {
		return "Tessera [nome=" + nome + ", cognome=" + cognome + ", data di nascita=" + dataNascita
				+ ", Codice Tessera=" + codiceTessera + ", emissione della Tessera=" + emissioneTessera 
				+ ", scadenza della Tessera=" + scadenzaTessera + "]" + "\n";
	}
}

