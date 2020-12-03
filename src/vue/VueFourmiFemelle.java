package vue;

import java.awt.Color;

public class VueFourmiFemelle extends VueFourmiAdulte {

  public VueFourmiFemelle(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.pink);
  }

}
