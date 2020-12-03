package terrain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import fourmi.Fourmi;
import vue.VueFourmiliere;

public class Fourmiliere {
  private List<Fourmi> lesFourmis;
  private List<Proie> lesProies;
  private Fourmi laReineDesFourmis;

  private Terrain leTerrain;
  private VueFourmiliere laVueFourmiliere;

  private int nombreOeufs = 0;
  private int nombreLarves = 0;
  private int nombreNymphes = 0;
  private int nombreOuvriers = 0;
  private int nombreSoldats = 0;
  private int nombreMales = 0;
  private int nombreFemelles = 0;

  private double pourcentageOuvrieres;
  private double pourcentageSoldat;

  /**
   * Arrondis les nombres décimaux à 2 chiffres après la virgule pour l'affichage
   */
  private static DecimalFormat df2 = new DecimalFormat("#.##");

  public Fourmiliere(Terrain terrain) {
    this.lesFourmis = new ArrayList<Fourmi>();
    this.lesProies = new ArrayList<Proie>();
    this.leTerrain = terrain;
    this.laVueFourmiliere = new VueFourmiliere(this.leTerrain.getLaVueTerrain());

    // Il y a entre 60% et 70% de fourmi ouvrière
    this.pourcentageOuvrieres = (Math.random() * (0.7 - 0.6)) + 0.6;

    // Il y a entre 20% et 25% de fourmis soldat
    this.pourcentageSoldat =
        (Math.random() * (pourcentageOuvrieres + 0.25 - (pourcentageOuvrieres + 0.2)))
            + (pourcentageOuvrieres + 0.2);
  }

  /**
   * Ajoute une proie, puis effectue un pas de simulation pour chaque fourmiset chaque proies de la
   * fourmilière
   */
  public void step() {
    this.ajouterProie();

    for (int i = 0; i < this.lesFourmis.size(); i++) {
      this.lesFourmis.get(i).step();
    }

    for (int i = 0; i < this.lesProies.size(); i++) {
      this.lesProies.get(i).step();
    }

    // si la reine n'est pas morte
    if (this.laReineDesFourmis != null) {
      this.laReineDesFourmis.step();
    }
  }

  /**
   * Ajoute une nouvelle fourmi dans la fourmilière
   */
  public void ajouterFourmi() {
    Fourmi uneFourmi = new Fourmi(this);
    this.lesFourmis.add(uneFourmi);
  }

  /**
   * Retire la fourmi de fourmilière.
   * 
   * @param uneFourmi La fourmi à retirer.
   */
  public void supprimerFourmi(Fourmi uneFourmi) {
    this.lesFourmis.remove(uneFourmi);
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

  /**
   * Retire la reine de la fourmilière, sert quand celle-ci meurt
   */
  public void supprimerReine() {
    this.laReineDesFourmis = null;
  }

  /**
   * Vérifie si une fourmi se trouve dans la fourmilière.
   * 
   * @param laFourmiATrouver La fourmi dont on veut vérifier la présence.
   * @return Vrai si la fourmi est dans la fourmilière, faux sinon
   */
  public boolean chercherFourmi(Fourmi laFourmiATrouver) {
    if (laFourmiATrouver == null) {
      return false;
    }

    if (this.laReineDesFourmis.equals(laFourmiATrouver)) {
      return true;
    }

    for (Fourmi uneFourmi : this.lesFourmis) {
      if (uneFourmi.equals(laFourmiATrouver)) {
        return true;
      }
    }

    return false;
  }

  /**
   * Affiche la fourmilière avec le détail de sa population et la répartition de celle-ci
   */
  @Override
  public String toString() {
    /*
     * La répartition de la population de fourmi n'est calculée qu'en fonction des adultes : En
     * effets, les autres n'ont pas de rôles
     */
    int nombreTotalFourmiAdultes =
        this.nombreOuvriers + this.nombreFemelles + this.nombreMales + this.nombreSoldats;

    // Convertis la répartition de la population attendue en pourcentage
    double affichagePourcentageOuvrieres = this.pourcentageOuvrieres * 100;
    double affichagePourcentageSoldats = (this.pourcentageSoldat - this.pourcentageOuvrieres) * 100;
    double affichagePourcentageSexues =
        100 - (affichagePourcentageOuvrieres + affichagePourcentageSoldats);

    // On arrondis ces pourcentages à 2 chiffres après la virgule
    String res = "Fourmilière (Ouvrières : " + df2.format(affichagePourcentageOuvrieres)
        + "%, Soldats : " + df2.format(affichagePourcentageSoldats) + "%, Sexués : "
        + df2.format(affichagePourcentageSexues) + "%) :";

    // on affiche le nombre de chaque type de fourmis
    res += "\n\t- Nombre d'oeufs : " + this.nombreOeufs;
    res += "\n\t- Nombre de larves : " + this.nombreLarves;
    res += "\n\t- Nombre de nymphes : " + this.nombreNymphes;

    // Pour les adultes, on calcule leur répartition réelle en pourcentage
    res += "\n\t- Nombre d'ouvrières : " + this.nombreOuvriers + " ("
        + this.nombreOuvriers * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de soldats : " + this.nombreSoldats + " ("
        + this.nombreSoldats * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de mâles : " + this.nombreMales + " ("
        + this.nombreMales * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de femelles : " + this.nombreFemelles + " ("
        + this.nombreFemelles * 100 / nombreTotalFourmiAdultes + "%)";

    return res;
  }

  public void incrementerNombreOeufs() {
    this.nombreOeufs++;
  }

  public void decrementerNombreOeufs() {
    this.nombreOeufs--;
  }

  public void incrementerNombreLarves() {
    this.nombreLarves++;
  }

  public void decrementerNombreLarves() {
    this.nombreLarves--;
  }

  public void incrementerNombreNymphes() {
    this.nombreNymphes++;
  }

  public void decrementerNombreNymphes() {
    this.nombreNymphes--;
  }

  public void incrementerNombreOuvriers() {
    this.nombreOuvriers++;
  }

  public void decrementerNombreOuvriers() {
    this.nombreOuvriers--;
  }

  public void incrementerNombreSoldats() {
    this.nombreSoldats++;
  }

  public void decrementerNombreSoldats() {
    this.nombreSoldats--;
  }

  public void incrementerNombreMales() {
    this.nombreMales++;
  }

  public void decrementerNombreMales() {
    this.nombreMales--;
  }

  public void incrementerNombreFemelles() {
    this.nombreFemelles++;
  }

  public void decrementerNombreFemelles() {
    this.nombreFemelles--;
  }

  public Terrain getLeTerrain() {
    return leTerrain;
  }

  public void setLeTerrain(Terrain leTerrain) {
    this.leTerrain = leTerrain;
  }

  public double getPourcentageOuvrieres() {
    return pourcentageOuvrieres;
  }

  public double getPourcentageSoldats() {
    return pourcentageSoldat;
  }

  public double getPourcentageSexues() {
    return 1 - (this.pourcentageOuvrieres + (this.pourcentageSoldat - this.pourcentageOuvrieres));
  }

  public List<Fourmi> getLesFourmis() {
    return lesFourmis;
  }

  public int getNombreOeufs() {
    return nombreOeufs;
  }

  public int getNombreLarves() {
    return nombreLarves;
  }

  public int getNombreOuvriers() {
    return nombreOuvriers;
  }

  public int getNombreSoldats() {
    return nombreSoldats;
  }

  public int getNombreMales() {
    return nombreMales;
  }

  public int getNombreFemelles() {
    return nombreFemelles;
  }

  public VueFourmiliere getLaVueFourmiliere() {
    return laVueFourmiliere;
  }

  public void setLaVueFourmiliere(VueFourmiliere laVueFourmiliere) {
    this.laVueFourmiliere = laVueFourmiliere;
  }

  public void setLaReineDesFourmis(Fourmi laReineDesFourmis) {
    this.laReineDesFourmis = laReineDesFourmis;
  }

  public Fourmi getLaReineDesFourmis() {
    return laReineDesFourmis;
  }

  public int getNombreNymphes() {
    return nombreNymphes;
  }
}
