package fourmi;

import etape.Etape;
import etape.Oeuf;
import terrain.Fourmiliere;

/**
 * Représente une des fourmis dont ont souhaite étudier le comportement
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Fourmi {
  private Etape lEtape;
  private Fourmiliere laFourmiliere;

  /**
   * Une fourmi commence à l'état d'oeuf
   */
  public Fourmi() {
    this.lEtape = new Oeuf(this);
  }
  
  public void step() {
    this.lEtape.step();
  }

  public Etape getlEtape() {
    return lEtape;
  }

  public void setlEtape(Etape lEtape) {
    this.lEtape = lEtape;
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }
}
