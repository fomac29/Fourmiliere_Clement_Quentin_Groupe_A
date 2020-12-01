package fourmi;

import etape.Adulte;

public class Femelle extends Sexue {

  public Femelle(Fourmi uneFourmi) {
    super(uneFourmi);
  }

  @Override
  public void step() {

  }

  public void devenirReine() {
    ((Adulte) super.laFourmi.getlEtape()).setLeRole(new Reine(super.laFourmi));
  }
}
