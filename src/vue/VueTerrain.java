package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GBounded;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;

/**
 * Représentation graphique du terrain dans lequel les fourmis peuvent se déplacer ainsi que la
 * fenêtre d'application.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class VueTerrain {
  /**
   * Hauteur du rectangle qui représente le terrain.
   */
  private final int hauteurTerrain = 500;

  /**
   * Largeur du rectangle qui représente le terrain.
   */
  private final int largeurTerrain = 500;

  /**
   * La fenêtre d'application qui contient le terrain.
   */
  private GSpace fenetre;

  /**
   * Rectangle représentant le terrain qui contiendra les éléments graphiques (fourmis, proies,
   * etc...).
   */
  private GBounded terrain;

  /**
   * Créé et ouvre la fenêtre d'application.
   */
  public VueTerrain() {
    fenetre = new GSpace("Terrain", new Dimension(1000, 1000));
    fenetre.setColor(Color.white);
    fenetre.open();
  }


  /**
   * Ajoute le terrain à la fenêtre d'application.
   */
  public void ajouterTerrain() {
    terrain = new GBounded();
    terrain.setColor(Color.green);
    Random random = new Random();
    int x = random.nextInt(this.fenetre.getWidth() - this.getLargeurTerrain());
    int y = random.nextInt(this.fenetre.getHeight() - this.getHauteurTerrain());
    terrain.setPosition(new Point(x, y));
    terrain.setDimension(new Dimension(hauteurTerrain, largeurTerrain));

    fenetre.addElement(terrain);
  }

  /**
   * Ajoute graphiquement la fourmilière sur le terrain.
   * 
   * @param composantGraphiqueFourmiliere Rectangle représentant la fourmilière.
   */
  public void ajouterFourmiliere(GRect composantGraphiqueFourmiliere) {
    this.terrain.addElement(composantGraphiqueFourmiliere);
  }

  /**
   * Ajoute graphiquement une fourmi sur le terrain.
   * 
   * @param composantGraphiqueFourmi Cercle représentant la fourmi.
   */
  public void ajouterFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.addElement(composantGraphiqueFourmi);
  }

  /**
   * Rafraichit l'affichage de la fenêtre d'application afin que les composant à l'intérieur soient
   * actualisés
   */
  public void rafraichir() {
    this.fenetre.repaint();
  }

  /**
   * Supprime graphiquement la fourmilière du terrain.
   * 
   * @param composantGraphiqueFourmi Le cercle représentant la fourmi à supprimer.
   */
  public void supprimerFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.removeElement(composantGraphiqueFourmi);
  }

  /**
   * Ajoute graphiquement la proie dans la fenêtre d'application.
   * 
   * @param composantGraphiqueProie La proie à ajouter.
   */
  public void ajouterProie(GRect composantGraphiqueProie) {
    this.fenetre.addElement(composantGraphiqueProie);
  }

  /**
   * Supprime graphiquement la proie dans la fenêtre d'application.
   * 
   * @param composantGraphiqueProie La proie à ajouter.
   */
  public void supprimerProie(GRect composantGraphiqueProie) {
    this.fenetre.removeElement(composantGraphiqueProie);
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

  public int getLargeurFenetre() {
    return this.fenetre.getWidth();
  }

  public int getHauteurFenetre() {
    return this.fenetre.getHeight();
  }
}
