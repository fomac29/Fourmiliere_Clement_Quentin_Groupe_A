package etape;

/**
 * Troisième  étape de la vie d'une foumi
 * @author Clément Stoliaroff
 *
 */
public class Nymphe extends Etape {
	int tempsRestant = 10;

	public Etape next() {
		this.tempsRestant = this.tempsRestant - 1;
		if(this.tempsRestant == 0) {
			return new Adulte();
		}
		
		return this;
	}
	
	@Override
	public void step() {
		this.next();
	}
}
