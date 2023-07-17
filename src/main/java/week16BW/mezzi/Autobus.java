package week16BW.mezzi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("Autobus")
public class Autobus extends Mezzi {
	public Autobus(int nTratte, Stato stato) {
		super(nTratte, stato);
		this.setCapienza(50);
	}

}
