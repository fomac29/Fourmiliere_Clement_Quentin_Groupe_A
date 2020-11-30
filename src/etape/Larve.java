package etape;

/**
 * Deuxième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Larve extends Etape {
	
	public Etape next() {
		return new Nymphe();
	}

	@Override
	public void step() {
		this.next();
	}
}
