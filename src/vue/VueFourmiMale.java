package vue;

import java.awt.Color;

/**
 * Classe permettant de gérer le composant graphique d'une fourmi sexuée mâle et de le séparer de
 * son modèle (classe Male).
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public class VueFourmiMale extends VueFourmiAdulte {

  /**
   * Permet de créer le composant graphique représentant une fourmi sexuée mâle et de la faire
   * apparaitre dans la fourmilière.
   * 
   * @param laVueDeLaFourmiliere La fourmilière dans laquelle la fourmi sexuée mâle doit apparaitre.
   */
  public VueFourmiMale(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.blue);
  }

}
