package etape;

/**
 * Premiere étape de la vie d'une fourmi
 * @author Clément Stoliaroff
 *
 */
public class Oeuf extends Etape {
	int tempsRestant = 3;
	
	public Etape next() {
		this.tempsRestant = this.tempsRestant - 1;
		if(this.tempsRestant == 0) {
			return new Larve();
		}
		
		return this;
	}

	@Override
	public void step() {
		this.next();
	}

}
