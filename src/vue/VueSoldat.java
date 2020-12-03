package vue;

import java.awt.Color;

/**
 * Classe permettant de gérer le composant graphique d'une fourmi soldat et de le séparer de son
 * modèle (classe Soldat).
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public class VueSoldat extends VueFourmiAdulte {
  /**
   * Permet de créer le composant graphique représentant une fourmi soldat et de la faire apparaitre
   * dans la fourmilière.
   * 
   * @param laVueDeLaFourmiliere La fourmilière dans laquelle la fourmi soldat doit apparaitre.
   */
  public VueSoldat(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.red);
  }

}
