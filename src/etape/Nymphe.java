package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Troisieme etape de la vie d'une foumi
 * 
 * @author Clement Stoliaroff
 *
 */
public class Nymphe extends Etape {
  public Nymphe(Fourmi uneFourmi) {
    super(uneFourmi);
    this.laFourmi.getLaFourmiliere().incrementerNombreNymphes();
  }

  /**
   * Temps restant avant que la nymphe ne devienne une adulte.
   */
  int tempsRestant = 10;

  /**
   * Decremente le temps restant et passe a l'etape d'adulte si celui-ci est ecoule
   */
  public void next() {
    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      super.laFourmi.setlEtape(new Adulte(super.laFourmi));
      Fourmiliere laFourmiliere = this.laFourmi.getLaFourmiliere();
      laFourmiliere.decrementerNombreNymphes();
    }
  }

  @Override
  public void step() {
    this.next();
  }
}
