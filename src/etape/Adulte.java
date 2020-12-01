package etape;

import role.Femelle;
import role.Male;
import role.Ouvrier;
import role.Role;
import role.Soldat;

/**
 * Quatrième et étape de la vie d'une fourmi
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {
	Role leRole;
	
	private double pourcentageDeChance(double min, double max) {
	    return (Math.random() * (max - min)) + min;
	}
	
	public Adulte() {
		/*
		 *  On tire un pourcentage entre 60% et 70% au hasard
		 *  Puis on tire un nombre au hasard : si celui-ci est inférieur
		 *  ou égal au pourcentage tiré, alors on attribut le rôle Ouvrier
		 */
		if(Math.random() <= this.pourcentageDeChance(0.6, 0.7)) {
			this.leRole = new Ouvrier();
		}
		
		// Même chose entre 20% et 25%
		else if(Math.random() <= this.pourcentageDeChance(0.2, 0.25)) {
			this.leRole = new Soldat();
		}
		
		// Sinon, c'est une fourmi sexué
		else {
			// La fourmi a 50% de chance d'être une femelle
			if(Math.random() <= 0.5) {
				this.leRole = new Femelle();
			}
			
			// Sinon c'est un mâle
			else {
				this.leRole = new Male();
			}
		}
	}

	@Override
	public void step() {
		this.leRole.step();
	}
}
