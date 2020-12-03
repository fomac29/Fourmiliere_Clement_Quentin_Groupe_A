package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public abstract class Role {
  Adulte lAdulte;
  Integer esperanceDeVie;
  GOval representationGraphique;
  
  public Role(Adulte adulte) {
    this.lAdulte = adulte;
    this.esperanceDeVie = (int) (Math.random() * (912 - 548)) + 548;
  }
  
  public void mourir() {
    Fourmi laFourmi = this.lAdulte.getLaFourmi();
    Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
    laFourmi.getLaFourmiliere().supprimerFourmi(laFourmi);
    laFourmiliere.getLeTerrain().getLaVueTerrain().supprimerFourmi(this.lAdulte.getComposantGraphique());
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
