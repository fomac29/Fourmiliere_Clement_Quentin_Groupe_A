package etape;

import fourmi.Fourmi;

public abstract class Etape {
  Fourmi laFourmi;

  public Etape(Fourmi uneFourmi) {
    this.laFourmi = uneFourmi;
  }
  
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
