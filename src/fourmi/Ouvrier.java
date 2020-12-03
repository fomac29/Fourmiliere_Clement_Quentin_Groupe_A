package fourmi;

import etape.Adulte;

/**
 * Représente une fourmi ouvrière
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Ouvrier extends Role {

  public Ouvrier(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se déplace aléatoirement
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.getLaFourmi().getLaFourmiliere().decrementerNombreOuvriers();
      this.lAdulte.mourir();
    }
  }

}
