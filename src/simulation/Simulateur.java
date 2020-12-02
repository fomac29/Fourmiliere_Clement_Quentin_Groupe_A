package simulation;

import terrain.Terrain;

public class Simulateur {
  Terrain leTerrain;
  
  public Simulateur() {
    this.leTerrain = new Terrain();
  }

  public void demarrer() {
    while (true) {
      System.out.println(this.leTerrain.getLaFourmiliere().toString());
      this.leTerrain.step();
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
