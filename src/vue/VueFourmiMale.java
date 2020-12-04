package vue;

import java.awt.Color;

/**
 * Classe permettant de gerer le composant graphique d'une fourmi sexuee male et de le separer de
 * son modele (classe Male).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class VueFourmiMale extends VueFourmiAdulte {

  /**
   * Permet de creer le composant graphique representant une fourmi sexuee male et de la faire
   * apparaitre dans la fourmiliere.
   * 
   * @param laVueDeLaFourmiliere La fourmiliere dans laquelle la fourmi sexuee male doit apparaitre.
   */
  public VueFourmiMale(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.blue);
  }

}
