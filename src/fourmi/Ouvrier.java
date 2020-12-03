package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueOuvrier;

public class Ouvrier extends Role {

  public Ouvrier(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueOuvrier(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreOuvriers();
    }

    else {
      this.lAdulte.deplacerFourmi();
    }
  }
}
