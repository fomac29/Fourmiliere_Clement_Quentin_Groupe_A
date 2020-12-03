package vue;

import java.awt.Dimension;
import java.util.Random;
import graphicLayer.GOval;

/**
 * Classe permettant de gérer les composants graphiques des fourmis Adultes et de les séparer de
 * leurs modèles.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 *
 */
public abstract class VueFourmiAdulte {
  /**
   * Cercle représentant la fourmi
   */
  protected GOval composantGraphique;

  /**
   * Reférence vers la représentation graphique de la fourmilière.
   */
  protected VueFourmiliere laVueDeLaFourmiliere;

  /**
   * Créé la représentation graphique d'une fourmi adulte et la fait apparaitre au milieu de la
   * fourmilière.
   * 
   * @param laVueDeLaFourmiliere la représentation graphique de la fourmilière dans laquelle
   *        apparait la fourmi adulte.
   */
  public VueFourmiAdulte(VueFourmiliere laVueDeLaFourmiliere) {
    this.laVueDeLaFourmiliere = laVueDeLaFourmiliere;
    this.composantGraphique = new GOval();
    this.composantGraphique.setDimension(new Dimension(6, 6));
    this.laVueDeLaFourmiliere.ajouterFourmi(this.composantGraphique);
  }

  /**
   * Permet à une fourmi de se déplacer, au hasard, en haut, en bas, à gauche ou à droite
   */
  public void seDeplacer() {
    // On créé le générateur de nombre aléatoire
    Random random = new Random();

    // On génère un nombre aléatoire entre 1 et 4
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      // Si c'est 0, on va à droite
      int posX = this.composantGraphique.getX() + 10;
      if (this.verifierPositionX(posX)) {
        this.composantGraphique.setX(posX);
      }
    } else if (unNombreAleatoire == 1) {
      // Si c'est 1, on va à gauche
      int posX = this.composantGraphique.getX() - 10;
      if (this.verifierPositionX(posX)) {
        this.composantGraphique.setX(posX);
      }
    } else if (unNombreAleatoire == 2) {
      // Si c'est 2, on va en bas
      int posY = this.composantGraphique.getY() + 10;
      if (this.verifierPositionY(posY)) {
        this.composantGraphique.setY(posY);
      }
    } else if (unNombreAleatoire == 3) {
      // Si c'est 3, on va en haut
      int posY = this.composantGraphique.getY() - 10;
      if (this.verifierPositionY(posY)) {
        this.composantGraphique.setY(posY);
      }
    }
  }

  /**
   * Vérifie si la fourmi peut se déplacer vers la gauche ou la droite sans sortir du territoire
   * 
   * @param pos la future position de la fourmi après son déplacement
   * @return Vrai si la fourmi peut se déplacer sans sortir du terrain, faux sinon.
   */
  public boolean verifierPositionX(int pos) {
    return (pos > 0 && pos < (this.laVueDeLaFourmiliere.getLaVueTerrain().getLargeurTerrain()
        - this.composantGraphique.getWidth()));
  }

  /**
   * Vérifie si la fourmi peut se déplacer vers le haut ou le bas sans sortir du territoire
   * 
   * @param pos la future position de la fourmi après son déplacement
   * @return Vrai si la fourmi peut se déplacer sans sortir du terrain, faux sinon.
   */
  public boolean verifierPositionY(int pos) {
    return (pos > 0 && pos < (this.laVueDeLaFourmiliere.getLaVueTerrain().getHauteurTerrain()
        - this.composantGraphique.getHeight()));
  }

  /**
   * Fait disparaitre la représentation graphique de la fourmi
   */
  public void supprimerFourmi() {
    this.laVueDeLaFourmiliere.getLaVueTerrain().supprimerFourmi(composantGraphique);
  }

  /**
   * Permet d'accéder à la référence du composant graphique représentant la fourmi adulte.
   * 
   * @return Le cercle représentant la fourmi adulte.
   */
  public GOval composantGraphique() {
    return this.composantGraphique;
  }

  /**
   * Permet de modifier le composant graphique représentant la fourmi adulte.
   * 
   * @param composantGraphique Le nouveau cercle devant représenter la fourmi adulte.
   */
  public void setComposantGraphique(GOval composantGraphique) {
    this.composantGraphique = composantGraphique;
  }
}
