package fourmi;

import etape.Etape;
import etape.Oeuf;
import terrain.Fourmiliere;

public class Fourmi {
  Etape lEtape;
  Fourmiliere laFourmiliere;

  public Fourmi(Fourmiliere uneFourmiliere) {
    this.lEtape = new Oeuf(this);
    this.laFourmiliere = uneFourmiliere;
  }

  public void step() {
    this.lEtape.step();
  }

  public Etape getlEtape() {
    return lEtape;
  }

  public void setlEtape(Etape lEtape) {
    this.lEtape = lEtape;
  }
}
