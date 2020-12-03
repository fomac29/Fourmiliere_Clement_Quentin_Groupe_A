package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import graphicLayer.GBounded;
import graphicLayer.GOval;
import graphicLayer.GRect;
import graphicLayer.GSpace;

public class VueTerrain {
  
  private final int hauteurTerrain = 500;
  private final int largeurTerrain = 500;
  private GSpace fenetre;
  private GBounded terrain;
  
  public VueTerrain() {
    fenetre = new GSpace("Terrain", new Dimension(550, 550));
    fenetre.open();
  }

  
  public void ajouterTerrain() {
    terrain = new GBounded();
    terrain.setColor(Color.green);
    terrain.setPosition(new Point(30, 30));
    terrain.setDimension(new Dimension(hauteurTerrain, largeurTerrain));
    
    fenetre.addElement(terrain);
  }
  
  public void ajouterFourmiliere(GRect composantGraphiqueFourmiliere) {
    this.terrain.addElement(composantGraphiqueFourmiliere);
  }
  
  public void ajouterFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.addElement(composantGraphiqueFourmi);
    composantGraphiqueFourmi.repaint();
  }
  
  public void supprimerFourmi(GOval composantGraphiqueFourmi) {
    this.terrain.removeElement(composantGraphiqueFourmi);
  }
  
  public void ajouterProie(GRect composantGraphiqueProie) {
    this.terrain.addElement(composantGraphiqueProie);
    composantGraphiqueProie.repaint();
  }
  
  public void supprimerProie(GRect composantGraphiqueProie) {
    this.terrain.removeElement(composantGraphiqueProie);
  }

  public GBounded getTerrain() {
    return terrain;
  }

  public int getHauteurTerrain() {
    return hauteurTerrain;
  }

  public int getLargeurTerrain() {
    return largeurTerrain;
  }
}
