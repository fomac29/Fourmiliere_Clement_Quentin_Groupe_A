package etape;

import fourmi.Fourmi;

/**
 * Deuxième étape de la vie d'une foumi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Larve extends Etape {
  public Larve(Fourmi uneFourmi) {
    super(uneFourmi);
  }

  int tempsRestant = 10;

  public void next() {

    this.tempsRestant = this.tempsRestant - 1;
    if (this.tempsRestant == 0) {
      super.laFourmi.setlEtape(new Nymphe(super.laFourmi));
    }
  }

  @Override
  public void step() {
    this.next();
  }
}