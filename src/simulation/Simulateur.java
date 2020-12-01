package simulation;

import terrain.Terrain;

public class Simulateur implements Runnable {
	Terrain leTerrain;

	public void step() {
		this.leTerrain.step();
	}

	@Override
	public void run() {
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