package etape;

import fourmi.Fourmi;

/**
 * Représente l'étape de la vie de la fourmi : Oeuf, Larve, Nyphe ou Adulte
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public abstract class Etape {
  Fourmi laFourmi;
  

  public Etape(Fourmi uneFourmi) {
    this.laFourmi = uneFourmi;
  }
  
  /**
   * Le constructeur vide sert à initialiser la première reine des fourmis
   */
  public Etape() {
    this.laFourmi = null;
  }

  public Fourmi getLaFourmi() {
    return laFourmi;
  }

  public void setLaFourmi(Fourmi laFourmi) {
    this.laFourmi = laFourmi;
  }
  
  protected double nombreAleatoire(double min, double max) {
    return (Math.random() * (max - min)) + min;
  }

  public abstract void step();
}
