package fourmi;

import etape.Adulte;

/**
 * Represente une fourmi ouvriere
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Ouvrier extends Role {

  public Ouvrier(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se deplace aleatoirement
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
