package vue;

import java.awt.Color;

public class VueOuvrier extends VueFourmiAdulte {
  public VueOuvrier(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.orange);
  }
}
