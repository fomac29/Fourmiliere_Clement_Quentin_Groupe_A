package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GOval;
import graphicLayer.GRect;

public class VueFourmiliere {

  private GRect composantFourmiliere;
  VueTerrain laVueTerrain;

  public VueFourmiliere(VueTerrain uneVueTerrain) {
    this.laVueTerrain = uneVueTerrain;
    this.composantFourmiliere = new GRect();
    this.composantFourmiliere.setColor(new Color(88, 41, 0));
    this.composantFourmiliere.setPosition(new Point(247, 247));
    this.composantFourmiliere.setDimension(new Dimension(50, 50));
    this.laVueTerrain.ajouterFourmiliere(this.composantFourmiliere);
  }

  public void ajouterFourmi(GOval laFourmi) {
    int milieurHorizontal = (int) (this.composantFourmiliere.getX()
        + (this.composantFourmiliere.getWidth() / 2) - laFourmi.getWidth());
    int milieurVertical = (int) (this.composantFourmiliere.getY()
        + (this.composantFourmiliere.getHeight() / 2) - laFourmi.getHeight());
    laFourmi.setPosition(new Point(milieurHorizontal, milieurVertical));
    this.laVueTerrain.ajouterFourmi(laFourmi);
  }

  public GRect getComposantFourmiliere() {
    return composantFourmiliere;
  }

  public VueTerrain getLaVueTerrain() {
    return this.laVueTerrain;
  }

}
