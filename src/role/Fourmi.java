package role;

import etape.Etape;
import etape.Oeuf;

public class Fourmi {
	Etape lEtape;
	
	public Fourmi() {
		this.lEtape = new Oeuf();
	}

	public void step() {
		this.lEtape.step();
	}
}
