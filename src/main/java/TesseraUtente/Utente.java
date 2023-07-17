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
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
	@Id
	@SequenceGenerator(name = "sequence1", sequenceName = "sequence1", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence1")
	protected int codiceTessera;
	protected String nome;
	protected String cognome;
	protected LocalDate dataNascita;

	@OneToOne
	protected Tessera tessera;

	public Utente(String nome, String cognome, LocalDate dataNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", data di nascita=" + dataNascita
				+ ", Codice della Tessera=" + codiceTessera + "]" + "\n";
	}
}

