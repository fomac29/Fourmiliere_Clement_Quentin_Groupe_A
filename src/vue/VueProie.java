package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GRect;

/**
 * Classe permettant de gérer les composants graphiques d'une proie et de les séparer de son modèle
 * (classe Proie).
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public class VueProie {
  /**
   * Rectangle représentant une proie
   */
  private GRect composantProie;

  /**
   * La vue du terrain contient la référence de la fenêtre d'application
   */
  private VueTerrain laVueTerrain;

  /**
   * Créé la composant graphique de la proie et l'ajoute à la fenêtre d'application
   * 
   * @param vueTerrain La vue du terrain contenant la référence de la fenêtre d'application
   */
  public VueProie(VueTerrain vueTerrain) {
    this.laVueTerrain = vueTerrain;

    this.composantProie = new GRect();
    this.composantProie.setColor(Color.RED);
    this.composantProie.setDimension(new Dimension(6, 6));
    this.placerProie();
    this.laVueTerrain.ajouterProie(this.composantProie);
  }

  /**
   * Place la proie sur un coté du terrain en fonction d'une valeur aléatoire.
   */
  public void placerProie() {
    int valeurX, valeurY;
    
    Random random = new Random();
    int valeurAleatoire = random.nextInt(4);

    // haut du terrain
    if (valeurAleatoire == 0) {
      valeurX = random.nextInt(laVueTerrain.getLargeurTerrain());
      valeurY = 0;
      // droite du terrain
    } else if (valeurAleatoire == 1) {
      valeurX = laVueTerrain.getLargeurTerrain();
      valeurY = random.nextInt(laVueTerrain.getHauteurTerrain());
      // bas du terrain
    } else if (valeurAleatoire == 2) {
      valeurX = random.nextInt(laVueTerrain.getLargeurTerrain());
      valeurY = laVueTerrain.getHauteurTerrain();
      // gauche du terrain
    } else {
      valeurX = 0;
      valeurY = random.nextInt(laVueTerrain.getHauteurTerrain());
    }

    composantProie.setPosition(new Point(valeurX, valeurY));
  }

  /**
   * Déplace la proie en fonction d'une valeur aléatoire et supprime la proie si elle se déplace en
   * dehors de la fenêtre d'application.
   */
  public void seDeplacer() {
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      // On se déplace à droite
      int posX = this.composantProie.getX() + 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      } else {
        // On supprime la proie si elle sort de la fenêtre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 1) {
      // On se déplace à gauche
      int posX = this.composantProie.getX() - 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      } else {
        // On supprime la proie si elle sort de la fenêtre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 2) {
      // On se déplace en bas
      int posY = this.composantProie.getY() + 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      } else {
        // On supprime la proie si elle sort de la fenêtre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 3) {
      // On se déplace en haut
      int posY = this.composantProie.getY() - 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      } else {
        // On supprime la proie si elle sort de la fenêtre d'application
        this.supprimerProie();
      }
    }
  }

  /**
   * Vérifie si le composant ne dépasse pas horizontalement de 50 pixels du terrain.
   * 
   * @param pos la future position de la proie après son déplacement à droite ou à gauche
   * @return Vrai si la proie ne s'apprête pas à sortir de la fenêtre, faux sinon.
   */
  public boolean verifierPositionX(int pos) {
    return pos < (laVueTerrain.getLargeurFenetre() + 50);
  }

  /**
   * Vérifie si le composant ne dépasse pas verticalement de 50 pixels du terrain.
   * 
   * @param pos la future position de la proie après son déplacement à droite ou à gauche
   * @return Vrai si la proie ne s'apprête pas à sortir de la fenêtre, faux sinon.
   */
  public boolean verifierPositionY(int pos) {
    return pos < (laVueTerrain.getHauteurFenetre() + 50);
  }

  /**
   * Supprime le rectangle représentant la proie de la fenêtre d'application
   */
  public void supprimerProie() {
    laVueTerrain.supprimerProie(composantProie);
  }
}
