package etape;

/**
 * Troisième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Nymphe extends Etape {

	@Override
	public Etape next() {
		return new Adulte();
	}

}
