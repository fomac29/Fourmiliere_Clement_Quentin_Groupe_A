package simulation;

import fourmi.Fourmi;
import terrain.Terrain;
import vue.VueTerrain;

public class Simulateur {
  private Terrain leTerrain;
  
  public Simulateur() {
    this.leTerrain = new Terrain();
  }

  public void demarrer() {
    Fourmi reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
    int nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();
    
    while (reine != null || nbNymphes != 0) {
      reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
      nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();
      //System.out.println(this.leTerrain.getLaFourmiliere().toString());
      this.leTerrain.step();
      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Fin de la simulation");
  }
}
