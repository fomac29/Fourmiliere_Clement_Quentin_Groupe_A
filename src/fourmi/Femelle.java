package fourmi;

import etape.Adulte;

public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      Fourmi laFourmi = this.lAdulte.getLaFourmi();
      laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
    }
  }

  public void devenirReine() {
    this.lAdulte.setLeRole(new Reine(super.lAdulte));
  }
}
