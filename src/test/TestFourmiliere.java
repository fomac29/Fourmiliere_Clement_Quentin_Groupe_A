package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import etape.Adulte;
import etape.Etape;
import etape.Larve;
import etape.Nymphe;
import etape.Oeuf;
import fourmi.Femelle;
import fourmi.Fourmi;
import fourmi.Male;
import fourmi.Ouvrier;
import fourmi.Role;
import fourmi.Soldat;
import terrain.Fourmiliere;
import terrain.Terrain;

class TestFourmiliere {
  Terrain leTerrain;
  Fourmi laReineDesFourmis;
  Fourmiliere laFourmiliere;

  @BeforeEach
  void setUp() {
    this.leTerrain = new Terrain();
    this.laFourmiliere = this.leTerrain.getLaFourmiliere();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
  }

  @Test
  void testInit() {
    assertTrue(((Adulte) this.laReineDesFourmis.getlEtape()).getLeRole() instanceof Femelle);
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
    assertEquals(this.laFourmiliere.getNombreLarves(), 0);
    assertEquals(this.laFourmiliere.getNombreNymphes(), 0);
    assertEquals(this.laFourmiliere.getNombreFemelles(), 1);
    assertEquals(this.laFourmiliere.getNombreMales(), 0);
    assertEquals(this.laFourmiliere.getNombreSoldats(), 0);
    assertEquals(this.laFourmiliere.getNombreOuvriers(), 0);
  }

  @Test
  void testChercherFourmi() {
    assertTrue(this.laFourmiliere.chercherFourmi(this.laReineDesFourmis));
  }

  @Test
  void testEvolutionFourmi() {
    Fourmi laFourmis = new Fourmi();

    laFourmis.setLaFourmiliere(this.laFourmiliere);

    assertTrue(laFourmis.getlEtape() instanceof Oeuf);

    for (int i = 0; i < 3; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Larve);

    for (int i = 0; i < 10; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Nymphe);

    for (int i = 0; i < 10; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Adulte);

    int esperanceDeVieDeLaFourmi = ((Adulte) laFourmis.getlEtape()).getLeRole().getEsperanceDeVie();

    for (int i = 0; i < esperanceDeVieDeLaFourmi; i++) {
      laFourmis.step();
    }

    assertFalse(this.laFourmiliere.chercherFourmi(laFourmis));
  }

  @Test
  void testReinePondreOeuf() {
    assertTrue(this.leTerrain.isPrintemps());
    assertTrue(this.laFourmiliere.getNombreOeufs() == 0);
    this.laReineDesFourmis.step();
    assertTrue(this.laFourmiliere.getNombreOeufs() >= 10);
    assertTrue(this.laFourmiliere.getNombreOeufs() <= 20);
    List<Fourmi> lesFourmis = this.laFourmiliere.getLesFourmis();
    for (Fourmi uneFourmi : lesFourmis) {
      assertTrue(uneFourmi.getlEtape() instanceof Oeuf);
    }
  }

  @Test
  void testPondrePasAuPrintemps() {
    this.leTerrain.setJourCourant(91);
    assertFalse(this.leTerrain.isPrintemps());
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
    this.laReineDesFourmis.step();
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
  }

  @Test
  void testEvolutionPopulation() {
    int nombreOeufs;
    int nombreLarves;
    int nombreNymphes;
    int nombreOuvriers = 0;
    int nombreSoldats = 0;
    int nombreMales = 0;
    int nombreFemelles = 0;

    int nbNymphes = this.laFourmiliere.getNombreNymphes();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

    while (this.laReineDesFourmis != null || nbNymphes != 0) {
      this.leTerrain.step();
      this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
      nbNymphes = this.laFourmiliere.getNombreNymphes();

      nombreOeufs = 0;
      nombreLarves = 0;
      nombreNymphes = 0;
      nombreOuvriers = 0;
      nombreSoldats = 0;
      nombreMales = 0;
      // La Reine des fourmis est une reine
      if (this.laReineDesFourmis != null) {
        nombreFemelles = 1;
      } else {
        nombreFemelles = 0;
      }

      List<Fourmi> lesFourmis = this.laFourmiliere.getLesFourmis();
      Etape lEtapeDeLaFourmi;
      Role leRoleDeLaFourmi;

      for (Fourmi uneFourmi : lesFourmis) {
        lEtapeDeLaFourmi = uneFourmi.getlEtape();
        if (lEtapeDeLaFourmi instanceof Oeuf) {
          nombreOeufs++;
        } else if (lEtapeDeLaFourmi instanceof Larve) {
          nombreLarves++;
        } else if (lEtapeDeLaFourmi instanceof Nymphe) {
          nombreNymphes++;
        } else if (lEtapeDeLaFourmi instanceof Adulte) {
          leRoleDeLaFourmi = ((Adulte) lEtapeDeLaFourmi).getLeRole();
          if (leRoleDeLaFourmi instanceof Ouvrier) {
            nombreOuvriers++;
          } else if (leRoleDeLaFourmi instanceof Soldat) {
            nombreSoldats++;
          } else if (leRoleDeLaFourmi instanceof Male) {
            nombreMales++;
          } else if (leRoleDeLaFourmi instanceof Femelle) {
            nombreFemelles++;
          }
        }
      }

      assertEquals(nombreOeufs, this.laFourmiliere.getNombreOeufs());
      assertEquals(nombreLarves, this.laFourmiliere.getNombreLarves());
      assertEquals(nombreNymphes, this.laFourmiliere.getNombreNymphes());
      assertEquals(nombreOuvriers, this.laFourmiliere.getNombreOuvriers());
      assertEquals(nombreSoldats, this.laFourmiliere.getNombreSoldats());
      assertEquals(nombreMales, this.laFourmiliere.getNombreMales());
      assertEquals(nombreFemelles, this.laFourmiliere.getNombreFemelles());
    }

    assertEquals(this.laFourmiliere.getNombreNymphes(), 0);
    assertNull(this.laFourmiliere.getLaReineDesFourmis());
  }

  @Test
  void testRepartitionPopulation() {
    int nombreOuvriers = 0;
    int nombreSoldats = 0;
    int nombreMales = 0;
    int nombreFemelles = 0;

    int nbNymphes = this.laFourmiliere.getNombreNymphes();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

    int margeErreurPourcentage = 3;

    int nbTests = 5000;
    int nbEchecs = 0;

    for (int i = 0; i < nbTests; i++) {
      double pourcentageOuvrieresAttendu = this.laFourmiliere.getPourcentageOuvrieres() * 100;
      double pourcentageSoldatsAttendu =
          (this.laFourmiliere.getPourcentageSoldats() * 100) - pourcentageOuvrieresAttendu;
      double pourcentageSexuesAttendu = this.laFourmiliere.getPourcentageSexues() * 100;
      
      int nbTestsSimulationEnCours = 0;
      int nbEchecsSimulationEnCours = 0;

      while (this.laReineDesFourmis != null || nbNymphes != 0) {
        this.leTerrain.step();
        this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
        nbNymphes = this.laFourmiliere.getNombreNymphes();

        nombreOuvriers = laFourmiliere.getNombreOuvriers();
        nombreSoldats = laFourmiliere.getNombreSoldats();
        nombreMales = laFourmiliere.getNombreMales();
        nombreFemelles = laFourmiliere.getNombreFemelles();

        int totalFourmisActives = nombreOuvriers + nombreSoldats + nombreMales + nombreFemelles;

        if (totalFourmisActives >= 1000) {
          double pourcentageReelOuvriers = (nombreOuvriers * 100) / totalFourmisActives;
          double pourcentageReelSoldats = (nombreSoldats * 100) / totalFourmisActives;
          double pourcentageReelSexues =
              ((nombreMales + nombreFemelles) * 100) / totalFourmisActives;

          if (pourcentageReelOuvriers < (pourcentageOuvrieresAttendu - margeErreurPourcentage)
              || pourcentageReelOuvriers > (pourcentageOuvrieresAttendu + margeErreurPourcentage)
              || pourcentageReelSoldats < (pourcentageSoldatsAttendu - margeErreurPourcentage)
              || pourcentageReelSoldats > (pourcentageSoldatsAttendu + margeErreurPourcentage)
              || pourcentageReelSexues < pourcentageSexuesAttendu - margeErreurPourcentage
              || pourcentageReelSexues > (pourcentageSexuesAttendu + margeErreurPourcentage)) {
            nbEchecsSimulationEnCours++;
          }
          
          nbTestsSimulationEnCours++;
        }
      }

      this.leTerrain = new Terrain();
      this.laFourmiliere = this.leTerrain.getLaFourmiliere();
      this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

      int pourcentageEchecsSimulationEnCours =
          (nbEchecsSimulationEnCours * 100) / nbTestsSimulationEnCours;

     System.err.println("Test numéro " + i + " Nombre d'échecs du test : " + nbEchecsSimulationEnCours + "\t"
          + "Pourcentage d'échec du test : " + pourcentageEchecsSimulationEnCours + "%");

      if (pourcentageEchecsSimulationEnCours > 5) {
        nbEchecs++;
      }
    }

    int pourcentageEchecs = (nbEchecs * 100) / nbTests;
    System.err.println("Nombre d'échecs total : " + nbEchecs + "\t" + "Pourcentage d'échec total : "
        + pourcentageEchecs + "%");
    assertTrue(pourcentageEchecs <= 20);
  }
}
