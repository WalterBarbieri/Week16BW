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
@Table(name = "utenti")
@Getter
@Setter
@NoArgsConstructor
public class Utente {
	@Id
	@SequenceGenerator(name = "sequence1", sequenceName = "sequence1", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence1")
	private Long id;
//	private int codice_tessera;
	private String nome;
	private String cognome;
	private LocalDate data_nascita;

	@OneToOne
	private Tessera codice_tessera;

	public Utente(String nome, String cognome, LocalDate data_nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.data_nascita = data_nascita;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ",\n cognome=" + cognome + ",\n data di nascita=" + data_nascita
				+ ",\n Codice della Tessera=" + codice_tessera + "]" + "\n";
	}
}

