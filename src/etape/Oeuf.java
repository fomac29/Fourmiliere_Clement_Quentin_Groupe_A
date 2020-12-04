package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Premiere etape de la vie d'une fourmi
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class Oeuf extends Etape {
  /**
   * Temps restant avant que l'oeuf ne devienne une larve.
   */
  private int tempsRestant = 3;
  
  public Oeuf(Fourmi uneFourmi) {
    super(uneFourmi);
  }

  /**
   * Decremente le temps restant et passe a l'etape de larve si celui-ci est ecoule
   */
  public void next() {
    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      super.laFourmi.setlEtape(new Larve(super.laFourmi));
      Fourmiliere laFourmiliere = this.laFourmi.getLaFourmiliere();
      laFourmiliere.decrementerNombreOeufs();
    }
  }

  @Override
  public void step() {
    this.next();
  }
}
