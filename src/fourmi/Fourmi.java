package fourmi;

import etape.Etape;
import etape.Oeuf;

public class Fourmi {
  Etape lEtape;

  public Fourmi() {
    this.lEtape = new Oeuf(this);
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
