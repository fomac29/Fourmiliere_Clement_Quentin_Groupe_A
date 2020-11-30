package terrain;

import java.util.List;

import role.Reine;

public class Fourmiliere {
	List<Fourmi> lesFourmis;
	
	public void step() {
		for(Fourmi uneFoumi : this.lesFourmis) {
			uneFoumi.step();
		}
	}
}
