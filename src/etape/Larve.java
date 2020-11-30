package etape;

/**
 * Deuxième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Larve extends Etape {
	@Override
	public Etape next() {
		return new Nymphe();
	}

}
