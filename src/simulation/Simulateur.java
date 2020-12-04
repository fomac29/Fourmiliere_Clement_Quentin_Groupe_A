package simulation;

import fourmi.Fourmi;
import terrain.Terrain;

/**
 * Simule les differentes etapes de vie de la fourmiliere
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Simulateur {
  Terrain leTerrain;

  /**
   * Initialise le terrain, la fourmiliere et la premiere reine des fourmis
   */
  public Simulateur() {
    this.leTerrain = new Terrain();
  }

  /**
   * Demarre la simulation
   */
  public void demarrer() {
    Fourmi reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
    int nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();

    // La simulation s'arrête quand la reine est morte et qu'il n'y a plus de nymphe
    while (reine != null || nbNymphes != 0) {
      reine = this.leTerrain.getLaFourmiliere().getLaReineDesFourmis();
      nbNymphes = this.leTerrain.getLaFourmiliere().getNombreNymphes();
      System.out.println(this.leTerrain.getLaFourmiliere().toString());
      this.leTerrain.step();

      // On effectue une pause entre chaque pas de simulation
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Fin de la simulation (Reine morte)");
  }
}
