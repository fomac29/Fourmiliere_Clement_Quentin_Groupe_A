package vue;

import java.awt.Color;

public class VueSoldat extends VueFourmiAdulte {

  public VueSoldat(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.darkGray);
  }

}
