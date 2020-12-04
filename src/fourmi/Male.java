package fourmi;

import etape.Adulte;
import vue.VueFourmiMale;

public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueFourmiMale(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
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
    
    else {
      this.lAdulte.deplacerComposantFourmi();
    }
  }
}
