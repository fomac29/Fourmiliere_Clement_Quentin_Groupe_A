package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Reine extends Femelle {

  public Reine(Adulte lAdulte) {
    super(lAdulte);
    this.esperanceDeVie = (int) (Math.random() * (3650 - 1460)) + 1460;
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
    }
    else if(this.lAdulte.getLaFourmi().getLaFourmiliere().getLeTerrain().isPrintemps()) {
      this.pondre();
    }
  }

  protected void pondre() {
      Fourmiliere laFourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.ajouterFourmi();
      laFourmiliere.incrementerNombreOeufs();
  }
  
  public void mourir() {
    Fourmiliere fourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    laFourmi.getLaFourmiliere().supprimerReine();
    fourmiliere.decrementerNombreFemelles();
    System.out.println("Reine morte");
  }
}
