package etape;

/**
 * Premiere étape de la vie d'une fourmi
 * @author Clément Stoliaroff
 *
 */
public class Oeuf extends Etape {

	public Etape next() {
		return new Larve();
	}

	@Override
	public void step() {
		this.next();
	}

}
