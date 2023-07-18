package week16BW.mezzi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@DiscriminatorValue("Autobus")
public class Autobus extends Mezzi {
	public Autobus(Stato stato) {
		super(stato);
		this.setCapienza(50);
	}

}
