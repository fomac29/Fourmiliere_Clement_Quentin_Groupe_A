package fourmi;

import etape.Adulte;
import vue.VueOuvrier;

public class Ouvrier extends Role {

  public Ouvrier(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueOuvrier(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
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

    else {
      this.lAdulte.deplacerComposantFourmi();
    }
  }
}
