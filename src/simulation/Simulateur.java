package simulation;

import terrain.Terrain;

public class Simulateur {
	Terrain leTerrain;

	public void step() {
		this.leTerrain.step();
	}

	public void demarrer() {
		while(true) {
			this.leTerrain.step();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
	}
}