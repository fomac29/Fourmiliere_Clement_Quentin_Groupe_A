package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Deuxième étape de la vie d'une foumi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Larve extends Etape {
  public Larve(Fourmi uneFourmi) {
    super(uneFourmi);
    this.laFourmi.getLaFourmiliere().incrementerNombreLarves();
  }

  int tempsRestant = 10;

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