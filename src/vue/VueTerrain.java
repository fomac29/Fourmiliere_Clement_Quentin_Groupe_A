package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GBounded;
import graphicLayer.GRect;
import graphicLayer.GSpace;

public class VueTerrain {
  
  private GSpace fenetre;
  private GBounded terrain;
  
  public VueTerrain() {
    this.InitialiserVue();
  }
  
  public void InitialiserVue() {
    fenetre = new GSpace("Terrain", new Dimension(800, 800));
    
    terrain = new GBounded();
    terrain.setColor(Color.GREEN);
    terrain.setPosition(new Point(30, 30));
    terrain.setDimension(new Dimension(700, 700));
    
    fenetre.addElement(terrain);
    fenetre.open();
  }

  public GBounded getTerrain() {
    return terrain;
  }
  
}
