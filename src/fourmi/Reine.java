package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

/**
 * Represente la reine des fourmis
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Reine extends Femelle {

  /**
   * Cree la reine des fourmis avec son composant graphique, recalcule son esperance de vie
   * (Contrairement aux autres, celle-ci vit entre 4 et 10 ans).
   * 
   * @param lAdulte Permet d'acceder a la fourmi associee.
   */
  public Reine(Adulte lAdulte) {
    super(lAdulte);
    this.esperanceDeVie = (int) (Math.random() * (3650 - 1460)) + 1460;
  }

  /**
   * La reine des fourmis meure si elle atteint la fin de sa vie, sinon elle ponds si on est au
   * printemps
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
    } else if (this.lAdulte.getLaFourmi().getLaFourmiliere().getLeTerrain().isPrintemps()) {
      this.pondre();
    }
  }

  /**
   * La reine ponds entre 10 et 20 oeufs par portee
   */
  protected void pondre() {
    int nbPonteJour = (int) ((Math.random() * (20 - 10)) + 10);
    for (int nbPonte = 0; nbPonte < nbPonteJour; nbPonte++) {
      Fourmiliere laFourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
      Fourmi laFourmi = new Fourmi();
      laFourmi.setLaFourmiliere(laFourmiliere);
      laFourmiliere.ajouterFourmi(laFourmi);
      laFourmiliere.incrementerNombreOeufs();
    }
  }

  /**
   * Supprime la reine des fourmis de la fourmiliere et fait disparaitre son composant graphique
   */
  protected void mourir() {
    Fourmiliere fourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    laFourmi.getLaFourmiliere().supprimerReine();
    // La reine des fourmis est une femelle
    fourmiliere.decrementerNombreFemelles();
    // System.out.println("Reine morte");
  }
}
