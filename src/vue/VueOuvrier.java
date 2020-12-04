package vue;

import java.awt.Color;

/**
 * Classe permettant de gerer le composant graphique d'une fourmi ouvriere et de le separer de son
 * modele (classe Ouvrier).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class VueOuvrier extends VueFourmiAdulte {
  /**
   * Permet de creer le composant graphique representant une fourmi ouvriere et de la faire
   * apparaitre dans la fourmiliere.
   * 
   * @param laVueDeLaFourmiliere La fourmiliere dans laquelle la fourmi ouvriere doit apparaitre.
   */
  public VueOuvrier(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.yellow);
  }
}
