package etape;

import fourmi.Fourmi;

public abstract class Etape {
  Fourmi laFourmi;

  public Etape(Fourmi uneFourmi) {
    this.laFourmi = uneFourmi;
  }

  public abstract void step();
}
