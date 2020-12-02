package etape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import fourmi.Femelle;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;
import fourmi.Soldat;
import graphicLayer.GOval;
import terrain.Fourmiliere;
import vue.VueTerrain;

/**
 * Quatrième et étape de la vie d'une fourmi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {
  private Role leRole;
  private GOval composantGraphique = new GOval();

  public Adulte(Fourmi uneFourmi) {
    super(uneFourmi);
    
    this.ajouterFourmi();
    
    double unNombreAleatoire = Math.random();
    Fourmiliere laFourmiliere = this.getLaFourmi().getLaFourmiliere();
    /*
     * On tire un pourcentage entre 60% et 70% au hasard Puis on tire un nombre au hasard : si
     * celui-ci est inférieur ou égal au pourcentage tiré, alors on attribut le rôle Ouvrier
     */
    if (unNombreAleatoire <= laFourmiliere.getPourcentageOuvriere()) {
      this.leRole = new Ouvrier(this);
      this.laFourmi.getLaFourmiliere().incrementerNombreOuvriers();
    }

    // Même chose entre 20% et 25% pour les fourmis soldats
    else if (unNombreAleatoire <= laFourmiliere.getPourcentageSoldat()) {
      this.leRole = new Soldat(this);
      this.laFourmi.getLaFourmiliere().incrementerNombreSoldats();
    }

    // Sinon, c'est une fourmi sexué
    else {
      // La fourmi a 50% de chance d'être une femelle
      if (Math.random() <= 0.5) {
        this.leRole = new Femelle(this);
        this.laFourmi.getLaFourmiliere().incrementerNombreFemelles();
      }

      // Sinon c'est un mâle
      else {
        this.leRole = new Male(this);
        this.laFourmi.getLaFourmiliere().incrementerNombreMales();
      }
    }
  }

  public Adulte() {
    super();
  }
  
  @Override
  public void step() {
    this.deplacerFourmi();
    this.leRole.step();
  }

  public void ajouterFourmi() {
    composantGraphique = new GOval();
    composantGraphique.setPosition(new Point(0,0));
    composantGraphique.setDimension(new Dimension(5, 5));
    composantGraphique.setColor(Color.yellow);
    
    VueTerrain laVueDuTerrain = this.laFourmi.getLaFourmiliere().getLeTerrain().getLaVueTerrain();
    laVueDuTerrain.ajouterFourmi(composantGraphique);
  }
  
  public void deplacerFourmi() {
    VueTerrain laVueDuTerrain = this.laFourmi.getLaFourmiliere().getLeTerrain().getLaVueTerrain();
    
    Random random = new Random();
    int unNombreAleatoire = random.nextInt(2);
    
    if(unNombreAleatoire == 0) {
      int positionX = random.nextInt(laVueDuTerrain.getLargeurTerrain());
      composantGraphique.setX(positionX);
    }else {
      int positionY = random.nextInt(laVueDuTerrain.getHauteurTerrain());
      composantGraphique.setY(positionY);
    }
    
  }
  
  public void supprimerFourmi() {
    VueTerrain laVueDuTerrain = this.laFourmi.getLaFourmiliere().getLeTerrain().getLaVueTerrain();
    laVueDuTerrain.supprimerFourmi(composantGraphique);
  }
  
  public Role getLeRole() {
    return leRole;
  }

  public void setLeRole(Role leRole) {
    this.leRole = leRole;
  }

  public GOval getComposantGraphique() {
    return composantGraphique;
  }
  
  
}
