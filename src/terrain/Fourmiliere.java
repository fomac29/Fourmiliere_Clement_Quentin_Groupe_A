package terrain;

import java.util.ArrayList;
import java.util.List;

import etape.Adulte;
import etape.Etape;
import etape.Larve;
import etape.Nymphe;
import etape.Oeuf;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;

public class Fourmiliere {
	List<Fourmi> lesFourmis;
	
	public Fourmiliere(Fourmi reine) {
		this.lesFourmis = new ArrayList<Fourmi>();
		this.lesFourmis.add(reine);
	}
	
	public void step() {
		for(Fourmi uneFoumi : this.lesFourmis) {
			uneFoumi.step();
		}
	}
	
	public void ajouterFourmi(Fourmi uneFourmi) {
		this.lesFourmis.add(uneFourmi);
	}
	
	@Override
	public String toString() {
		int nombreOeuf = 0;
		int nombreLarve = 0;
		int nombreNymphe = 0;
		int nombreOuvrier = 0;
		int nombreSoldats = 0;
		int nombreMale = 0;
		int nombreFemelle = 0;
		
		for(Fourmi uneFoumi : this.lesFourmis) {
			Etape lEtape = uneFoumi.getlEtape();
			if(lEtape instanceof Oeuf) {
				nombreOeuf++;
			}
			
			else if(lEtape instanceof Larve) {
				nombreLarve++;
			}
			
			else if(lEtape instanceof Nymphe) {
				nombreNymphe++;
			}
			
			else {
				Adulte adulte = (Adulte) lEtape;
				Role leRole = adulte.getLeRole();
				
				if(leRole instanceof Ouvrier) {
					nombreOuvrier++;
				}
				
				else if(leRole instanceof Male) {
					nombreMale++;
				}
				
				else {
					nombreFemelle++;
				}
			}
		}
		
		String res = "Fourmilière :";
		res += "\n\t- Nombre d'oeufs : " + nombreOeuf;
		res += "\n\t- Nombre de larves : " + nombreLarve;
		res += "\n\t- Nombre de nymphes : " + nombreNymphe;
		res += "\n\t- Nombre d'ouvrières : " + nombreOuvrier;
		res += "\n\t- Nombre de soldats : " + nombreSoldats;
		res += "\n\t- Nombre de mâles : " + nombreMale;
		res += "\n\t- Nombre de femelles : " + nombreFemelle;
		
		return res;
	}
	
	
}
