package terrain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import fourmi.Fourmi;

/**
 * Represente une des fourmis dont ont souhaite etudier le comportement
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public class Fourmiliere {
  List<Fourmi> lesFourmis;
  Fourmi laReineDesFourmis;

  Terrain leTerrain;

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
   * Formatte arrondis les nombres decimaux a 2 chiffres apres la virgule
   */
  private static DecimalFormat df2 = new DecimalFormat("#.##");

  public Fourmiliere(Fourmi reine) {
    this.lesFourmis = new ArrayList<Fourmi>();
    this.laReineDesFourmis = reine;
    // La reine est une femelle
    this.incrementerNombreFemelles();

    // Il y a entre 60% et 70% de fourmi ouvriere
    this.pourcentageOuvrieres = (Math.random() * (0.7 - 0.6)) + 0.6;

    // Il y a entre 20% et 25% de fourmis soldat
    this.pourcentageSoldat =
        (Math.random() * (pourcentageOuvrieres + 0.25 - (pourcentageOuvrieres + 0.2)))
            + (pourcentageOuvrieres + 0.2);
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

  /**
   * Effectue un pas de simulation pour chaque fourmis et de la fourmiliere
   */
  public void step() {
    for (int i = 0; i < this.lesFourmis.size(); i++) {
      this.lesFourmis.get(i).step();
    }
    // si la reine n'est pas morte
    if (this.laReineDesFourmis != null) {
      this.laReineDesFourmis.step();
    }
  }

  /**
   * Ajoute une nouvelle fourmi dans la fourmiliere.
   * 
   * @param uneFourmi La fourmi à ajouter
   */
  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }

  /**
   * Retire la fourmi de fourmiliere.
   * 
   * @param uneFourmi La fourmi a retirer.
   */
  public void supprimerFourmi(Fourmi uneFourmi) {
    this.lesFourmis.remove(uneFourmi);
  }

  /**
   * Retire la reine de la fourmiliere, sert quand celle-ci meurt
   */
  public void supprimerReine() {
    this.laReineDesFourmis = null;
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

  /**
   * Affiche la fourmiliere avec le detail de sa population et la repartition de celle-ci
   */
  @Override
  public String toString() {
    /*
     * La repartition de la population de fourmi n'est calculee qu'en fonction des adultes : En
     * effets, les autres n'ont pas de rôles
     */
    int nombreTotalFourmiAdultes =
        this.nombreOuvriers + this.nombreFemelles + this.nombreMales + this.nombreSoldats;

    // Convertis la repartition de la population attendue en pourcentage
    double affichagePourcentageOuvrieres = this.pourcentageOuvrieres * 100;
    double affichagePourcentageSoldats = (this.pourcentageSoldat - this.pourcentageOuvrieres) * 100;
    double affichagePourcentageSexues =
        100 - (affichagePourcentageOuvrieres + affichagePourcentageSoldats);

    // On arrondis ces pourcentages a 2 chiffres apres la virgule
    String res = "Fourmiliere (Ouvrieres : " + df2.format(affichagePourcentageOuvrieres)
        + "%, Soldats : " + df2.format(affichagePourcentageSoldats) + "%, Sexues : "
        + df2.format(affichagePourcentageSexues) + "%) :";

    // on affiche le nombre de chaque type de fourmis
    res += "\n\t- Nombre d'oeufs : " + this.nombreOeufs;
    res += "\n\t- Nombre de larves : " + this.nombreLarves;
    res += "\n\t- Nombre de nymphes : " + this.nombreNymphes;

    // Pour les adultes, on calcule leur repartition reelle en pourcentage
    res += "\n\t- Nombre d'ouvrieres : " + this.nombreOuvriers + " ("
        + this.nombreOuvriers * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de soldats : " + this.nombreSoldats + " ("
        + this.nombreSoldats * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de mâles : " + this.nombreMales + " ("
        + this.nombreMales * 100 / nombreTotalFourmiAdultes + "%)";
    res += "\n\t- Nombre de femelles : " + this.nombreFemelles + " ("
        + this.nombreFemelles * 100 / nombreTotalFourmiAdultes + "%)";

    return res;
  }

  public Fourmi getLaReineDesFourmis() {
    return laReineDesFourmis;
  }

  public int getNombreNymphes() {
    return nombreNymphes;
  }

  /**
   * Verifie si une fourmi se trouve dans la fourmiliere.
   * 
   * @param laFourmiATrouver La fourmi dont on veut verifier la presence.
   * @return Vrai si la fourmi est dans la fourmiliere, faux sinon
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


}
