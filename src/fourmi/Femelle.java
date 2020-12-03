package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueFourmiFemelle;

public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueFourmiFemelle(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreFemelles();
    }
    
    else {
      this.lAdulte.deplacerFourmi();
    }
  }

  public void devenirReine() {
    this.lAdulte.setLeRole(new Reine(super.lAdulte));
  }
}
