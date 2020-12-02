package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GRect;
import graphicLayer.GSpace;

public class VueTerrain {
  
  private GSpace fenetre;
  private GRect terrain;
  
  public VueTerrain() {
    this.InitialiserVue();
  }
  
  public void InitialiserVue() {
    fenetre = new GSpace("Terrain", new Dimension(500, 500));
    terrain = new GRect();
    terrain.withoutBorder();
    terrain.setColor(Color.GREEN);
    terrain.setPosition(new Point(30, 30));
    terrain.setDimension(new Dimension(300, 300));
    fenetre.addElement(terrain);
    fenetre.open();
    
  }

  public GRect getTerrain() {
    return terrain;
  }
  
}
