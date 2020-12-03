package vue;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import graphicLayer.GOval;

public abstract class VueFourmiAdulte {
  protected GOval composantGraphique;
  protected VueFourmiliere laVueDeLaFourmiliere;
  
  public VueFourmiAdulte(VueFourmiliere laVueDeLaFourmiliere) {
    this.laVueDeLaFourmiliere = laVueDeLaFourmiliere;
    this.composantGraphique = new GOval();
    this.composantGraphique.setPosition(new Point(247,247));
    this.composantGraphique.setDimension(new Dimension(6, 6));
    this.laVueDeLaFourmiliere.ajouterFourmi(this.composantGraphique);
  }

  public void seDeplacer() {
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(4);
    
    if(unNombreAleatoire == 0) {
      int posX = this.getComposantGraphique().getX()+10;
      if(this.verifierPosition(posX)) {
        composantGraphique.setX(posX);
      }
    }else if(unNombreAleatoire == 1) {
      int posX = this.getComposantGraphique().getX()-10;
      if(this.verifierPosition(posX)) {
        composantGraphique.setX(posX);
      }
    }else if(unNombreAleatoire == 2) {
      int posY = this.getComposantGraphique().getY()+10;
      if(this.verifierPosition(posY)) {
        composantGraphique.setY(posY);
      }
    }else if(unNombreAleatoire == 3){
      int posY = this.getComposantGraphique().getY()-10;
      if(this.verifierPosition(posY)) {
        composantGraphique.setY(posY);
      }
    }
  }
  
  public boolean verifierPosition(int pos) {
    if(pos >= 0 && pos <= laVueDeLaFourmiliere.getLaVueTerrain().getHauteurTerrain()) {
      return true;
    }
    return false;
  }
  
  public void supprimerFourmi() {
    laVueDeLaFourmiliere.getLaVueTerrain().supprimerFourmi(composantGraphique);
  }

  public GOval getComposantGraphique() {
    return composantGraphique;
  }

  public void setComposantGraphique(GOval composantGraphique) {
    this.composantGraphique = composantGraphique;
  }
}
