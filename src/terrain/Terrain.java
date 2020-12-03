package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;

/**
 * Le terrain contient actuellement la fourmilière, et pourra en contenir plusieurs à l'avenir.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Terrain {
  /**
   * La fourmilière a simuler.
   */
  Fourmiliere laFourmiliere;
  
  /**
   * Nombre de jours écoulés depuis le début de la simulation.
   */
  int jourCourant;

  /**
   * Construit le terrain avec sa représentation graphique et initialise une fourmilière contenant
   * une reine.
   */
  public Terrain() {
    this.jourCourant = 0;
    Fourmi reine = new Fourmi();
    this.laFourmiliere = new Fourmiliere(reine);
    this.laFourmiliere.setLeTerrain(this);
    reine.setLaFourmiliere(laFourmiliere);
    Adulte adulte = new Adulte();
    adulte.setLaFourmi(reine);
    adulte.setLeRole(new Reine(adulte));
    reine.setlEtape(adulte);
  }

  /**
   * Effectue un pas de simulation.
   */
  public void step() {
    this.laFourmiliere.step();
    this.jourCourant++;
  }


  /**
   * Vérifie si le jour courant est un jour de printemps.
   * @return Vrai si c'est le printemps, faux sinon
   */
  public boolean isPrintemps() {
    // Le printemps dure 90 jours dans l'année
    return (this.jourCourant % 365) <= 90;
  }

  public Fourmiliere getLaFourmiliere() {
    return laFourmiliere;
  }

  public void setLaFourmiliere(Fourmiliere laFourmiliere) {
    this.laFourmiliere = laFourmiliere;
  }

  public int getJourCourant() {
    return jourCourant;
  }

  public void setJourCourant(int jourCourant) {
    this.jourCourant = jourCourant;
  }
}
