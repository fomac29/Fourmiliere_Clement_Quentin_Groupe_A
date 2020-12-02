package fourmi;

import java.awt.Color;
import java.awt.Dimension;
import etape.Adulte;
import graphicLayer.GOval;
import graphicLayer.GRect;
import terrain.Fourmiliere;

public class Ouvrier extends Role {
  
  public Ouvrier(Adulte adulte) {
    super(adulte);
    this.representationGraphique = new GOval();
    this.representationGraphique.setColor(Color.orange);
    this.representationGraphique.setDimension(new Dimension(10, 10));
    GRect laVueTerrain = this.lAdulte.getLaFourmi().getLaFourmiliere().getLeTerrain().getLaVueTerrain().
    getTerrain();
    laVueTerrain.addElement(this.representationGraphique);
    laVueTerrain.repaint();
  }

  @Override
  public void step() {
    this.esperanceDeVie--;
    if (esperanceDeVie == 0) {
      this.mourir();
      Fourmiliere laFourmiliere = this.lAdulte.getLaFourmi().getLaFourmiliere();
      laFourmiliere.decrementerNombreOuvriers();
    }
    
    else {
      
    }
  }
}
