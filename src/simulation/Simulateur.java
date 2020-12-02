package simulation;

import fourmi.Fourmi;
import terrain.Terrain;

public class Simulateur {
  Terrain leTerrain;
  
  public Simulateur() {
    this.leTerrain = new Terrain();
  }

  public void demarrer() {
    Fourmi reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
    int nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();
    
    while (reine != null || nbNymphes != 0) {
      reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
      nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();
      System.out.println(this.leTerrain.getLaFourmiliere().toString());
      this.leTerrain.step();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Fin de la simulation (Reine morte)");
  }
}
