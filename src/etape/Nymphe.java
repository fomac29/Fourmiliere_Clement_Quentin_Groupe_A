package etape;

/**
 * Troisième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Nymphe extends Etape {

	public Etape next() {
		return new Adulte();
	}
	
	@Override
	public void step() {
		this.next();
	}
}
