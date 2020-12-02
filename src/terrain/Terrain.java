package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;
import vue.VueTerrain;

public class Terrain {
  private Fourmiliere laFourmiliere;
  private VueTerrain laVueTerrain;
  private int jourCourant;
  
  public Terrain() {
    this.laVueTerrain = new VueTerrain();
    this.laVueTerrain.ajouterTerrain();
    
    this.jourCourant = 0;
    
    this.laFourmiliere = new Fourmiliere(this);
    Fourmi reine = new Fourmi(laFourmiliere);
    this.laFourmiliere.setLaReineDesFourmis(reine);
    
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

  public int getJourCourant() {
    return jourCourant;
  }
  
  
}
