package fourmi;

import etape.Adulte;

public abstract class Role {
  Adulte lAdulte;

  public Role(Adulte adulte) {
    this.lAdulte = adulte;
  }

  public Adulte getlAdulte() {
    return lAdulte;
  }

  public void setlAdulte(Adulte lAdulte) {
    this.lAdulte = lAdulte;
  }

  public abstract void step();
}
