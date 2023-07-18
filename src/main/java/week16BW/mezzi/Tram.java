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
@DiscriminatorValue("Tram")
public class Tram extends Mezzi {
	public Tram(Stato stato) {
		super(stato);
		this.setCapienza(100);
	}

}
