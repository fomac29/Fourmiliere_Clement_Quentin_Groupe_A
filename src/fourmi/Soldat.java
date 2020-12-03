package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueSoldat;

public class Soldat extends Role {

  public Soldat(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueSoldat(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreSoldats();
    }
    else {
      this.lAdulte.deplacerComposantFourmi();
    }
  }

}
