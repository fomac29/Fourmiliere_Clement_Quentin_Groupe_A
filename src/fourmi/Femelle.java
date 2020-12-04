package fourmi;

import etape.Adulte;
import vue.VueFourmiFemelle;

/**
 * Représente une fourmi sexuée femelle
 * 
 * @author Clément Stoliaroff, Quentin Tassy
 */
public class Femelle extends Sexue {

  public Femelle(Adulte adulte) {
    super(adulte);
    this.lAdulte.setComposantGraphique(new VueFourmiFemelle(
        this.lAdulte.getLaFourmi().getLaFourmiliere().getLaVueFourmiliere()));
  }

  /**
   * La fourmi meure si elle atteint la fin de sa vie, sinon elle se déplace aléatoirement
   */
  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.lAdulte.getLaFourmi().getLaFourmiliere().decrementerNombreFemelles();
      this.lAdulte.mourir();
    }
    
    else {
      this.lAdulte.deplacerComposantFourmi();
    }
  }

  public void devenirReine() {
    this.lAdulte.setLeRole(new Reine(super.lAdulte));
  }
}
