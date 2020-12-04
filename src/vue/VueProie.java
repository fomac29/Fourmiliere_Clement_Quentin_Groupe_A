package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GRect;

/**
 * Classe permettant de gerer les composants graphiques d'une proie et de les separer de son modele
 * (classe Proie).
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class VueProie {
  /**
   * Rectangle representant une proie
   */
  private GRect composantProie;

  /**
   * La vue du terrain contient la reference de la fenetre d'application
   */
  private VueTerrain laVueTerrain;

  /**
   * Cree la composant graphique de la proie et l'ajoute a la fenetre d'application
   * 
   * @param vueTerrain La vue du terrain contenant la reference de la fenetre d'application
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
   * Place la proie sur un cote du terrain en fonction d'une valeur aleatoire.
   */
  public void placerProie() {
    int valeurX, valeurY;

    Random random = new Random();
    int valeurAleatoire = random.nextInt(4);

    // haut du terrain
    if (valeurAleatoire == 0) {
      valeurX = random.nextInt(laVueTerrain.getLargeurFenetre());
      valeurY = 0;
      // droite du terrain
    } else if (valeurAleatoire == 1) {
      valeurX = laVueTerrain.getLargeurFenetre();
      valeurY = random.nextInt(laVueTerrain.getHauteurFenetre());
      // bas du terrain
    } else if (valeurAleatoire == 2) {
      valeurX = random.nextInt(laVueTerrain.getLargeurFenetre());
      valeurY = laVueTerrain.getHauteurTerrain();
      // gauche du terrain
    } else {
      valeurX = 0;
      valeurY = random.nextInt(laVueTerrain.getHauteurFenetre());
    }

    composantProie.setPosition(new Point(valeurX, valeurY));
  }

  /**
   * Deplace la proie en fonction d'une valeur aleatoire et supprime la proie si elle se deplace en
   * dehors de la fenetre d'application.
   */
  public void seDeplacer() {
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      // On se deplace a droite
      int posX = this.composantProie.getX() + 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      } else {
        // On supprime la proie si elle sort de la fenetre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 1) {
      // On se deplace a gauche
      int posX = this.composantProie.getX() - 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      } else {
        // On supprime la proie si elle sort de la fenetre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 2) {
      // On se deplace en bas
      int posY = this.composantProie.getY() + 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      } else {
        // On supprime la proie si elle sort de la fenetre d'application
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 3) {
      // On se deplace en haut
      int posY = this.composantProie.getY() - 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      } else {
        // On supprime la proie si elle sort de la fenetre d'application
        this.supprimerProie();
      }
    }
  }

  /**
   * Verifie si le composant ne depasse pas horizontalement de 50 pixels du terrain.
   * 
   * @param pos la future position de la proie apres son deplacement a droite ou a gauche
   * @return Vrai si la proie ne s'apprete pas a sortir de la fenetre, faux sinon.
   */
  public boolean verifierPositionX(int pos) {
    return pos < (laVueTerrain.getLargeurFenetre() + 50);
  }

  /**
   * Verifie si le composant ne depasse pas verticalement de 50 pixels du terrain.
   * 
   * @param pos la future position de la proie apres son deplacement a droite ou a gauche
   * @return Vrai si la proie ne s'apprete pas a sortir de la fenetre, faux sinon.
   */
  public boolean verifierPositionY(int pos) {
    return pos < (laVueTerrain.getHauteurFenetre() + 50);
  }

  /**
   * Supprime le rectangle representant la proie de la fenetre d'application
   */
  public void supprimerProie() {
    laVueTerrain.supprimerProie(composantProie);
  }
}
