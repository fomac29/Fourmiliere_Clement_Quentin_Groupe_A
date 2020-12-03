package terrain;

import vue.VueProie;

public class Proie {
  
  private VueProie composantGraphique;
  private Fourmiliere laFourmiliere;
  
  public Proie(Fourmiliere fourmiliere) {
    this.laFourmiliere = fourmiliere;
    this.composantGraphique = new VueProie(this.laFourmiliere.getLeTerrain().getLaVueTerrain());
  }
  
  public void step() {
    this.deplacerComposantProie();
  }
  
  public void deplacerComposantProie() {
    composantGraphique.seDeplacer();
  }
  
}
