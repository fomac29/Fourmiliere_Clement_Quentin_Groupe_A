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

  int tempsRestant = 10;

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
