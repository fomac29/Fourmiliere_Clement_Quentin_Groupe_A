package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Reine extends Femelle {

  public Reine(Adulte lAdulte) {
    super(lAdulte);
  }

  @Override
  public void step() {
    this.pondre();
  }

  protected void pondre() {
    Fourmiliere fourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
    Fourmi laFourmi = new Fourmi();
    laFourmi.setLaFourmiliere(fourmiliere);
    fourmiliere.ajouterFourmi(laFourmi);
  }
}
