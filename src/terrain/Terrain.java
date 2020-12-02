package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;

public class Terrain {
  Fourmiliere laFourmiliere;
  
  public Terrain() {
    Fourmi reine = new Fourmi();
    this.laFourmiliere = new Fourmiliere(reine);
    reine.setLaFourmiliere(laFourmiliere);
    Adulte adulte = new Adulte();
    adulte.setLaFourmi(reine);
    // La reine est une femelle
    this.laFourmiliere.incrementerNombreFemelles();
    adulte.setLeRole(new Reine(adulte));
    reine.setlEtape(adulte);
  }

  public void step() {
    this.laFourmiliere.step();
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }
}
