package Emettitori;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "emettitori")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_emettitore")
@Getter
@Setter
@NoArgsConstructor
public class Emettitore {
	@Id
	@SequenceGenerator(name = "sequence2", sequenceName = "sequence2", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence2")
	protected int codiceEmettitore;

	@Override
	public String toString() {
		return "Emettitore [codiceEmettitore=" + codiceEmettitore + "]" + "\n";
	}
}
