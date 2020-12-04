package fourmi;

import etape.Adulte;

/**
 * Represente une fourmi sexuee femelle
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se deplace aleatoirement
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.getLaFourmi().getLaFourmiliere().decrementerNombreFemelles();
      this.lAdulte.mourir();
    }
  }
}
