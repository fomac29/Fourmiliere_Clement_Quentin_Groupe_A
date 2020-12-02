package fourmi;

import etape.Adulte;

public class Soldat extends Role {

  public Soldat(Adulte adulte) {
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

}
