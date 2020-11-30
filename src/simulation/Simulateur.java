package simulation;

import terrain.Fourmiliere;

public class Simulateur {
	Fourmiliere laFourmiliere;
	
	public void step() {
		this.laFourmiliere.step();
	}
}
