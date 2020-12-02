package fourmi;

import etape.Adulte;

public abstract class Role {
  Adulte lAdulte;
  Integer esperanceDeVie;
  
  public Role(Adulte adulte) {
    this.lAdulte = adulte;
    this.esperanceDeVie = (int) (Math.random() * (912 - 548)) + 548;
  }

  public Adulte getlAdulte() {
    return lAdulte;
  }

  public void setlAdulte(Adulte lAdulte) {
    this.lAdulte = lAdulte;
  }

  public abstract void step();
}
