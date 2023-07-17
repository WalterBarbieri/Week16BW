package Emettitori;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RivenditoreAutorizzato extends Emettitore {

	@Override
	public String toString() {
		return "Rivenditore Autorizzato [ codice Emettitore=" + codiceEmettitore + "]" + "\n";
	}
}
