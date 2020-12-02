package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public abstract class Role {
  Adulte lAdulte;
  Integer esperanceDeVie;
  
  public Role(Adulte adulte) {
    this.lAdulte = adulte;
    this.esperanceDeVie = (int) (Math.random() * (912 - 548)) + 548;
  }
  
  public void mourir() {
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
    laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
  }

  public Adulte getlAdulte() {
    return lAdulte;
  }

  public void setlAdulte(Adulte lAdulte) {
    this.lAdulte = lAdulte;
  }

  public abstract void step();
}
