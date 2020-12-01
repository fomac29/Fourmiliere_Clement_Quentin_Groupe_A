package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;

public class Terrain {
  Fourmiliere laFourmiliere;
  
  public Terrain() {
    Fourmi reine = new Fourmi();
    
    Adulte adulte = new Adulte(reine);
    adulte.setLeRole(new Reine(adulte));
    reine.setlEtape(adulte);
    
    this.laFourmiliere = new Fourmiliere(reine);
    
    reine.setLaFourmiliere(laFourmiliere);
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
