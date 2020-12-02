package fourmi;

import etape.Adulte;

public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      Fourmi laFourmi = this.lAdulte.getLaFourmi();
      laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
      System.err.println("Mâle mort");
    }
  }

}
