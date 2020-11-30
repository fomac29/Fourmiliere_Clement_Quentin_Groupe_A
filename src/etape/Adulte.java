package etape;

/**
 * Quatrième et étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {

	@Override
	public Etape next() {
		return this;
	}

}
