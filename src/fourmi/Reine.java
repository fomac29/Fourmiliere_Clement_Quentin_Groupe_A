package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueFourmiReine;

public class Reine extends Femelle {

  private Fourmiliere laFourmiliere;

  /**
   * Créé la reine des fourmis avec son composant graphique, recalcule son espérance de vie
   * (Contrairement aux autres, celle-ci vit entre 4 et 10 ans).
   * 
   * @param lAdulte Permet d'accéder à la fourmi associée.
   */
  public Reine(Adulte lAdulte) {
    super(lAdulte);
    this.lAdulte.setComposantGraphique(
        new VueFourmiReine(this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
    this.esperanceDeVie = (int) (Math.random() * (3650 - 1460)) + 1460;
    this.laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
    // La reine des fourmis est une femelle
    this.laFourmiliere.incrementerNombreFemelles();
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
    } else if (this.laFourmiliere.getLeTerrain().isPrintemps()) {
      this.pondre();
    }
  }

  /**
   * La reine ponds entre 10 et 20 oeufs par portée
   */
  protected void pondre() {
    int nbPonteJour = (int) ((Math.random() * (20 - 10)) + 10);
    for (int nbPonte = 0; nbPonte < nbPonteJour; nbPonte++) {
      laFourmiliere.ajouterFourmi();
      laFourmiliere.incrementerNombreOeufs();
    }
  }

  /**
   * Supprime la reine des  fourmis de la fourmiliere et fait disparaitre son composant graphique
   */
  protected void mourir() {
    this.lAdulte.getLaFourmi().getLaFourmiliere().supprimerReine();
    // La reine des fourmis est une femelle
    laFourmiliere.decrementerNombreFemelles();
    this.lAdulte.getComposantGraphique().supprimerFourmi();
    System.out.println("Reine morte");
  }
}
