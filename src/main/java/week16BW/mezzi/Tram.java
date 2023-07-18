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
@DiscriminatorValue("Tram")
public class Tram extends Mezzi {
	public Tram(int n_tratte, Stato stato) {
		super(n_tratte, stato);
		this.setCapienza(100);
	}

}
