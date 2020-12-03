package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;
import vue.VueFourmiReine;

public class Reine extends Femelle {

  private Fourmiliere laFourmiliere;
  
  public Reine(Adulte lAdulte) {
    super(lAdulte);
    this.lAdulte.setComposantGraphique(new VueFourmiReine(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
    this.esperanceDeVie = (int) (Math.random() * (3650 - 1460)) + 1460;
    this.laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
    this.laFourmiliere.incrementerNombreFemelles();
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se déplace aléatoirement
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

  protected void pondre() {
    int nbPonteJour = (int) ((Math.random() * (20 - 10)) + 10);
    for (int nbPonte = 0; nbPonte < nbPonteJour; nbPonte++) {
      laFourmiliere.ajouterFourmi();
      laFourmiliere.incrementerNombreOeufs();
    }
  }

  protected void mourir() {
    this.lAdulte.getLaFourmi().getLaFourmiliere().supprimerReine();
    laFourmiliere.decrementerNombreFemelles();
    System.out.println("Reine morte");
  }
}
