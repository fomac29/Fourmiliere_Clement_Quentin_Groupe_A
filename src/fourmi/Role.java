package fourmi;

import etape.Adulte;

/**
 * Rôle de la fourmi qui lui est assignée lorsqu'elle devient adulte.
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public abstract class Role {
  /**
   * Permet d'accéder à la reférence de la fourmi et de la fourmilière.
   */
  Adulte lAdulte;
  
  /**
   * Temps de vie de la fourmi qui est décrémenté à chaque pas de la simulation.
   * La fourmi meure lorsque celui-ci arrive à 0.
   */
  Integer esperanceDeVie;
  
  public Role(Adulte adulte) {
    this.lAdulte = adulte;
    // Une fourmi vie entre 1,5 ans et 2,5 ans
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
