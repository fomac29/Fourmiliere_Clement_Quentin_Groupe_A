package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;
import vue.VueTerrain;

public class Terrain {
  private VueTerrain laVueTerrain;
  private Fourmiliere laFourmiliere;
  private int jourCourant;
  
  public Terrain() {
    this.laVueTerrain = new VueTerrain();
    this.jourCourant = 0;
    Fourmi reine = new Fourmi();
    this.laFourmiliere = new Fourmiliere(reine);
    this.laFourmiliere.setLeTerrain(this);
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
    this.jourCourant++;
  }

  public boolean isPrintemps() {
    int jourDeLAnnee = this.jourCourant % 365;
    return jourDeLAnnee <= 90;
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }

  public VueTerrain getLaVueTerrain() {
    return laVueTerrain;
  }
  
  
}
