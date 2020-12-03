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
    fenetre = new GSpace("Terrain", new Dimension(550, 550));
    fenetre.open();
  }


  /**
   * Ajoute le terrain à la fenêtre d'application.
   */
  public void ajouterTerrain() {
    terrain = new GBounded();
    terrain.setColor(Color.green);
    terrain.setPosition(new Point(30, 30));
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
   * Rafaichit l'affichage le rectangle du terrain afin que les composant à l'intérieur soient
   * actualisés
   */
  public void raffraichir() {
    this.terrain.repaint();
  }

  /**
   * Supprime graphiquement la fourmilière du terrain.
   * 
   * @param composantGraphiqueFourmi Le cercle représentant la fourmi à supprimer.
   */
  public void supprimerFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.removeElement(composantGraphiqueFourmi);
  }

  public void ajouterProie(GRect composantGraphiqueProie) {
    this.fenetre.addElement(composantGraphiqueProie);
    composantGraphiqueProie.repaint();
  }

  public void supprimerProie(GRect composantGraphiqueProie) {
    this.terrain.removeElement(composantGraphiqueProie);
  }

  /**
   * Permet d'accéder à la référence du composant graphique représentant le terrain.
   * 
   * @return Le rectangle représentant le terrain.
   */
  public GBounded getTerrain() {
    return terrain;
  }

  /**
   * Permet de connaitre la hauteur du composant graphique représentant le terrain.
   * 
   * @return La hauteur du rectangle représenannt le terrain
   */
  public int getHauteurTerrain() {
    return hauteurTerrain;
  }

  /**
   * Permet de connaitre la largeur du composant graphique représentant le terrain.
   * 
   * @return La largeur du rectangle représenannt le terrain
   */
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
