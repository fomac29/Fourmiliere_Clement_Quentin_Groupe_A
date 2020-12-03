package etape;

import fourmi.Femelle;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;
import fourmi.Soldat;
import terrain.Fourmiliere;
import vue.VueFourmiAdulte;

/**
 * Quatrième et étape de la vie d'une fourmi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {
  private Role leRole;
  private VueFourmiAdulte composantGraphique;
  private Fourmiliere laFourmiliere;

  public Adulte(Fourmi uneFourmi) {
    super(uneFourmi);

    double unNombreAleatoire = Math.random();
    this.laFourmiliere = this.getLaFourmi().getLaFourmiliere();
    /*
     * On tire un pourcentage entre 60% et 70% au hasard Puis on tire un nombre au hasard : si
     * celui-ci est inférieur ou égal au pourcentage tiré, alors on attribut le rôle Ouvrier
     */
    if (unNombreAleatoire <= laFourmiliere.getPourcentageOuvrieres()) {
      this.leRole = new Ouvrier(this);
      this.laFourmiliere.incrementerNombreOuvriers();
    }

    // Même chose entre 20% et 25% pour les fourmis soldats
    else if (unNombreAleatoire <= laFourmiliere.getPourcentageSoldats()) {
      this.leRole = new Soldat(this);
      this.laFourmiliere.incrementerNombreSoldats();
    }

    // Sinon, c'est une fourmi sexué
    else {
      // La fourmi a 50% de chance d'être une femelle
      if (Math.random() <= 0.5) {
        this.leRole = new Femelle(this);
        this.laFourmiliere.incrementerNombreFemelles();
      }

      // Sinon c'est un mâle
      else {
        this.leRole = new Male(this);
        this.laFourmiliere.incrementerNombreMales();
      }
    }
  }

  public Adulte() {
    super();
  }
  
  @Override
  public void step() {
    this.leRole.step();
  }
  
  public void deplacerComposantFourmi() {
    this.composantGraphique.seDeplacer();
  }
  
  public void supprimerComposantFourmi() {
    this.composantGraphique.supprimerFourmi();
  }
  
  public void mourir() {
    Fourmi laFourmi = this.laFourmi;
    laFourmiliere.supprimerFourmi(laFourmi);
    laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
    this.supprimerComposantFourmi();
  }
  
  public Role getLeRole() {
    return leRole;
  }

  public void setLeRole(Role leRole) {
    this.leRole = leRole;
  }

  public VueFourmiAdulte getComposantGraphique() {
    return composantGraphique;
  }

  public void setComposantGraphique(VueFourmiAdulte composantGraphique) {
    this.composantGraphique = composantGraphique;
  }
}
