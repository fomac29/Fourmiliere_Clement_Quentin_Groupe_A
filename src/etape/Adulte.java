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
 * Quatrieme et etape de la vie d'une fourmi
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public class Adulte extends Etape {
  private Role leRole;
  private VueFourmiAdulte composantGraphique;

  /**
   * Une fois adulte, la fourmi se voit attribuer un role aleatoirement, en fonction des
   * probabilites associees a sa fourmiliere
   * 
   * @param uneFourmi La fourmi qui devient adulte
   */
  public Adulte(Fourmi uneFourmi) {
    super(uneFourmi);

    // On tire un nombre aleatoirement qui va definir le role de la fourmi
    double unNombreAleatoire = Math.random();

    Fourmiliere laFourmiliere = this.getLaFourmi().getLaFourmiliere();

    // La fourmi a entre 60% et 70% de devenir un ouvrier
    if (unNombreAleatoire <= laFourmiliere.getPourcentageOuvrieres()) {
      this.leRole = new Ouvrier(this);
      laFourmiliere.incrementerNombreOuvriers();
    }

    // La fourmi a entre 20% et 25% de devenir soldats
    else if (unNombreAleatoire <= laFourmiliere.getPourcentageSoldats()) {
      this.leRole = new Soldat(this);
      laFourmiliere.incrementerNombreSoldats();
    }

    // Si ce n'est ni un soldat, ni un ouvrier, elle est forcement sexuee
    else {
      // La fourmi a 50% de chance d'etre une femelle
      if (Math.random() <= 0.5) {
        this.leRole = new Femelle(this);
        laFourmiliere.incrementerNombreFemelles();
      }

      // Sinon c'est un male
      else {
        this.leRole = new Male(this);
        laFourmiliere.incrementerNombreMales();
      }
    }
  }

  public Adulte() {
    super();
  }

  /**
   * Effectue un pas de simulation, ici l'action est definie par le role de la fourmi
   */
  @Override
  public void step() {
    this.leRole.step();
  }

  /**
   * Deplace aleatoirement la fourmi sur le terrain
   */
  public void deplacerComposantFourmi() {
    this.composantGraphique.seDeplacer();
  }

  /**
   * Supprime la fourmi graphiquement du terrain et la supprime de la liste des fourmis de la
   * fourmiliere
   */
  public void mourir() {
    this.laFourmi.getLaFourmiliere().supprimerFourmi(this.laFourmi);
    this.laFourmi.setLaFourmiliere(null);
    this.composantGraphique.supprimerFourmi();
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
