package fourmi;

import etape.Adulte;

/**
 * Représente une fourmie sexuée mâle
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se déplace aléatoirement
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.getLaFourmi().getLaFourmiliere().decrementerNombreMales();
      this.lAdulte.mourir();
    }
  }

}
