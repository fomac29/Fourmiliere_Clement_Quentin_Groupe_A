package terrain;

import vue.VueProie;

 /**
 * Représente les proies des fourmis.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Proie {
  
  private VueProie composantGraphique;
  private Fourmiliere laFourmiliere;
  
  public Proie(Fourmiliere fourmiliere) {
    this.laFourmiliere = fourmiliere;
    this.composantGraphique = new VueProie(this.laFourmiliere.getLeTerrain().getLaVueTerrain());
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
