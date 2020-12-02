package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      Fourmi laFourmi = this.lAdulte.getLaFourmi();
      Fourmiliere laFourmiliere = laFourmi.getLaFourmiliere();
      laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
      laFourmiliere.decrementerNombreMales();
    }
  }

}
