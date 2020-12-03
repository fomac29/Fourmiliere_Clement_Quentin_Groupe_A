package terrain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import fourmi.Fourmi;

/**
 * Représente une des fourmis dont ont souhaite étudier le comportement
 * 
 * @author Clément Stoliaroff, Quentin Tassy
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
   * Formatte arrondis les nombres décimaux à 2 chiffres après la virgule
   */
  private static DecimalFormat df2 = new DecimalFormat("#.##");

  public Fourmiliere(Fourmi reine) {
    this.lesFourmis = new ArrayList<Fourmi>();
    this.laReineDesFourmis = reine;
    // La reine est une femelle
    this.incrementerNombreFemelles();
    this.pourcentageOuvrieres = (Math.random() * (0.7 - 0.6)) + 0.6;
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

  public void step() {
    for (int i = 0; i < this.lesFourmis.size(); i++) {
      this.lesFourmis.get(i).step();
    }
    // si la reine n'est pas morte
    if (this.laReineDesFourmis != null) {
      this.laReineDesFourmis.step();
    }
  }

  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }

  public void supprimerFourmi(Fourmi uneFourmi) {
    this.lesFourmis.remove(uneFourmi);
  }

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

  @Override
  public String toString() {
    int nombreTotalFourmiAdultes =
        this.nombreOuvriers + this.nombreFemelles + this.nombreMales + this.nombreSoldats;

    double affichagePourcentageOuvrieres = this.pourcentageOuvrieres * 100;
    double affichagePourcentageSoldats =
        (this.pourcentageSoldat - this.pourcentageOuvrieres) * 100;
    double affichagePourcentageSexues =
        100 - (affichagePourcentageOuvrieres + affichagePourcentageSoldats);
    String res = "Fourmilière (Ouvrières : " + df2.format(affichagePourcentageOuvrieres)
        + "%, Soldats : " + df2.format(affichagePourcentageSoldats) + "%, Sexués : "
        + df2.format(affichagePourcentageSexues) + "%) :";

    res += "\n\t- Nombre d'oeufs : " + this.nombreOeufs;
    res += "\n\t- Nombre de larves : " + this.nombreLarves;
    res += "\n\t- Nombre de nymphes : " + this.nombreNymphes;
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

  public Fourmi getLaReineDesFourmis() {
    return laReineDesFourmis;
  }

  public int getNombreNymphes() {
    return nombreNymphes;
  }

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
