package etape;

import fourmi.Fourmi;

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
    this.laFourmi.getLaFourmiliere().decrementerNombreLarves();
  }

  int tempsRestant = 10;

  public void next() {
    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      super.laFourmi.setlEtape(new Adulte(super.laFourmi));
    }
  }

  @Override
  public void step() {
    this.next();
  }
}
