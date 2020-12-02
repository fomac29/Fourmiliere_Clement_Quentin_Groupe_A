package etape;

import fourmi.Fourmi;
import terrain.Fourmiliere;

/**
 * Premiere étape de la vie d'une fourmi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Oeuf extends Etape {
  
  private int tempsRestant = 3;
  
  public Oeuf(Fourmi uneFourmi) {
    super(uneFourmi);
  }


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
