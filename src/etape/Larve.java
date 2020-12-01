package etape;

/**
 * Deuxième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Larve extends Etape {
	int tempsRestant = 10;
	
	public Etape next() {
		this.tempsRestant = this.tempsRestant - 1;
		if(this.tempsRestant == 0) {
			return new Nymphe();
		}
		
		return this;
	}

	@Override
	public void step() {
		this.next();
	}
}
