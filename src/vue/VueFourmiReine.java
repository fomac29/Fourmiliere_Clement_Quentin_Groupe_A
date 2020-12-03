package vue;

import java.awt.Color;

public class VueFourmiReine extends VueFourmiAdulte {
  
  public VueFourmiReine(VueFourmiliere laVueDeLaFourmiliere) {
    super(laVueDeLaFourmiliere);
    this.composantGraphique.setColor(Color.CYAN);
  }
}
