package fourmi;

public abstract class Role {
  Fourmi laFourmi;

  public Role(Fourmi uneFourmi) {
    this.laFourmi = uneFourmi;
  }

  public abstract void step();
}
