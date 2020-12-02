package vue;

import java.awt.Dimension;
import graphicLayer.GSpace;

public class VueTerrain {
  
  private GSpace fenetre;
  
  public VueTerrain() {
    this.InitialiserVue();
  }
  
  public void InitialiserVue() {
    fenetre = new GSpace("Terrain", new Dimension(800, 600));
    fenetre.open();
  }

  public GSpace getFenetre() {
    return fenetre;
  }
  
}
