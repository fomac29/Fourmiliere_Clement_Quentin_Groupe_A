package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Troisième étape de la vie d'une foumi
 * 
 * @author Clément Stoliaroff
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
   * Décrémente le temps restant et passe à l'étape d'adulte si celui-ci est écoulé
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
