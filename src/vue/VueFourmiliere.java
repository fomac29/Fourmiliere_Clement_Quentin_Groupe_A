package vue;

import java.awt.Color;
import java.awt.Point;
import graphicLayer.GOval;
import graphicLayer.GRect;

/**
 * Classe permettant de gerer le composant graphique d'une fourmiliere et de le separer de son
 * modele (classe Fourmiliere).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class VueFourmiliere {
  /**
   * Le rectangle representant la fourmiliere.
   */
  private GRect composantFourmiliere;

  /**
   * Reference vers la representation graphique du terrain contenant la representation graphique de
   * la fourmiliere.
   */
  VueTerrain laVueTerrain;

  /**
   * Permet de creer la representation graphique de la fourmiliere et de l'ajouter dans la
   * representation graphique du terrain.
   * 
   * @param uneVueTerrain La representation graphique du terrain dans laquelle ajouter la
   *        representation graphique de la fourmiliere.
   */
  public VueFourmiliere(VueTerrain uneVueTerrain) {
    this.laVueTerrain = uneVueTerrain;
    this.composantFourmiliere = new GRect();
    // La fourmiliere est un carre marron (en code RGB)
    this.composantFourmiliere.setColor(new Color(88, 41, 0));
    this.placerFourmiliere();
    this.laVueTerrain.ajouterFourmiliere(this.composantFourmiliere);
  }

  /**
   * Place la fourmiliere de maniere aleatoire sur le terrain.
   */
  public void placerFourmiliere() {
    // On calcule la position de la fourmi pour qu'elle apparaisse au milieu de la fourmiliere
    int milieurHorizontal = (int) (this.laVueTerrain.getLargeurTerrain() / 2)
        - (this.composantFourmiliere.getWidth() / 2);

    int milieurVertical = (int) (this.laVueTerrain.getHauteurTerrain() / 2)
        - (this.composantFourmiliere.getHeight() / 2);

    // On place la fourmi au milieu de la fourmiliere
    composantFourmiliere.setPosition(new Point(milieurHorizontal, milieurVertical));
  }

  /**
   * Ajoute la representation graphique d'une fourmi dans la representation graphique du terrain.
   * 
   * @param laFourmi Le cercle representant la fourmi a ajouter.
   */
  public void ajouterFourmi(GOval laFourmi) {
    // On calcule la position de la fourmi pour qu'elle apparaisse au milieu de la fourmiliere
    int milieurHorizontal = (int) (this.composantFourmiliere.getX()
        + (this.composantFourmiliere.getWidth() / 2) - (laFourmi.getWidth() / 2));

    int milieurVertical = (int) (this.composantFourmiliere.getY()
        + (this.composantFourmiliere.getHeight() / 2) - (laFourmi.getHeight() / 2));

    // On place la fourmi au milieu de la fourmiliere
    laFourmi.setPosition(new Point(milieurHorizontal, milieurVertical));

    // On Fait apparaitre la fourmi sur le terrain
    this.laVueTerrain.ajouterFourmi(laFourmi);
  }

  public GRect getComposantFourmiliere() {
    return composantFourmiliere;
  }

  public VueTerrain getLaVueTerrain() {
    return this.laVueTerrain;
  }
}
