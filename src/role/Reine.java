package role;

import terrain.Fourmiliere;

public class Reine extends Femelle {
	Fourmiliere laFourmiliere;
	
	public Reine(Fourmiliere uneFourmiliere) {
		this.laFourmiliere = uneFourmiliere;
	}

	@Override
	public void step() {
		this.pondre();
	}
	
	public void pondre() {
		this.laFourmiliere.ajouterFourmi(new Fourmi());
	}
}
