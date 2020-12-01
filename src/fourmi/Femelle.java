package fourmi;

import etape.Adulte;

public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
  }

  @Override
  public void step() {

  }

  public void devenirReine() {
    super.lAdulte.setLeRole(new Reine(super.lAdulte));
  }
}
