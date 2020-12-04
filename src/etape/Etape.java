package etape;

import fourmi.Fourmi;

/**
 * Represente l'etape de la vie de la fourmi : Oeuf, Larve, Nyphe ou Adulte
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 */
public abstract class Etape {
  Fourmi laFourmi;

  public Etape(Fourmi uneFourmi) {
    this.laFourmi = uneFourmi;
  }
  
  /**
   * Le constructeur vide sert à initialiser la premiere reine des fourmis
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

  public abstract void step();
}
