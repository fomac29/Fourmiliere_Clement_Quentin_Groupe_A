package etape;

import fourmi.Femelle;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;
import fourmi.Soldat;

/**
 * Quatrième et étape de la vie d'une fourmi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {
  Role leRole;

  private double pourcentageDeChance(double min, double max) {
    return (Math.random() * (max - min)) + min;
  }

  public Adulte(Fourmi uneFourmi) {
    super(uneFourmi);

    /*
     * On tire un pourcentage entre 60% et 70% au hasard Puis on tire un nombre au hasard : si
     * celui-ci est inférieur ou égal au pourcentage tiré, alors on attribut le rôle Ouvrier
     */
    if (Math.random() <= this.pourcentageDeChance(0.6, 0.7)) {
      this.leRole = new Ouvrier(super.laFourmi);
    }

    // Même chose entre 20% et 25% pour les fourmis soldats
    else if (Math.random() <= this.pourcentageDeChance(0.2, 0.25)) {
      this.leRole = new Soldat(super.laFourmi);
    }

    // Sinon, c'est une fourmi sexué
    else {
      // La fourmi a 50% de chance d'être une femelle
      if (Math.random() <= 0.5) {
        this.leRole = new Femelle(super.laFourmi);
      }

      // Sinon c'est un mâle
      else {
        this.leRole = new Male(super.laFourmi);
      }
    }
  }

  public Role getLeRole() {
    return leRole;
  }

  public void setLeRole(Role leRole) {
    this.leRole = leRole;
  }

  @Override
  public void step() {
    this.leRole.step();
  }
}
