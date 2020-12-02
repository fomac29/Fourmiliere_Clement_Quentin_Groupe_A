package terrain;

import java.util.ArrayList;
import java.util.List;
import fourmi.Fourmi;

public class Fourmiliere {
  List<Fourmi> lesFourmis;
  Fourmi laReineDesFourmis;

  private int nombreOeufs = 0;
  private int nombreLarves = 0;
  private int nombreNymphes = 0;
  private int nombreOuvriers = 0;
  private int nombreSoldats = 0;
  private int nombreMales = 0;
  private int nombreFemelles = 0;

  public Fourmiliere(Fourmi reine) {
    this.lesFourmis = new ArrayList<Fourmi>();
    this.laReineDesFourmis = reine;
  }

  public void step() {
    for (int i = 0; i < this.lesFourmis.size(); i++) {
      this.lesFourmis.get(i).step();
    }
    this.laReineDesFourmis.step();
  }

  public void ajouterFourmi(Fourmi uneFourmi) {
    this.lesFourmis.add(uneFourmi);
  }
  
  public void supprimerFourmi(Fourmi uneFourmi) {
    this.lesFourmis.remove(uneFourmi);
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
    String res = "Fourmilière :";
    res += "\n\t- Nombre d'oeufs : " + this.nombreOeufs;
    res += "\n\t- Nombre de larves : " + this.nombreLarves;
    res += "\n\t- Nombre de nymphes : " + this.nombreNymphes;
    res += "\n\t- Nombre d'ouvrières : " + this.nombreOuvriers;
    res += "\n\t- Nombre de soldats : " + this.nombreSoldats;
    res += "\n\t- Nombre de mâles : " + this.nombreMales;
    res += "\n\t- Nombre de femelles : " + this.nombreFemelles;

    return res;
  }


}
