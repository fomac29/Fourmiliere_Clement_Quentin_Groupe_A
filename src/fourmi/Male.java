package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Male extends Sexue {

  public Male(Adulte adulte) {
    super(adulte);
    //ajouterVue(composant)
  }

  @Override
  public void step() {
    //seDeplacer(composant)
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      Fourmi laFourmi = this.lAdulte.getLaFourmi();
      Fourmiliere laFourmiliere = laFourmi.getLaFourmiliere();
      laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
      laFourmiliere.decrementerNombreMales();
    }
  }
  
  /*public void ajouterAlaVue(composant) {
    container.addElement(composant)
  }*/
  
  /*public void seDeplacer(compsoant) {
    composant.setPosition(new Point(x,y))
  }*/
}
