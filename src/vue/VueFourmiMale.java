package vue;

import java.awt.Color;

public class VueFourmiMale extends VueFourmiAdulte {

  public VueFourmiMale(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.blue);
  }

}
