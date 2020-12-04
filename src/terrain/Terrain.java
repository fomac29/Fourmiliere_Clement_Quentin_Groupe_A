package terrain;

import java.util.ArrayList;
import java.util.List;
import etape.Adulte;
import fourmi.Fourmi;
import fourmi.Reine;
import vue.VueTerrain;

/**
 * Le terrain contient actuellement la fourmiliere, et pourra en contenir plusieurs a l'avenir.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Terrain {

  /**
   * La fourmiliere a simuler.
   */
  private Fourmiliere laFourmiliere;

  /**
   * La repesentation graphique du terrain.
   */
  private VueTerrain laVueTerrain;

  /**
   * Nombre de jours ecoules depuis le debut de la simulation.
   */
  private int jourCourant;

  private List<Proie> lesProies;

  /**
   * Construit le terrain avec sa representation graphique et initialise une fourmiliere contenant
   * une reine.
   * 
   * @param lancerFenetre Vrai s'il ouvrier la fenetre d'application, faux sinon.
   */
  public Terrain(boolean lancerFenetre) {
    this.laVueTerrain = new VueTerrain(lancerFenetre);
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
   * Verifie si le jour courant est un jour de printemps.
   * 
   * @return Vrai si c'est le printemps, faux sinon
   */
  public boolean isPrintemps() {
    // Le printemps dure 90 jours dans l'annee
    return (this.jourCourant % 365) <= 90;
  }

  /**
   * Ajoute une nouvelle proie dans la fourmiliere.
   */
  public void ajouterProie() {
    Proie uneProie = new Proie(this);
    this.lesProies.add(uneProie);
  }

  /**
   * Retire une proie de la fourmiliere.
   * 
   * @param uneProie La proie a retirer de la fourmiliere.
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
