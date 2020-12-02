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
    this.pondre();
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      
    }
  }

  protected void pondre() {
    Fourmiliere fourmiliere = super.lAdulte.getLaFourmi().getLaFourmiliere();
    Fourmi laFourmi = new Fourmi();
    laFourmi.setLaFourmiliere(fourmiliere);
    fourmiliere.ajouterFourmi(laFourmi);
    fourmiliere.incrementerNombreOeufs();
  }
  
  protected void mourir() {
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
    System.err.println("Reine morte");
  }
}
