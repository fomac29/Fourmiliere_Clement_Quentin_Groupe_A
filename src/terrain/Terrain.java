package terrain;

import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;

/**
 * Le terrain contient actuellement la fourmiliere, et pourra en contenir plusieurs a l'avenir.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Terrain {
  /**
   * La fourmiliere a simuler.
   */
  Fourmiliere laFourmiliere;

  /**
   * Nombre de jours ecoules depuis le debut de la simulation.
   */
  int jourCourant;

  /**
   * Construit le terrain avec sa representation graphique et initialise une fourmiliere contenant
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
   * Verifie si le jour courant est un jour de printemps.
   * 
   * @return Vrai si c'est le printemps, faux sinon
   */
  public boolean isPrintemps() {
    // Le printemps dure 90 jours dans l'annee
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
