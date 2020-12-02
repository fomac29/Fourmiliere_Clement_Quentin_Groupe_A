package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Soldat extends Role {

  public Soldat(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      Fourmi laFourmi = this.lAdulte.getLaFourmi();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
      laFourmiliere.decrementerNombreSoldats();
    }
  }

}
