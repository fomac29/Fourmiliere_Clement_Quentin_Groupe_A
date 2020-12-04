package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Deuxieme etape de la vie d'une foumi
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class Larve extends Etape {
  public Larve(Fourmi uneFourmi) {
    super(uneFourmi);
    this.laFourmi.getLaFourmiliere().incrementerNombreLarves();
  }

  /**
   * Temps restant avant que la larve ne devienne une nymphe.
   */
  int tempsRestant = 10;
  
  /**
   * Decremente le temps restant et passe a l'etape de nymphe si celui-ci est ecoule
   */
  public void next() {
    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      this.laFourmi.setlEtape(new Nymphe(super.laFourmi));
      Fourmiliere laFourmiliere = this.laFourmi.getLaFourmiliere();
      laFourmiliere.decrementerNombreLarves();
    }
  }

  @Override
  public void step() {
    this.next();
  }
}