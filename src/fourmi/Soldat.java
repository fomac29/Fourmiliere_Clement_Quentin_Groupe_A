package fourmi;

import etape.Adulte;
import vue.VueSoldat;

/**
 * Represente une fourmi soldat
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Soldat extends Role {

  public Soldat(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueSoldat(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se deplace aleatoirement
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.getLaFourmi().getLaFourmiliere().decrementerNombreSoldats();
      this.lAdulte.mourir();
    }
    else {
      this.lAdulte.deplacerComposantFourmi();
    }
  }

}
