package vue;

import java.awt.Color;

/**
 * Classe permettant de gerer le composant graphique d'une fourmi soldat et de le separer de son
 * modele (classe Soldat).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class VueSoldat extends VueFourmiAdulte {
  /**
   * Permet de creer le composant graphique representant une fourmi soldat et de la faire apparaitre
   * dans la fourmiliere.
   * 
   * @param laVueDeLaFourmiliere La fourmiliere dans laquelle la fourmi soldat doit apparaitre.
   */
  public VueSoldat(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.darkGray);
  }

}
