package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.Database;
import business.services.MaterialListFacade;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalcMaterialListCommandTest {
   private final static String USER = "root";

   private final static String PASSWORD = "kisshu25";
   private final static String URL = "jdbc:mysql://localhost:3306/new_fog?serverTimezone=CET&allowMultiQueries=true";

   public static Database database;

   private static MaterialListFacade materialListFacade;

   static ArrayList<WoodPiece> woodPieces;
   static CTSCladdingOption cladding;
   static ArrayList<RoofMaterialOption> roofMaterials;
   static ArrayList<Screw> screws;
   static ArrayList<WoodConnector> woodConnectors;
   static ArrayList<CTSDoorComponent> doorComponents;

   private final static CalcMaterialListCommand calcCommand = new CalcMaterialListCommand("", "admin");
   private final static Toolshed ctsDemo = new Toolshed(600, 210, 8);
   private final static CustomCarport ccpDemo = new CustomCarport(
           600, 780, 210, false, 55, 1, 1, 0, ctsDemo);

   @BeforeAll
   public static void setUpClass() throws ClassNotFoundException {

      try{
         database = new Database(USER, PASSWORD, URL);
         materialListFacade = new MaterialListFacade(database);

         // Get all needed materialList components from the db
         woodPieces = materialListFacade.getAllWoodPieces();
         cladding = null;
         roofMaterials = materialListFacade.getAllRoofMaterial();
         screws = materialListFacade.getAllScrews();
         woodConnectors = materialListFacade.getAllWoodConnectors();
         doorComponents = null;

         if (ccpDemo.getToolshed() != null) {
            cladding = materialListFacade.getCladdingById(ccpDemo.getToolshed().getToolshedCladdingId());
            doorComponents = materialListFacade.getAllDoorComponents();
         }
      }catch(UserException | ClassNotFoundException ex){
         System.out.println(ex.getMessage());
      }
   }

   @Test
   public void testCalcUnderSternBraetFrontAndBack(){
      WoodPiece understernBraet = calcCommand.getWoodpieceById(1, woodPieces);

      int amount = calcCommand.calcUnderSternBraedderFrontAndBack(ccpDemo, understernBraet);

      assertEquals(4, amount);
   }

   @Test
   public void testCalcUnderSternBraetSides(){
      WoodPiece understernbraet = calcCommand.getWoodpieceById(2, woodPieces);

      int amount = calcCommand.calcUnderSternBraedderSides(ccpDemo, understernbraet);

      assertEquals(4, amount);
   }


   @Test
   public void testcCalcOverSternBraetFront(){
      WoodPiece understernbraet = calcCommand.getWoodpieceById(3, woodPieces);

      int amount = calcCommand.calcOverSternBraetFront(ccpDemo, understernbraet);

      assertEquals(2, amount);
   }

   @Test
   public void testCalcOverSternBraedderSides(){
      WoodPiece oversternbraet = calcCommand.getWoodpieceById(4, woodPieces);

      int amount = calcCommand.calcOverSternBraedderSides(ccpDemo, oversternbraet);

      assertEquals(4, amount);
   }





//   @Test
//   public void testCalcUnderSternBraetFrontAndBack(){
//      WoodPiece understernbraetFrontAndBack = new WoodPiece(
//             1, "Trykimp. bræt", "stk.", 17.95, "Understerbrædder til for- og bagenden",
//             200, 25, 360
//      );
//
//      MaterialListComponent component = calcCommand.calcUnderSternBraetFrontAndBack(ccpDemo, understernbraetFrontAndBack);
//
//      assertEquals(4, component.getAmount());
//   }
//
//   @Test
//   public void testCalcUnderSternBraetSides(){
//      WoodPiece understernbraetSides = new WoodPiece(
//             2, "Trykimp. bræt", "stk.", 17.95, "UnderSternbrædder til siderne",
//             200, 25, 540
//      );
//
//      MaterialListComponent component = null;
//
//      component = calcCommand.calcUnderSternBraetSides(ccpDemo, understernbraetSides);
//
//      assertEquals(4, component.getAmount());
//   }
//
//   @Test
//   public void testCalcOverSternBraetFront(){
//      WoodPiece overSternBraetFront = new WoodPiece(
//             1, "Trykimp. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
//             200, 25, 360
//      );
//
//      MaterialListComponent component = null;
//
//      component = calcCommand.calcOverSternBraetFront(ccpDemo, overSternBraetFront);
//
//      assertEquals(2, component.getAmount());
//   }
//
//   @Test
//   public void testCalcOverSternBraetSides(){
//      WoodPiece overSternBraetSides = new WoodPiece(
//             3, "Trykimpg. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
//             125, 25, 540
//      );
//
//      MaterialListComponent component = null;
//
//      component = calcCommand.calcOverSternBraetSides(ccpDemo, overSternBraetSides);
//
//      assertEquals(4, component.getAmount());
//   }
//
//   @Test
//   public void testCalcLoesholterForGables(){
//      WoodPiece loesholterForGables = new WoodPiece(
//             5, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur gavle", 95,
//             45, 270
//      );
//
//      MaterialListComponent component = null;
//
//      component = calcCommand.calcLoesholterForGables(ccpDemo, ctsDemo, loesholterForGables);
//
//      assertEquals(12, component.getAmount());
//   }
//
//   @Test
//   public void testCalcLoesholterForSides(){
//      WoodPiece loesholterForSides = new WoodPiece(
//             6, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur sider", 95,
//             45, 240
//      );
//
//      MaterialListComponent component = calcCommand.calcLoesholterForSides(ccpDemo, ctsDemo, loesholterForSides);
//
//      assertEquals(4, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRemForCCPSides(){
//      WoodPiece remForCCPSides = new WoodPiece(
//             7, "Ubh. spærtræ", "stk.", 17.95, "Remme i sider, sadles ned i stolper",
//             195, 45, 600
//      );
//
//      MaterialListComponent component = calcCommand.calcRemForCCPSides(ccpDemo, remForCCPSides);
//
//      assertEquals(2, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRemForCTSSides(){
//      WoodPiece remForCTSSides = new WoodPiece(
//             8, "Ubh. spærtræ", "stk.", 17.95,
//             "Remme i sider, sadles ned i stolper ( skur del deles)",
//             195, 45, 480
//      );
//
//      MaterialListComponent component = calcCommand.calcRemForCTSSides(ctsDemo, remForCTSSides);
//
//      assertEquals(1, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRafters(){
//      WoodPiece spaer = new WoodPiece(
//             9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
//             45, 600
//      );
//
//      MaterialListComponent component = calcCommand.calcRafters(ccpDemo, spaer);
//
//      assertEquals(15, component.getAmount());
//   }
//
//   @Test
//   public void testCalcPillars(){
//      WoodPiece pillarWood = new WoodPiece(
//             10, "Trykimp. stolpe", "stk.", 17.95, "Stolper nedgraves 90 cm. i jord",
//             97, 97, 300
//      );
//
//      MaterialListComponent component = calcCommand.calcPillars(ccpDemo, ctsDemo, pillarWood);
//
//      assertEquals(11, component.getAmount());
//   }
//
//   @Test
//   public void testCalcBraeddebeklaedning(){
//      WoodPiece braeddebeklaedning = new WoodPiece(
//             11, "Trykimp. bræt", "stk.", 17.95, "Til beklædning af skur 1 på 2",
//             100, 19, 210
//      );
//
//      MaterialListComponent component = calcCommand.calcBraeddebeklaedning(ctsDemo, braeddebeklaedning);
//
//      assertEquals(200, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRainBoardOnSides(){
//      WoodPiece rainBoard = new WoodPiece(
//             12, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i sider",
//             100, 19, 540
//      );
//
//      MaterialListComponent component = calcCommand.calcRainBoardOnSides(ccpDemo, rainBoard);
//
//      assertEquals(4, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRainBoardOnFront(){
//      WoodPiece rainBoardForFront = new WoodPiece(
//             13, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i forende",
//             100, 19, 360
//      );
//
//      MaterialListComponent component = calcCommand.calcRainBoardOnFront(ccpDemo, rainBoardForFront);
//
//      assertEquals(2, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRoofOverCCP(){
//      RoofMaterialOption roofMaterialBig = new RoofMaterialOption(
//             1, "Plastmo trapezplader", "str.", 17.95, "Monteres på spær",
//             1, 109, 600
//      );
//
//      MaterialListComponent component = calcCommand.calcRoofOverCCP(ccpDemo, ctsDemo, roofMaterialBig);
//
//      assertEquals(6, component.getAmount());
//   }
//
//   @Test
//   public void testCalcRoofOverCTS(){
//      RoofMaterialOption roofMaterial = new RoofMaterialOption(
//             1, "Plastmo trapezplader", "str.", 17.95, "Monteres på spær",
//             1, 109, 360
//      );
//
//      MaterialListComponent component = calcCommand.calcRoofOverCTS(ccpDemo, ctsDemo, roofMaterial);
//
//      assertEquals(6, component.getAmount());
//   }
//
//   @Test
//   public void testCalcScrewsForRoof(){
//      Screw screwsForRoof = new Screw(
//             1, "Plastmo bundskruer", "Pakke", 17.95, "Skruer til tagplader", 200
//      );
//
//      MaterialListComponent component = calcCommand.calcScrewsForRoof(ccpDemo, screwsForRoof);
//
//      assertEquals(3, component.getAmount());
//   }
//
//   @Test
//   public void testCalcHulbaand(){
//      WoodConnector hulbaand = new WoodConnector(
//             1, "Hulbånd 1x20mm 10mtr.", "Rulle", 17.95, "Til vindkryds på spær"
//      );
//
//      MaterialListComponent component = calcCommand.calcHulbaand(ccpDemo, ctsDemo, hulbaand);
//
//      assertEquals(1, component.getAmount());
//   }
//
//   @Test
//   public void testCalcUniversalConnectorR(){
//      WoodPiece spaer = new WoodPiece(
//             9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
//             45, 600
//      );
//
//      WoodConnector uniWoodConnectorR = new WoodConnector(
//             2, "Universal 190 mm højre", "stk.", 17.95, "Til montering af spær på rem"
//      );
//
//      MaterialListComponent materialListComponent = calcCommand.calcUniConnector(calcCommand.calcRafters(ccpDemo, spaer), uniWoodConnectorR);
//
//      assertEquals(15, materialListComponent.getAmount());
//   }
//
//   @Test
//   public void testCalcUniversalConnectorL(){
//      WoodPiece spaer = new WoodPiece(
//             9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
//             45, 600
//      );
//
//      WoodConnector uniWoodConnectorL = new WoodConnector(
//             2, "Universal 190 mm venstre", "stk.", 17.95, "Til montering af spær på rem"
//      );
//
//      MaterialListComponent materialListComponent = calcCommand.calcUniConnector(calcCommand.calcRafters(ccpDemo, spaer), uniWoodConnectorL);
//
//      assertEquals(15, materialListComponent.getAmount());
//   }
//
//   @Test
//   public void testCalcScrewsForSternAndRainBoard(){
//      Screw screwsForSternAndRainBoard = new Screw(
//             3, "Skruer 4,5 x 60 mm.", "Pakke", 17.95, "Til montering af stern & vandbrædt", 200
//      );
//
//      MaterialListComponent component = calcCommand.calcScrewsForSternAndRainBoard(ccpDemo, screwsForSternAndRainBoard);
//
//      assertEquals(1, component.getAmount());
//   }
//
//   @Test
//   public void testCalcWoodConnectorScrews(){
//      WoodPiece spaer = new WoodPiece(
//             9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
//             45, 600
//      );
//
//      Screw woodConnectorScrews = new Screw(
//             4, "Beslagskruer 4,0 x 50 mm", "Pakke", 17.95, "Til montering af universalbeslag + hulbånd",
//             250
//      );
//
//      MaterialListComponent component = calcCommand.calcWoodConnectorScrews(ccpDemo, spaer, woodConnectorScrews);
//
//      assertEquals(3, component.getAmount());
//   }
//
//   @Test
//   public void testCalcBraeddebolt(){
//      Screw braeddebolt = new Screw(
//             5, "Bræddebolt 10 x 120 mm.", "stk.", 17.95, "Til montering af rem på stolper", 1
//      );
//
//      MaterialListComponent component = calcCommand.calcBraeddebolt(ccpDemo, braeddebolt);
//
//      assertEquals(18, component.getAmount());
//   }
}