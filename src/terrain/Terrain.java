package terrain;

import java.util.ArrayList;
import java.util.List;
import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;
import vue.VueTerrain;

/**
 * Le terrain contient actuellement la fourmilière, et pourra en contenir plusieurs à l'avenir.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Terrain {

  /**
   * La fourmilière a simuler.
   */
  private Fourmiliere laFourmiliere;

  /**
   * La repésentation graphique du terrain.
   */
  private VueTerrain laVueTerrain;

  /**
   * Nombre de jours écoulés depuis le début de la simulation.
   */
  private int jourCourant;
  
  private List<Proie> lesProies;

  /**
   * Construit le terrain avec sa représentation graphique et initialise une fourmilière contenant
   * une reine.
   */
  public Terrain() {
    this.laVueTerrain = new VueTerrain();
    this.laVueTerrain.ajouterTerrain();
    
    this.lesProies = new ArrayList<Proie>();

    this.jourCourant = 0;

    this.laFourmiliere = new Fourmiliere(this);
    Fourmi reine = new Fourmi(laFourmiliere);
    this.laFourmiliere.setLaReineDesFourmis(reine);

    Adulte adulte = new Adulte();
    adulte.setLaFourmi(reine);
    adulte.setLeRole(new Reine(adulte));
    reine.setlEtape(adulte);
  }

  /**
   * Effectue un pas de simulation.
   */
  public void step() {
    this.ajouterProie();
    this.laFourmiliere.step();
    
    for (int i = 0; i < this.lesProies.size(); i++) {
      this.lesProies.get(i).step();
    }
    
    this.laVueTerrain.rafraichir();
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
  
  /**
   * Ajoute une nouvelle proie dans la fourmilière.
   */
  public void ajouterProie() {
    Proie uneProie = new Proie(this);
    this.lesProies.add(uneProie);
  }

  /**
   * Retire une proie de la fourmilière.
   * 
   * @param uneProie La proie à retirer de la fourmilière.
   */
  public void supprimerProie(Proie uneProie) {
    this.lesProies.remove(uneProie);
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

  public VueTerrain getLaVueTerrain() {
    return laVueTerrain;
  }
}
