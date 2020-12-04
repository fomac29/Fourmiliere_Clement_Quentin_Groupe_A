package fourmi;

import etape.Adulte;

/**
 * Represente une fourmie sexuee male
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se deplace aleatoirement
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
