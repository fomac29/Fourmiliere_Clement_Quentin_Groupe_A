package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GRect;

public class VueProie {

  private GRect composantProie;
  private VueTerrain laVueTerrain;

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
   * 0 = haut du terrain
   * 1 = droite du terrain
   * 2 = bas du terrain
   * 3 = gauche du terrain
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
   * Déplace la proie en fonction d'une valeur aléatoire et
   * supprime la proie si elle se déplace en dehors du terrain.
   */
  public void seDeplacer() {
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      int posX = this.composantProie.getX() + 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      }else {
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 1) {
      int posX = this.composantProie.getX() - 10;
      if (this.verifierPositionX(posX)) {
        composantProie.setX(posX);
      }else {
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 2) {
      int posY = this.composantProie.getY() + 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      }else {
        this.supprimerProie();
      }
    } else if (unNombreAleatoire == 3) {
      int posY = this.composantProie.getY() - 10;
      if (this.verifierPositionX(posY)) {
        composantProie.setY(posY);
      }else {
        this.supprimerProie();
      }
    }
  }
  
  /**
   * Vérifie si le composant ne dépasse pas horizontalement de 30 pixels du terrain. 
   * @param pos
   * @return boolean
   */
  public boolean verifierPositionX(int pos) {
    return pos < (laVueTerrain.getLargeurFenetre()+50);
  }
  
  /**
   * Vérifie si le composant ne dépasse pas verticalement de 30 pixels du terrain. 
   * @param pos
   * @return boolean
   */
  public boolean verifierPositionY(int pos) {
    return pos < (laVueTerrain.getHauteurFenetre()+50);
  }
  
  public void supprimerProie() {
    laVueTerrain.supprimerProie(composantProie);
  }
}
