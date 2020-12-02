package etape;

import fourmi.Femelle;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;
import fourmi.Soldat;

/**
 * Quatrième et étape de la vie d'une fourmi
 * 
 * @author Clément Stoliaroff
 *
 */
public class Adulte extends Etape {
  Role leRole;

  

  public Adulte(Fourmi uneFourmi) {
    super(uneFourmi);
    
    this.laFourmi.getLaFourmiliere().decrementerNombreNymphes();
    
    /*
     * On tire un pourcentage entre 60% et 70% au hasard Puis on tire un nombre au hasard : si
     * celui-ci est inférieur ou égal au pourcentage tiré, alors on attribut le rôle Ouvrier
     */
    if (Math.random() <= this.nombreAleatoire(0.6, 0.7)) {
      this.leRole = new Ouvrier(this);
      this.laFourmi.getLaFourmiliere().incrementerNombreOuvriers();
    }

    // Même chose entre 20% et 25% pour les fourmis soldats
    else if (Math.random() <= this.nombreAleatoire(0.2, 0.25)) {
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

  public Role getLeRole() {
    return leRole;
  }

  public void setLeRole(Role leRole) {
    this.leRole = leRole;
  }

  @Override
  public void step() {
    this.leRole.step();
  }
  
  
}
