package fourmi;

import etape.Adulte;
import terrain.Fourmiliere;

public class Ouvrier extends Role {
  
  public Ouvrier(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreOuvriers();
    }
  }
}
