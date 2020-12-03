package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GBounded;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;

/**
 * Représentation graphique du terrain dans lequel les fourmis peuvent se déplacer ainsi que la
 * fenêtre d'application
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class VueTerrain {
  /**
   * Hauteur du rectangle qui représente le terrain
   */
  private final int hauteurTerrain = 500;

  /**
   * Largeur du rectangle qui représente le terrain
   */
  private final int largeurTerrain = 500;

  /**
   * Représente la fenêtre d'application
   */
  private GSpace fenetre;

  /**
   * Représente le rectangle représentant le terrain qui contiendra les éléments graphiques
   * (fourmis, proies, etc...)
   */
  private GBounded terrain;

  /**
   * 
   */
  public VueTerrain() {
    fenetre = new GSpace("Terrain", new Dimension(550, 550));
    fenetre.open();
  }

  
  public void ajouterTerrain() {
    terrain = new GBounded();
    terrain.setColor(Color.green);
    terrain.setPosition(new Point(30, 30));
    terrain.setDimension(new Dimension(hauteurTerrain, largeurTerrain));

    fenetre.addElement(terrain);
  }

  public void ajouterFourmiliere(GRect composantGraphiqueFourmiliere) {
    this.terrain.addElement(composantGraphiqueFourmiliere);
  }

  public void ajouterFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.addElement(composantGraphiqueFourmi);
    composantGraphiqueFourmi.repaint();
  }

  public void supprimerFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.removeElement(composantGraphiqueFourmi);
  }

  public GBounded getTerrain() {
    return terrain;
  }

  public int getHauteurTerrain() {
    return hauteurTerrain;
  }

  public int getLargeurTerrain() {
    return largeurTerrain;
  }
}
