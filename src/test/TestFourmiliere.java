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

  /**
   * Initialise le terrain et mémorise sa fourmilièe et sa reine
   */
  @BeforeEach
  void setUp() {
    this.leTerrain = new Terrain();
    this.laFourmiliere = this.leTerrain.getLaFourmiliere();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
  }

  /**
   * Test de l'initialisation de la fourmilière
   */
  @Test
  void testInit() {
    assertTrue(((Adulte) this.laReineDesFourmis.getlEtape()).getLeRole() instanceof Femelle);
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
    assertEquals(this.laFourmiliere.getNombreLarves(), 0);
    assertEquals(this.laFourmiliere.getNombreNymphes(), 0);
    // La reine des fourmis est une femelle
    assertEquals(this.laFourmiliere.getNombreFemelles(), 1);
    assertEquals(this.laFourmiliere.getNombreMales(), 0);
    assertEquals(this.laFourmiliere.getNombreSoldats(), 0);
    assertEquals(this.laFourmiliere.getNombreOuvriers(), 0);
  }

  /**
   * Vérifie que la reine est bien dans la fourmilière
   */
  @Test
  void testChercherFourmi() {
    assertTrue(this.laFourmiliere.chercherFourmi(this.laReineDesFourmis));
  }

  /**
   * Test qu'une fourmi passe d'une étape de sa vie à la suivante après que le temps qu'elle doit
   * normalement passer à cette étape doit écoulé, puis qu'elle disparaisse de la fourmiliere une
   * fois quelle doivent mourir
   */
  @Test
  void testEvolutionFourmi() {

    Fourmi laFourmis = new Fourmi();
    laFourmis.setLaFourmiliere(this.laFourmiliere);

    // Une fourmi commence à l'état d'oeuf
    assertTrue(laFourmis.getlEtape() instanceof Oeuf);

    // La fourmi passe à l'état de larve après 3 jours
    for (int i = 0; i < 3; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Larve);

    // La fourmi passe à l'état de nymphe après 10 jours
    for (int i = 0; i < 10; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Nymphe);

    // La fourmi devient adulte après 10 jours
    for (int i = 0; i < 10; i++) {
      laFourmis.step();
    }

    assertTrue(laFourmis.getlEtape() instanceof Adulte);

    int esperanceDeVieDeLaFourmi = ((Adulte) laFourmis.getlEtape()).getLeRole().getEsperanceDeVie();

    // Une fois son esperance de vie achevee, la fourmi meurt
    for (int i = 0; i < esperanceDeVieDeLaFourmi; i++) {
      laFourmis.step();
    }

    // Lorsqu'une fourmi meurt, elle n'est plus compté comme étant dans la fourmilière
    assertFalse(this.laFourmiliere.chercherFourmi(laFourmis));
    assertNull(laFourmis.getLaFourmiliere());
  }

  /**
   * La reine doit pondre entre 10 et 20 oeufs lorsque c'est le printemps
   */
  @Test
  void testReinePondreOeuf() {
    assertTrue(this.leTerrain.isPrintemps());
    assertTrue(this.laFourmiliere.getNombreOeufs() == 0);
    // La reine ponds ses oeufs
    this.laReineDesFourmis.step();

    // Il doit y avoir entre 10 et 20 oeuf
    assertTrue(this.laFourmiliere.getNombreOeufs() >= 10);
    assertTrue(this.laFourmiliere.getNombreOeufs() <= 20);

    // Actuellement, toutes les fourmis doivent etre des oeufs
    List<Fourmi> lesFourmis = this.laFourmiliere.getLesFourmis();
    for (Fourmi uneFourmi : lesFourmis) {
      assertTrue(uneFourmi.getlEtape() instanceof Oeuf);
    }
  }

  /**
   * Verifie que la reine des fourmis ne ponds pa en dehors du printemps
   */
  @Test
  void testPondrePasAuPrintemps() {
    // Le printemps dure 90 jours dans l'année
    this.leTerrain.setJourCourant(91);
    assertFalse(this.leTerrain.isPrintemps());
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
    this.laReineDesFourmis.step();
    assertEquals(this.laFourmiliere.getNombreOeufs(), 0);
  }

  /**
   * La fourmilière mémorisant le nombre de chaque types de fourmis, on vérifie que ces nombres sont
   * corrects tout au long de la simulation et on fini par verifier que la condition de fin de la
   * simulation sont correctes (la reine des fourmis doit être morte et il ne doit plus y avoir de
   * nymphes)
   */
  @Test
  void testEvolutionPopulation() {
    // Ces variables serviront a compter le nombre de chaque type de fourmi
    int nombreOeufs;
    int nombreLarves;
    int nombreNymphes;
    int nombreOuvriers = 0;
    int nombreSoldats = 0;
    int nombreMales = 0;
    int nombreFemelles = 0;

    int nbNymphes = this.laFourmiliere.getNombreNymphes();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

    // On lance la simulation
    while (this.laReineDesFourmis != null || nbNymphes != 0) {
      this.leTerrain.step();

      this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
      nbNymphes = this.laFourmiliere.getNombreNymphes();

      // A chaque tour, on reinitialise le nombre de chaque type de fourmis
      nombreOeufs = 0;
      nombreLarves = 0;
      nombreNymphes = 0;
      nombreOuvriers = 0;
      nombreSoldats = 0;
      nombreMales = 0;
      /*
       * La Reine des fourmis est une femelle, donc si elle est vivante, il y a au moins une femelle
       * dans la fourmilière
       */
      if (this.laReineDesFourmis != null) {
        nombreFemelles = 1;
      } else {
        nombreFemelles = 0;
      }

      // On recupere la liste des fourmisde la fourmiliere
      List<Fourmi> lesFourmis = this.laFourmiliere.getLesFourmis();
      Etape lEtapeDeLaFourmi;
      Role leRoleDeLaFourmi;

      // On compte le nombre de chaque type de fourmis
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

      // On verifie que le nombre de chaque type de fourmi corresponds à la realite
      assertEquals(nombreOeufs, this.laFourmiliere.getNombreOeufs());
      assertEquals(nombreLarves, this.laFourmiliere.getNombreLarves());
      assertEquals(nombreNymphes, this.laFourmiliere.getNombreNymphes());
      assertEquals(nombreOuvriers, this.laFourmiliere.getNombreOuvriers());
      assertEquals(nombreSoldats, this.laFourmiliere.getNombreSoldats());
      assertEquals(nombreMales, this.laFourmiliere.getNombreMales());
      assertEquals(nombreFemelles, this.laFourmiliere.getNombreFemelles());
    }

    // On verifie que les conditions de fin de la simulation sont correctes
    assertEquals(this.laFourmiliere.getNombreNymphes(), 0);
    assertNull(this.laFourmiliere.getLaReineDesFourmis());
  }

  /**
   * On verifie que le pourcentage de chaque type de fourmis corresponds à ce qui est attendu par la
   * fourmiliere pendant toute la duree de la simulation (ATTENTION : ce test peut prendre beaucoup
   * de temps (environ 20 minutes pour 10 000 simulations), en effet il se base sur plusieurs
   * simulations, la duree de ce test depends donc du nombre de simulation effectuees).
   */
  @Test
  void testRepartitionPopulation() {
    // On va memoriser le nombre de chaque type de fourmi adulte dans la fourmiliere
    int nombreOuvriers = 0;
    int nombreSoldats = 0;
    int nombreMales = 0;
    int nombreFemelles = 0;

    int nbNymphes = this.laFourmiliere.getNombreNymphes();
    this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

    // On accepte une marge d'erreur de 3% autours du pourcentage de chaque type demande
    int margeErreurPourcentage = 3;

    // Defini le nombre de simulation a effectue
    int nbTests = 10000;

    /*
     * On va compter le nombe de simulation n'arrive pas a garder leur population autours du seuil
     * attendu
     */
    int nbEchecs = 0;


    for (int i = 0; i < nbTests; i++) {
      // On recupere le pourcentage de chaque type de fourmis attendu
      double pourcentageOuvrieresAttendu = this.laFourmiliere.getPourcentageOuvrieres() * 100;
      double pourcentageSoldatsAttendu =
          (this.laFourmiliere.getPourcentageSoldats() * 100) - pourcentageOuvrieresAttendu;
      double pourcentageSexuesAttendu = this.laFourmiliere.getPourcentageSexues() * 100;

      /*
       * On va compte le nombre de tests effectues durant la simulation et le nombre d'echec parmis
       * ceux-ci
       */
      int nbTestsSimulationEnCours = 0;
      int nbEchecsSimulationEnCours = 0;

      // On demarre une simulation
      while (this.laReineDesFourmis != null || nbNymphes != 0) {
        this.leTerrain.step();
        this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();
        nbNymphes = this.laFourmiliere.getNombreNymphes();

        // On recupere le nombre de chaque type de fourmis
        nombreOuvriers = laFourmiliere.getNombreOuvriers();
        nombreSoldats = laFourmiliere.getNombreSoldats();
        nombreMales = laFourmiliere.getNombreMales();
        nombreFemelles = laFourmiliere.getNombreFemelles();

        // On calcule le nombre de fourmi adulte
        int totalFourmisActives = nombreOuvriers + nombreSoldats + nombreMales + nombreFemelles;

        /*
         * On test la population de fourmis a partir de 1000 fourmis dans la fourmiliere (sinon il y
         * en a trop peu pour que le test soit representatif)
         */
        if (totalFourmisActives >= 1000) {
          // On calcule le pourcentage de chaque type de fourmis adulte
          double pourcentageReelOuvriers = (nombreOuvriers * 100) / totalFourmisActives;
          double pourcentageReelSoldats = (nombreSoldats * 100) / totalFourmisActives;
          double pourcentageReelSexues =
              ((nombreMales + nombreFemelles) * 100) / totalFourmisActives;

          /*
           * Les pourcentages doit etre superieur ou egal au pourcentage attendu moins la marge
           * d'erreur et inferieur ou egal au pourcentage attendu plus la marge d'erreur
           */
          if (pourcentageReelOuvriers < (pourcentageOuvrieresAttendu - margeErreurPourcentage)
              || pourcentageReelOuvriers > (pourcentageOuvrieresAttendu + margeErreurPourcentage)
              || pourcentageReelSoldats < (pourcentageSoldatsAttendu - margeErreurPourcentage)
              || pourcentageReelSoldats > (pourcentageSoldatsAttendu + margeErreurPourcentage)
              || pourcentageReelSexues < pourcentageSexuesAttendu - margeErreurPourcentage
              || pourcentageReelSexues > (pourcentageSexuesAttendu + margeErreurPourcentage)) {
            nbEchecsSimulationEnCours++;
          }

          /*
           * Etant donne qu'on effectue le test uniquement quand il y a au moin 1000 fourmis, on
           * memorise le nombre de tests effectues durant la simulation
           */
          nbTestsSimulationEnCours++;
        }
      }

      /*
       * On reinitialise le terrain, la fourmiliere et la reine des fourmis pour une nouvelle
       * simulation
       */
      this.leTerrain = new Terrain();
      this.laFourmiliere = this.leTerrain.getLaFourmiliere();
      this.laReineDesFourmis = this.laFourmiliere.getLaReineDesFourmis();

      // On calcule le pourcentage d'
      double pourcentageEchecsSimulationEnCours =
          (((double) nbEchecsSimulationEnCours) * 100) / nbTestsSimulationEnCours;

      /*
       * Etant donne qu'on compte les erreurs, on affiche dans la console d'erreur le resultat de la
       * simulation en cours
       */
      System.err.println("Simulation numéro " + (i + 1) + " : Nombre d'échecs : "
          + nbEchecsSimulationEnCours + " Nombre de tests : " + nbTestsSimulationEnCours
          + " Pourcentage d'échec du test : " + pourcentageEchecsSimulationEnCours + "%");

      // S'il y a plus de 5% d'erreur durant la simulation, celle-ci est un echec
      if (pourcentageEchecsSimulationEnCours > 5) {
        nbEchecs++;
      }
    }

    // On calcule le pourcentage de simulations echouees
    double pourcentageEchecs = (((double) nbEchecs) * 100) / ((double) nbTests);

    /*
     * Etant donne qu'on compte les simulations echouees, on affiche dans la console d'erreur le
     * resultat du test, afin de connaitre  le taux d'echec
     */
    System.err.println("Nombre d'échecs total : " + nbEchecs + "\t" + "Pourcentage d'échec total : "
        + pourcentageEchecs + "%");
    
    // On accepte 10% de simulations echouees
    assertTrue(pourcentageEchecs <= 10);
  }
}
