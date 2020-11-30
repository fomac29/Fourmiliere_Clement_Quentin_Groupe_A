package etape;

/**
 * Premiere étape de la vie d'une fourmi
 * @author Clément Stoliaroff
 *
 */
public class Oeuf extends Etape {

	@Override
	public Etape next() {
		return new Larve();
	}

}
