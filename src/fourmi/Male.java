package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueFourmiMale;

public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueFourmiMale(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreMales();
    }
    
    else {
      this.lAdulte.deplacerFourmi();
    }
  }
}
