package vue;

import java.awt.Color;

/**
 * Classe permettant de gerer le composant graphique de la reine des fourmis et de la separer de
 * son modele (classe Reine).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class VueFourmiReine extends VueFourmiAdulte {
  
  /**
   * Permet de creer le composant graphique representant de la reine des fourmis et de la faire
   * apparaitre dans la fourmiliere.
   * 
   * @param laVueDeLaFourmiliere La fourmiliere dans laquelle la reine des fourmis doit apparaitre.
   */
  public VueFourmiReine(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.CYAN);
  }
}
