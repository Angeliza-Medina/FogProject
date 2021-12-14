package web.commands;

import business.entities.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcMaterialListCommandTest {
   CalcMaterialListCommand calcCommand = new CalcMaterialListCommand("", "admin");
   CustomCarport ccpDemo = new CustomCarport(600, 780, 210, 1, 0, 1, null);
   Toolshed ctsDemo = new Toolshed(530, 210, 1);


   @Test
   public void testCalcUnderSternBraetFrontAndBack(){
      WoodPiece understernbraetFrontAndBack = new WoodPiece(
             1, "Trykimp. bræt", "stk.", 17.95, "Understerbrædder til for- og bagenden",
             200, 25, 360
      );

      MaterialListComponent component = calcCommand.calcUnderSternBraetFrontAndBack(ccpDemo, understernbraetFrontAndBack);

      assertEquals(4, component.getAmount());
   }

   @Test
   public void testCalcUnderSternBraetSides(){
      WoodPiece understernbraetSides = new WoodPiece(
             2, "Trykimp. bræt", "stk.", 17.95, "UnderSternbrædder til siderne",
             200, 25, 540
      );

      MaterialListComponent component = null;

      component = calcCommand.calcUnderSternBraetSides(ccpDemo, understernbraetSides);

      assertEquals(4, component.getAmount());
   }

   @Test
   public void testCalcOverSternBraetFront(){
      WoodPiece overSternBraetFront = new WoodPiece(
             1, "Trykimp. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
             200, 25, 360
      );

      MaterialListComponent component = null;

      component = calcCommand.calcOverSternBraetFront(ccpDemo, overSternBraetFront);

      assertEquals(2, component.getAmount());
   }

   @Test
   public void testCalcOverSternBraetSides(){
      WoodPiece overSternBraetSides = new WoodPiece(
             3, "Trykimpg. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
             125, 25, 540
      );

      MaterialListComponent component = null;

      component = calcCommand.calcOverSternBraetSides(ccpDemo, overSternBraetSides);

      assertEquals(4, component.getAmount());
   }

   @Test
   public void testCalcLoesholterForGables(){
      WoodPiece loesholterForGables = new WoodPiece(
             5, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur gavle", 95,
             45, 270
      );

      MaterialListComponent component = null;

      component = calcCommand.calcLoesholterForGables(ccpDemo, ctsDemo, loesholterForGables);

      assertEquals(12, component.getAmount());
   }

   @Test
   public void testCalcLoesholterForSides(){
      WoodPiece loesholterForSides = new WoodPiece(
             6, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur sider", 95,
             45, 240
      );

      MaterialListComponent component = calcCommand.calcLoesholterForSides(ccpDemo, ctsDemo, loesholterForSides);

      assertEquals(4, component.getAmount());
   }

   @Test
   public void testCalcRemForCCPSides(){
      WoodPiece remForCCPSides = new WoodPiece(
             7, "Ubh. spærtræ", "stk.", 17.95, "Remme i sider, sadles ned i stolper",
             195, 45, 600
      );

      MaterialListComponent component = calcCommand.calcRemForCCPSides(ccpDemo, remForCCPSides);

      assertEquals(2, component.getAmount());
   }

   @Test
   public void testCalcRemForCTSSides(){
      WoodPiece remForCTSSides = new WoodPiece(
             8, "Ubh. spærtræ", "stk.", 17.95, "Remme i sider, sadles ned i stolper",
             195, 45, 480
      );

      MaterialListComponent component = calcCommand.calcRemForCTSSides(ctsDemo, remForCTSSides);

      assertEquals(1, component.getAmount());
   }

   @Test
   public void testCalcRafters(){
      WoodPiece spaer = new WoodPiece(
             9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
             45, 600
      );

      MaterialListComponent component = calcCommand.calcRafters(ccpDemo, spaer);

      assertEquals(15, component.getAmount());
   }

   @Test
   public void testCalcPillars(){
      WoodPiece pillarWood = new WoodPiece(
             10, "Trykimp. stolpe", "stk.", 17.95, "Stolper nedgraves 90 cm. i jord",
             97, 97, 300
      );

      MaterialListComponent component = calcCommand.calcPillars(ccpDemo, ctsDemo, pillarWood);

      assertEquals(11, component.getAmount());
   }

   @Test
   public void testCalcBraeddebeklaedning(){
      WoodPiece braeddebeklaedning = new WoodPiece(
             11, "Trykimp. bræt", "stk.", 17.95, "Til beklædning af skur 1 på 2",
             100, 19, 210
      );

      MaterialListComponent component = calcCommand.calcBraeddebeklaedning(ctsDemo, braeddebeklaedning);

      assertEquals(200, component.getAmount());
   }

   @Test
   public void testCalcRainBoardOnSides(){
      WoodPiece rainBoard = new WoodPiece(
             12, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i sider",
             100, 19, 540
      );

      MaterialListComponent component = calcCommand.calcRainBoardOnSides(ccpDemo, rainBoard);

      assertEquals(4, component.getAmount());
   }

   @Test
   public void testCalcRainBoardOnFront(){
      WoodPiece rainBoardForFront = new WoodPiece(
             13, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i forende",
             100, 19, 360
      );

      MaterialListComponent component = calcCommand.calcRainBoardOnFront(ccpDemo, rainBoardForFront);

      assertEquals(2, component.getAmount());
   }

   @Test
   public void testCalcBigRoofBoards(){
      RoofMaterialOption roofMaterialBig = new RoofMaterialOption(
             1, 1, "Plast", 109, 600, 17.95
      );

      int amountNeeded = calcCommand.calcBigRoofBoards(ccpDemo, roofMaterialBig);

      assertEquals(6, amountNeeded);
   }

   @Test
   public void testCalcSmallRoofBoards(){
      RoofMaterialOption roofMaterialBig = new RoofMaterialOption(
             1, 1, "Plast", 109, 600, 17.95
      );

      RoofMaterialOption roofMaterialSmall = new RoofMaterialOption(
             1, 1, "Plast", 109, 360, 17.95
      );

      int amountNeeded = calcCommand.calcSmallRoofBoards(ccpDemo, roofMaterialBig, roofMaterialSmall);

      assertEquals(6, amountNeeded);
   }
}