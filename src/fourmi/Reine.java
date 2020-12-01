package fourmi;

import terrain.Fourmiliere;

public class Reine extends Femelle {
  Fourmiliere laFourmiliere;

  public Reine(Fourmi uneFourmi) {
    super(uneFourmi);
    this.laFourmiliere = null;
  }

  public void creerFourmiliere() {
    if (this.laFourmiliere == null) {
      this.laFourmiliere = new Fourmiliere(super.laFourmi);
    }
  }

  @Override
  public void step() {
    this.pondre();
  }

  protected void pondre() {
    this.laFourmiliere.ajouterFourmi(new Fourmi());
  }
}
