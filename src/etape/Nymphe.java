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
  }

  int tempsRestant = 10;

  public void next() {
    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      super.laFourmi.setlEtape(new Adulte(super.laFourmi));
      super.laFourmi.getLaFourmiliere().incrementerNombreNymphes();
      super.laFourmi.getLaFourmiliere().decrementerNombreLarves();
    }
  }

  @Override
  public void step() {
    this.next();
  }
}
