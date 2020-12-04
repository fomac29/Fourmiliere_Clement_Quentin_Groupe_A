package terrain;

import vue.VueProie;

/**
 * Represente les proies des fourmis.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
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
   * Deplace la proie aleatoirement dans la fenetre d'application
   */
  public void deplacerComposantProie() {
    composantGraphique.seDeplacer();
  }

}
