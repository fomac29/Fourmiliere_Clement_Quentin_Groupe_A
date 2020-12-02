package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GRect;

public class VueFourmiliere {
  
  private GRect composantFourmiliere;
  
  public VueFourmiliere() {
    this.composantFourmiliere = new GRect();
    this.composantFourmiliere.setColor(Color.BLACK);
    this.composantFourmiliere.setPosition(new Point(0, 0));
    this.composantFourmiliere.setDimension(new Dimension(50, 50));
  }
  
  public GRect getComposantFourmiliere() {
    return composantFourmiliere;
  }
  
}
