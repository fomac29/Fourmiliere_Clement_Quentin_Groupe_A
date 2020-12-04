package vue;

import java.awt.Dimension;
import java.util.Random;
import graphicLayer.GOval;

/**
 * Classe permettant de gerer les composants graphiques des fourmis adultes et de les separer de
 * leurs modeles.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public abstract class VueFourmiAdulte {
  /**
   * Cercle representant la fourmi
   */
  protected GOval composantGraphique;

  /**
   * Reference vers la representation graphique de la fourmiliere.
   */
  protected VueFourmiliere laVueDeLaFourmiliere;

  /**
   * Cree la representation graphique d'une fourmi adulte et la fait apparaitre au milieu de la
   * fourmiliere.
   * 
   * @param laVueDeLaFourmiliere la representation graphique de la fourmiliere dans laquelle
   *        apparait la fourmi adulte.
   */
  public VueFourmiAdulte(VueFourmiliere laVueDeLaFourmiliere) {
    this.laVueDeLaFourmiliere = laVueDeLaFourmiliere;
    this.composantGraphique = new GOval();
    this.composantGraphique.setDimension(new Dimension(6, 6));
    this.laVueDeLaFourmiliere.ajouterFourmi(this.composantGraphique);
  }

  /**
   * Permet a une fourmi de se deplacer, au hasard, en haut, en bas, a gauche ou a droite
   */
  public void seDeplacer() {
    // On cree le generateur de nombre aleatoire
    Random random = new Random();

    // On genere un nombre aleatoire entre 1 et 4
    int unNombreAleatoire = random.nextInt(4);

    if (unNombreAleatoire == 0) {
      // Si c'est 0, on va a droite
      int posX = this.composantGraphique.getX() + 10;
      if (this.verifierPositionX(posX)) {
        this.composantGraphique.setX(posX);
      }
    } else if (unNombreAleatoire == 1) {
      // Si c'est 1, on va a gauche
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
   * Verifie si la fourmi peut se deplacer vers la gauche ou la droite sans sortir du territoire
   * 
   * @param pos la future position de la fourmi apres son deplacement
   * @return Vrai si la fourmi peut se deplacer sans sortir du terrain, faux sinon.
   */
  public boolean verifierPositionX(int pos) {
    return (pos > 0 && pos < (this.laVueDeLaFourmiliere.getLaVueTerrain().getLargeurTerrain()
        - this.composantGraphique.getWidth()));
  }

  /**
   * Verifie si la fourmi peut se deplacer vers le haut ou le bas sans sortir du territoire
   * 
   * @param pos la future position de la fourmi apres son deplacement
   * @return Vrai si la fourmi peut se deplacer sans sortir du terrain, faux sinon.
   */
  public boolean verifierPositionY(int pos) {
    return (pos > 0 && pos < (this.laVueDeLaFourmiliere.getLaVueTerrain().getHauteurTerrain()
        - this.composantGraphique.getHeight()));
  }

  /**
   * Fait disparaitre la representation graphique de la fourmi
   */
  public void supprimerFourmi() {
    this.laVueDeLaFourmiliere.getLaVueTerrain().supprimerFourmi(composantGraphique);
  }

  public GOval composantGraphique() {
    return this.composantGraphique;
  }

  public void setComposantGraphique(GOval composantGraphique) {
    this.composantGraphique = composantGraphique;
  }
}
