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
 * Representation graphique du terrain dans lequel les fourmis peuvent se deplacer ainsi que la
 * fenetre d'application.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class VueTerrain {
  /**
   * Hauteur du rectangle qui represente le terrain.
   */
  private final int hauteurTerrain = 500;

  /**
   * Largeur du rectangle qui represente le terrain.
   */
  private final int largeurTerrain = 500;

  /**
   * La fenetre d'application qui contient le terrain.
   */
  private GSpace fenetre;

  /**
   * Rectangle representant le terrain qui contiendra les elements graphiques (fourmis, proies,
   * etc...).
   */
  private GBounded terrain;

  /**
   * Cree et ouvre la fenetre d'application.
   */
  public VueTerrain() {
    fenetre = new GSpace("Terrain", new Dimension(1000, 1000));
    fenetre.setColor(Color.white);
    fenetre.open();
  }


  /**
   * Ajoute le terrain a la fenetre d'application.
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
   * Ajoute graphiquement la fourmiliere sur le terrain.
   * 
   * @param composantGraphiqueFourmiliere Rectangle representant la fourmiliere.
   */
  public void ajouterFourmiliere(GRect composantGraphiqueFourmiliere) {
    this.terrain.addElement(composantGraphiqueFourmiliere);
  }

  /**
   * Ajoute graphiquement une fourmi sur le terrain.
   * 
   * @param composantGraphiqueFourmi Cercle representant la fourmi.
   */
  public void ajouterFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.addElement(composantGraphiqueFourmi);
  }

  /**
   * Rafraichit l'affichage de la fenetre d'application afin que les composant a l'interieur soient
   * actualises
   */
  public void rafraichir() {
    this.fenetre.repaint();
  }

  /**
   * Supprime graphiquement la fourmiliere du terrain.
   * 
   * @param composantGraphiqueFourmi Le cercle representant la fourmi a supprimer.
   */
  public void supprimerFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.removeElement(composantGraphiqueFourmi);
  }

  /**
   * Ajoute graphiquement la proie dans la fenetre d'application.
   * 
   * @param composantGraphiqueProie La proie a ajouter.
   */
  public void ajouterProie(GRect composantGraphiqueProie) {
    this.fenetre.addElement(composantGraphiqueProie);
  }

  /**
   * Supprime graphiquement la proie dans la fenetre d'application.
   * 
   * @param composantGraphiqueProie La proie a ajouter.
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
