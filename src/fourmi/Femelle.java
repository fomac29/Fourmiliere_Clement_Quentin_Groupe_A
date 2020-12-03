package fourmi;

import etape.Adulte;

/**
 * Représente une fourmi sexuée femelle
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se déplace aléatoirement
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
