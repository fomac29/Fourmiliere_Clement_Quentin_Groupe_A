package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Reine extends Femelle {
  Fourmiliere laFourmiliere;

  public Reine(Adulte lAdulte) {
    super(lAdulte);
    this.laFourmiliere = null;
  }

  public void creerFourmiliere() {
    if (this.laFourmiliere == null) {
      this.laFourmiliere = new Fourmiliere(super.lAdulte.getLeRole().getlAdulte().getLaFourmi());
    }
  }

  @Override
  public void step() {
    this.pondre();
  }

  protected void pondre() {
    this.laFourmiliere.ajouterFourmi(new Fourmi(laFourmiliere));
  }
}
