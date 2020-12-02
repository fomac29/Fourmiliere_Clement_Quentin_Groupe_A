package terrain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import fourmi.Fourmi;
import graphicLayer.GRect;
import vue.VueTerrain;

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

  private double pourcentageOuvriere;
  private double pourcentageSoldat;

  public Fourmiliere(Fourmi reine) {
    this.lesFourmis = new ArrayList<Fourmi>();
    this.laReineDesFourmis = reine;
    this.pourcentageOuvriere = (Math.random() * (0.7 - 0.6)) + 0.6;
    this.pourcentageSoldat =
        (Math.random() * (pourcentageOuvriere + 0.25 - (pourcentageOuvriere + 0.2)))
            + (pourcentageOuvriere + 0.2);
  }
  
  public void placerFourmiliere() {
    VueTerrain laVueDuTerrain = this.leTerrain.getLaVueTerrain();
    
    GRect fourmiliere = new GRect();
    fourmiliere.withoutBorder();
    fourmiliere.setColor(Color.RED);
    fourmiliere.setPosition(new Point(30, 30));
    fourmiliere.setDimension(new Dimension(400, 300));
    laVueDuTerrain.getFenetre().addElement(fourmiliere);
  }
  
  public Terrain getLeTerrain() {
    return leTerrain;
  }

  public void setLeTerrain(Terrain leTerrain) {
    this.leTerrain = leTerrain;
  }

  public double getPourcentageOuvriere() {
    return pourcentageOuvriere;
  }

  public double getPourcentageSoldat() {
    return pourcentageSoldat;
  }

  public void step() {
    for (int i = 0; i < this.lesFourmis.size(); i++) {
      this.lesFourmis.get(i).step();
    }
    // si la reine n'est pas morte
    if(this.laReineDesFourmis != null) {
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

  @Override
  public String toString() {
    int nombreTotalFourmiAdultes =
        this.nombreOuvriers + this.nombreFemelles + this.nombreMales + this.nombreSoldats;

    int affichagePourcentageOuvrieres = (int) (this.pourcentageOuvriere * 100);
    int affichagePourcentageSoldats = (int) (this.pourcentageOuvriere
        - (this.pourcentageOuvriere - this.pourcentageSoldat) * 100);
    int affichagePourcentageSexues =
        100 - (affichagePourcentageOuvrieres + affichagePourcentageSoldats);
    String res = "Fourmilière (Ouvrières : " + affichagePourcentageOuvrieres + "%, Soldats : "
        + affichagePourcentageSoldats + "%, Sexués : " + affichagePourcentageSexues + "%) :";

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


}
