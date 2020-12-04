package terrain;

import vue.VueProie;

/**
 * Représente les proies des fourmis.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Proie {

  private VueProie composantGraphique;
  private Terrain leTerrain;

  public Proie(Terrain terrain) {
    this.leTerrain = terrain;
    this.composantGraphique = new VueProie(this.leTerrain.getLaVueTerrain());
  }

  /**
   * Effectue un pas de simulation pour la proie
   */
  public void step() {
    this.deplacerComposantProie();
  }

  /**
   * Déplace la proie aléatoirement dans la fenêtre d'application
   */
  public void deplacerComposantProie() {
    composantGraphique.seDeplacer();
  }

}
