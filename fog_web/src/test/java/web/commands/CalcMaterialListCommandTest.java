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
   private final static String URL = "jdbc:mysql://localhost:3306/fog_demo?serverTimezone=CET&allowMultiQueries=true";

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

   @Test
   public void testCalcLoesholterForGables(){
      WoodPiece loesholt = calcCommand.getWoodpieceById(6, woodPieces);

      int amount = calcCommand.calcLoesholterForGables(ccpDemo, loesholt);

      assertEquals(12, amount);
   }

   @Test
   public void testCalcLoesholterForSides(){
      WoodPiece loesholt = calcCommand.getWoodpieceById(7, woodPieces);

      int amount = calcCommand.calcLoesholterForSides(ccpDemo, loesholt);

      assertEquals(4, amount);
   }

   @Test
   public void testCalcRemForCCPSides(){
      WoodPiece rem = calcCommand.getWoodpieceById(8, woodPieces);

      int amount = calcCommand.calcRemForCCPSides(ccpDemo, rem);

      assertEquals(2, amount);
   }


   @Test
   public void testCalcRemForCTSSides(){
      WoodPiece rem = calcCommand.getWoodpieceById(9, woodPieces);

      int amount = calcCommand.calcRemForCTSSides(ccpDemo.getToolshed(), rem);

      assertEquals(1, amount);
   }

   @Test
   public void testCalcSpaer(){
      WoodPiece spaer = calcCommand.getWoodpieceById(8, woodPieces);

      int amount = calcCommand.calcSpaer(ccpDemo, spaer);

      assertEquals(14, amount);
   }

   @Test
   public void testCalcStolpe(){
      WoodPiece stolpe = calcCommand.getWoodpieceById(10, woodPieces);

      int amount = calcCommand.calcStolpe(ccpDemo, stolpe);

      assertEquals(11, amount);
   }

   @Test
   public void testCalcBraeddebeklaedning(){
      int amount = calcCommand.calcBraeddebeklaedning(ccpDemo.getToolshed(), cladding);

      assertEquals(200, amount);
   }

   @Test
   public void testCalcVandbraetOnSides(){
      WoodPiece vandbraet = calcCommand.getWoodpieceById(12, woodPieces);

      int amount = calcCommand.calcVandbraetOnSides(ccpDemo, vandbraet);

      assertEquals(4, amount);
   }

   @Test
   public void testCalcVandbraetOnFront(){
      WoodPiece vandbraet = calcCommand.getWoodpieceById(13, woodPieces);

      int amount = calcCommand.calcVandbraetOnFront(ccpDemo, vandbraet);

      assertEquals(2, amount);
   }

   @Test
   public void testCalcScrewsForPlateRoofs(){
      Screw bundskruer = calcCommand.getScrewById(1, screws);

      int amount = calcCommand.calcScrewsForPlateRoofs(ccpDemo, bundskruer);

      assertEquals(3, amount);
   }

   @Test
   public void testCalcHulbaand(){
      int amount = calcCommand.calcHulbaand(ccpDemo);

      assertEquals(1, amount);
   }

   @Test
   public void testCalcUniConnector(){
      WoodPiece spaer = calcCommand.getWoodpieceById(8, woodPieces);

      int amount = calcCommand.calcUniConnector(ccpDemo, spaer);

      assertEquals(14, amount);
   }


   @Test
   public void testCalcScrewsForSternAndVandbraet(){
      Screw screwsForSternAndVandbraet = calcCommand.getScrewById(2, screws);

      int amount = calcCommand.calcScrewsForSternAndVandbraet(ccpDemo, screwsForSternAndVandbraet);

      assertEquals(1, amount);
   }

   @Test
   public void testCalcBeslagSkruer(){
      WoodPiece spaer = calcCommand.getWoodpieceById(8, woodPieces);
      Screw beslagSkruer = calcCommand.getScrewById(3, screws);

      int amount = calcCommand.calcBeslagSkruer(ccpDemo, spaer, beslagSkruer);

      assertEquals(3, amount);
   }

   @Test
   public void testCalcBraeddebolt(){
      Screw braeddebolt = calcCommand.getScrewById(4, screws);

      int amount = calcCommand.calcBraeddebolt(ccpDemo, braeddebolt);

      assertEquals(18, amount);
   }

   @Test
   public void testCalcfirkantskiver(){
      int amount = calcCommand.calcfirkantskiver(ccpDemo);

      assertEquals(12, amount);
   }

   @Test
   public void testCalcScrewsForOutterCladding(){
      Screw screwsForOutterCladding = calcCommand.getScrewById(5, screws);

      int amount = calcCommand.calcScrewsForOutterCladding(ctsDemo, cladding, screwsForOutterCladding);

      assertEquals(2, amount);
   }

   @Test
   public void testCalcScrewsForInnerCladding(){
      Screw screwsForInnerCladding = calcCommand.getScrewById(6, screws);

      int amount = calcCommand.calcScrewsForInnerCladding(ctsDemo, cladding, screwsForInnerCladding);

      assertEquals(2, amount);
   }

   @Test
   public void testCalcVinkelbeslag(){
      WoodPiece loesholtForGables = calcCommand.getWoodpieceById(6, woodPieces);
      loesholtForGables.setAmount(12);
      WoodPiece loesholtForSides = calcCommand.getWoodpieceById(7, woodPieces);
      loesholtForSides.setAmount(4);

      int amount = calcCommand.calcVinkelbeslag(loesholtForGables, loesholtForSides);

      assertEquals(32, amount);
   }

}