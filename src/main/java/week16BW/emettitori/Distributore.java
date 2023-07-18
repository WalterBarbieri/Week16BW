package week16BW.emettitori;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Distributore extends Emettitore {
	protected Boolean attivo;

	public Distributore(Boolean attivo) {
		super();
		this.attivo = attivo;
	}

	@Override
	public String toString() {
		return "Distributore [ stato=" + attivo + ", codice Emettitore=" + this.getCodice_emettitore() + "]" + "\n";
	}
}
