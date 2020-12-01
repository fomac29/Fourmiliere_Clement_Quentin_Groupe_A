package terrain;

import java.util.ArrayList;
import java.util.List;

import role.Fourmi;

public class Fourmiliere {
	List<Fourmi> lesFourmis;
	
	public Fourmiliere(Fourmi reine) {
		this.lesFourmis = new ArrayList<Fourmi>();
		this.lesFourmis.add(reine);
	}
	
	public void step() {
		for(Fourmi uneFoumi : this.lesFourmis) {
			uneFoumi.step();
		}
	}
	
	public void ajouterFourmi(Fourmi uneFourmi) {
		this.lesFourmis.add(uneFourmi);
	}
}
