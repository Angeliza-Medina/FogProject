package web.commands;

import business.entities.CustomCarport;
import business.entities.MaterialListComponent;
import business.entities.Toolshed;
import business.entities.WoodPiece;
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

}