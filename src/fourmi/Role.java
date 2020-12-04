package fourmi;

import etape.Adulte;

/**
 * Role de la fourmi qui lui est assignee lorsqu'elle devient adulte.
 * 
 * @author Clement Stoliaroff, Quentin Tassy
 *
 */
public abstract class Role {
  /**
   * Permet d'acceder a la reference de la fourmi et de la fourmiliere.
   */
  Adulte lAdulte;

  /**
   * Temps de vie de la fourmi qui est decremente a chaque pas de la simulation. La fourmi meure
   * lorsque celui-ci arrive a 0.
   */
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

  public Integer getEsperanceDeVie() {
    return esperanceDeVie;
  }

  public void setEsperanceDeVie(Integer esperanceDeVie) {
    this.esperanceDeVie = esperanceDeVie;
  }

  public abstract void step();
}
