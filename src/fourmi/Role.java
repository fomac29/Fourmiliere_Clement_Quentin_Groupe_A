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
  
  protected void mourir() {
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
    laFourmiliere.supprimerFourmi(laFourmi);
    laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
    this.lAdulte.getComposantGraphique().supprimerFourmi();
  }

  public Adulte getlAdulte() {
    return lAdulte;
  }

  public void setlAdulte(Adulte lAdulte) {
    this.lAdulte = lAdulte;
  }

  public Integer getEsperanceDeVie() {
    return esperanceDeVie;
  }

  public void setEsperanceDeVie(Integer esperanceDeVie) {
    this.esperanceDeVie = esperanceDeVie;
  }

  public abstract void step();
}
