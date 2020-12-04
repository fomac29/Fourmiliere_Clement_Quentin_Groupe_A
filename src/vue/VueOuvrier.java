package vue;

import java.awt.Color;

/**
 * Classe permettant de gérer le composant graphique d'une fourmi ouvrière et de le séparer de son
 * modèle (classe Ouvrier).
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public class VueOuvrier extends VueFourmiAdulte {
  /**
   * Permet de créer le composant graphique représentant une fourmi ouvrière et de la faire
   * apparaitre dans la fourmilière.
   * 
   * @param laVueDeLaFourmiliere La fourmilière dans laquelle la fourmi ouvrière doit apparaitre.
   */
  public VueOuvrier(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.yellow);
  }
}
