package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.MaterialListFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CalcMaterialListCommand extends CommandProtectedPage{
   public String pageToShow;
   public MaterialListFacade materialListFacade;

   // Todo: Delete once db is ready
   WoodPiece understernbraetFrontAndBack = new WoodPiece(
          1, "Trykimp. bræt", "stk.", 17.95, "Understerbrædder til for- og bagenden",
          200, 25, 360);
   // Todo: Make dynamic once db is done -> materialListFacade.getWoodByProductId(1)

   WoodPiece understernbraetSides = new WoodPiece(
          2, "Trykimp. bræt", "stk.", 17.95, "UnderSternbrædder til siderne",
          200, 25, 540);

   WoodPiece overSternBraetFront = new WoodPiece(
          1, "Trykimp. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
          200, 25, 360);

   WoodPiece overSternBraetSides = new WoodPiece(
          3, "Trykimpg. bræt", "stk.", 17.95, "Oversternbrædder til forenden",
          125, 25, 540);

   WoodPiece zDoorPiece = new WoodPiece(
          4, "Ubh. lægte", "stk.", 17.95, "Til z på bagside af dør",
          73, 38, 420);

   WoodPiece loesholterForGables = new WoodPiece(
          5, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur gavle", 95,
          45, 270);

   WoodPiece loesholterForSides = new WoodPiece(
      6, "Ubh. reglar", "stk.", 17.95, "Løsholter til skur sider", 95,
      45, 240
   );

   WoodPiece remForCCPSides = new WoodPiece(
      7, "Ubh. spærtræ", "stk.", 17.95, "Remme i sider, sadles ned i stolper",
      195, 45, 600
   );

   WoodPiece remForCTSSides = new WoodPiece(
          8, "Ubh. spærtræ", "stk.", 17.95, "Remme i sider, sadles ned i stolper",
          195, 45, 480
   );

   WoodPiece spaer = new WoodPiece(
          9, "Ubh. spærtræ", "stk.", 17.95, "Spær, monteres på rem", 195,
          45, 600
   );

   WoodPiece pillar = new WoodPiece(
          10, "Trykimp. stolpe", "stk.", 17.95, "Stolper nedgraves 90 cm. i jord",
          97, 97, 300
   );

   WoodPiece braeddebeklaedning = new WoodPiece(
          11, "Trykimp. bræt", "stk.", 17.95, "Til beklædning af skur 1 på 2",
          100, 19, 210
   );

   WoodPiece rainBoardForSides = new WoodPiece(
          12, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i sider",
          100, 19, 540
   );

   WoodPiece rainBoardForFront = new WoodPiece(
          13, "Trykimp. bræt", "stk.", 17.95, "Vandbrædt på stern i forende",
          100, 19, 360
   );

   RoofMaterialOption roofMaterialBig = new RoofMaterialOption(
          1, 1, "Plast", 109, 600, 17.95
   );

   RoofMaterialOption roofMaterialSmall = new RoofMaterialOption(
          1, 1, "Plast", 109, 360, 17.95
   );


   public CalcMaterialListCommand(String pageToShow, String role) {
      super(pageToShow, role);
      materialListFacade = new MaterialListFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      // Use on desc card
      int inquiryId = Integer.parseInt(request.getParameter("inquiryId"));

      // Carport
      int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
      int carportLength = Integer.parseInt(request.getParameter("carportLength"));
      int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
      boolean addMiddlePost = request.getParameter("middlePost") != null;
      double rafterSpacing = 0.86; // Todo: Make dynamic. Add data to db. Get data from db. Add options to frontend.
      int roofTypeId = Integer.parseInt(request.getParameter("roofType"));
      int roofMaterialId = Integer.parseInt(request.getParameter("roofMaterialId"));
      int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));

      CustomCarport ccp = new CustomCarport(
             carportWidth, carportLength, carportHeight, addMiddlePost, rafterSpacing, roofTypeId, roofMaterialId, roofAngle
      );

      // Toolshed
      boolean hasToolshed = Boolean.parseBoolean(request.getParameter("hasToolshed"));
      Toolshed cts = null;

      if(hasToolshed){
         int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
         int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));
         int claddingId = Integer.parseInt(request.getParameter("toolshedCladdingId"));

         cts = new Toolshed(toolshedWidth, toolshedLength, claddingId);
      }

      ArrayList<MaterialListComponent> materialListComponents = null;

      try{

         materialListComponents = calcMaterialList(ccp, cts);
         MaterialList materialList = new MaterialList(materialListComponents);

         HttpSession session = request.getSession();

         session.setAttribute("materialList", materialList);

         return REDIRECT_INDICATOR + pageToShow;
      }catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return pageToShow;
      }
   }

   private ArrayList<MaterialListComponent> calcMaterialList(CustomCarport ccp, Toolshed cts) throws UserException{
      ArrayList<MaterialListComponent> materialListComponents = new ArrayList<>();

      materialListComponents.add(calcUnderSternBraetFrontAndBack(ccp, understernbraetFrontAndBack));
      materialListComponents.add(calcUnderSternBraetSides(ccp, understernbraetSides));
      materialListComponents.add(calcOverSternBraetFront(ccp, overSternBraetFront));
      materialListComponents.add(calcOverSternBraetSides(ccp, overSternBraetSides));
      if(cts != null){
         materialListComponents.add(zDoorPiece);
         materialListComponents.add(calcLoesholterForGables(ccp, cts, loesholterForGables));
         materialListComponents.add(calcLoesholterForSides(ccp, cts, loesholterForSides));
      }
      materialListComponents.add(calcRemForCCPSides(ccp, remForCCPSides));
      if(cts != null) {
         materialListComponents.add(calcRemForCTSSides(cts, remForCTSSides));
      }
      materialListComponents.add(calcRafters(ccp, spaer));
      materialListComponents.add(calcPillars(ccp, cts, pillar));
      if(cts != null){
         materialListComponents.add(calcBraeddebeklaedning(cts, braeddebeklaedning));
      }
      materialListComponents.add(calcRainBoardOnSides(ccp, rainBoardForSides));
      materialListComponents.add(calcRainBoardOnFront(ccp, rainBoardForFront));
      // Todo: add roofMaterial calculation - Big
      // Todo: add roofMaterial calculation - Small

      return materialListComponents;
   }

   MaterialListComponent calcUnderSternBraetFrontAndBack(CustomCarport ccp, WoodPiece understernbraet){
      MaterialListComponent component = null;

      final int sidesToCalculate = 2;

      int amountNeeded = (int)Math.ceil((double)ccp.getWidth() / understernbraet.getLength()) * sidesToCalculate;

      component = new MaterialListComponent(understernbraet.getProductId(), understernbraet.getProductName(), understernbraet.getUnit(),
             understernbraet.getPrice(), understernbraet.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcUnderSternBraetSides(CustomCarport ccp, WoodPiece understernbraet){
      MaterialListComponent component = null;

      final int sidesToCalculate = 2;

      int amountNeeded = (int)Math.ceil((double)ccp.getLength() / understernbraet.getLength()) * sidesToCalculate;

      component = new MaterialListComponent(understernbraet.getProductId(), understernbraet.getProductName(), understernbraet.getUnit(),
             understernbraet.getPrice(), understernbraet.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcOverSternBraetFront(CustomCarport ccp, WoodPiece overSternBraet){
      MaterialListComponent component = null;

      int amountNeeded = (int)Math.ceil((double) ccp.getWidth() / overSternBraet.getLength());

      component = new MaterialListComponent(overSternBraet.getProductId(), overSternBraet.getProductName(), overSternBraet.getUnit(),
             overSternBraet.getPrice(), overSternBraet.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcOverSternBraetSides(CustomCarport ccp, WoodPiece overSternBraetSides){
      MaterialListComponent component = null;

      final int sidesToCalculate = 2;

      int amountNeeded = (int)Math.ceil((double)ccp.getLength() / overSternBraetSides.getLength()) * sidesToCalculate;

      component = new MaterialListComponent(overSternBraetSides.getProductId(), overSternBraetSides.getProductName(),
             overSternBraetSides.getUnit(), overSternBraetSides.getPrice(), overSternBraetSides.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcLoesholterForGables(CustomCarport ccp, Toolshed cts, WoodPiece reglar){
      /*
         Calculating on the assumption that:
         - The top løsholt is placed 30 cm below the top pilar
         - The bottom løsholt is 30 cm above the ground.
         - The recommended max. space between two løsholt, which is 60 cm, is being followed
      */

      MaterialListComponent component = null;

      final int surfacesToCalculate = 2;
      final int recommendedMaxSpace = 60;
      final int minAmountOfLoesholt = 2;

      int amountNeededHorizontally = (int) Math.ceil((double)cts.getToolshedWidth() / reglar.getLength());

      double airBetweenTheTopAndBottomLoesholt = (double)ccp.getHeight() - (double)recommendedMaxSpace - (double)reglar.getWidth() / 10 * 2;
      // 2 = Top and bottom løsholt

      int additionalLoesholtBetweenTopAndBottom = (int) Math.floor(airBetweenTheTopAndBottomLoesholt / recommendedMaxSpace) / 2;

      int amountNeeded = (minAmountOfLoesholt + additionalLoesholtBetweenTopAndBottom) * amountNeededHorizontally * surfacesToCalculate;

      component = new MaterialListComponent(reglar.getProductId(), reglar.getProductName(), reglar.getUnit(), reglar.getPrice(),
             reglar.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcLoesholterForSides(CustomCarport ccp, Toolshed cts, WoodPiece reglar){
     /*
         Calculating on the assumption that:
         - The top løsholt is placed 30 cm below the top pilar
         - The bottom løsholt is 30 cm above the ground.
         - The max. space between two løsholt is higher than the recommended 60 cm.
           First one to fit from 60 was 64 cm so that is what we are calculating on.
      */

      MaterialListComponent component = null;

      final int surfacesToCalculate = 2;
      final int recommendedMaxSpace = 64;
      final int minAmountOfLoesholt = 2;

      int amountNeededHorizontally = (int) Math.ceil((double)cts.getToolshedLength() / reglar.getLength());

      double airBetweenTheTopAndBottomLoesholt = (double)ccp.getHeight() - (double)recommendedMaxSpace - (double)reglar.getWidth() / 10 * 2;
      // 2 = Top and bottom løsholt

      int additionalLoesholtBetweenTopAndBottom = (int) Math.floor(airBetweenTheTopAndBottomLoesholt / recommendedMaxSpace) / 2;

      int amountNeeded = (minAmountOfLoesholt + additionalLoesholtBetweenTopAndBottom) * amountNeededHorizontally * surfacesToCalculate;

      component = new MaterialListComponent(reglar.getProductId(), reglar.getProductName(), reglar.getUnit(), reglar.getPrice(),
             reglar.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   // Todo: Fix
   MaterialListComponent calcRemForCCPSides(CustomCarport ccp, WoodPiece spaerWood){
      MaterialListComponent component = null;

      int amountNeeded = (int)Math.ceil((double)ccp.getLength() / spaerWood.getLength()) * 2;

      component = new MaterialListComponent(
             spaerWood.getProductId(), spaerWood.getProductName(), spaerWood.getUnit(), spaerWood.getPrice(), spaerWood.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   // Todo: Fix
   MaterialListComponent calcRemForCTSSides(Toolshed cts, WoodPiece spaerWood){
      MaterialListComponent component = null;

      int amountNeeded = (int)Math.ceil((double)cts.getToolshedLength() / spaerWood.getLength()) * 2;

      component = new MaterialListComponent(
             spaerWood.getProductId(), spaerWood.getProductName(), spaerWood.getUnit(), spaerWood.getPrice(), spaerWood.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   //Todo: Make dynamic after adding rafter options to db
   MaterialListComponent calcRafters(CustomCarport ccp, WoodPiece spaerWood){
      final int rafterSpacing = 55; // Remove this and reaplace with ccp.getRafterSpacing

      int amountNeeded = (int)Math.ceil(ccp.getLength() / ((double)spaer.getThickness() / 10 + rafterSpacing) + 1);

      MaterialListComponent component = new MaterialListComponent(
             spaerWood.getProductId(), spaerWood.getProductName(), spaerWood.getUnit(), spaerWood.getPrice(),
             spaerWood.getDesc());

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcPillars(CustomCarport ccp, Toolshed cts, WoodPiece pillarWood){
      int amountOfPilars = 4;

      if(cts != null){
         amountOfPilars += 6;
      }

      final int frontUndergroundLength = 90;
      final int backUndergroundLength = 100;
      final int frontAboveGroundLength = ccp.getHeight() - 2;
      final int backAboveGroundLength = frontAboveGroundLength - ((int)Math.floor((double)ccp.getLength() / 130));

      int lengthNeededForFront = (frontUndergroundLength + frontAboveGroundLength) * 2;
      int lengthNeededForBack = (backUndergroundLength + backAboveGroundLength) * (amountOfPilars - 2);

      int amountNeeded = (int)Math.ceil((double) (lengthNeededForFront + lengthNeededForBack) / pillarWood.getLength());

      MaterialListComponent component = new MaterialListComponent(
             pillarWood.getProductId(), pillarWood.getProductName(), pillarWood.getUnit(), pillarWood.getPrice(), pillarWood.getDesc()
      );

      component.setAmount(amountNeeded);

      return component;
   }

   // Todo: Fix
   MaterialListComponent calcBraeddebeklaedning(Toolshed cts, WoodPiece braeddebeklaedning){
      final int doorWidth = 70;

      int widthToCover = (cts.getToolshedWidth() * 2) + (cts.getToolshedLength() * 2) - doorWidth;
      int firstLayer = (int)Math.ceil((double)widthToCover / ((double) braeddebeklaedning.getWidth() / 10));
      int secondLayer = (int)Math.ceil((double)firstLayer / 2);

      int amountNeeded = firstLayer + secondLayer;

      MaterialListComponent component = new MaterialListComponent(
             braeddebeklaedning.getProductId(), braeddebeklaedning.getProductName(), braeddebeklaedning.getUnit(),
             braeddebeklaedning.getPrice(), braeddebeklaedning.getDesc()
      );

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcRainBoardOnSides(CustomCarport ccp, WoodPiece rainBoard){
      int amountNeeded = (int)Math.ceil(((double)ccp.getLength() / rainBoard.getLength())) * 2;

      MaterialListComponent component = new MaterialListComponent(
        rainBoard.getProductId(), rainBoard.getProductName(), rainBoard.getUnit(), rainBoard.getPrice(), rainBoard.getDesc()
      );

      component.setAmount(amountNeeded);

      return component;
   }

   MaterialListComponent calcRainBoardOnFront(CustomCarport ccp, WoodPiece rainBoard){
      int amountNeeded = (int)Math.ceil((double)ccp.getWidth() / rainBoard.getLength());

      MaterialListComponent component = new MaterialListComponent(
        rainBoard.getProductId(), rainBoard.getProductName(), rainBoard.getUnit(), rainBoard.getPrice(), rainBoard.getDesc()
      );

      component.setAmount(amountNeeded);

      return component;
   }

   // Todo: Adjust once RoofMaterialOption has been modified to inherit from MaterialListComponent
   int calcBigRoofBoards(CustomCarport ccp, RoofMaterialOption roofMaterialBig){
      int bigBoardsHorizontally = (int)Math.floor( ccp.getWidth() / roofMaterialBig.getMaterialWidth());
      int bigBoardsVertically = (int)Math.floor((double) ccp.getLength() / roofMaterialBig.getMaterialLength());

      int amountNeeded = bigBoardsHorizontally * bigBoardsVertically;

      return amountNeeded;
   }

   // Todo: Adjust once RoofMaterialOption has been modified to inherit from MaterialListComponent
   int calcSmallRoofBoards(CustomCarport ccp, RoofMaterialOption roofMaterialBig, RoofMaterialOption roofMaterialSmall ){
      int bigBoardsHorizontally = (int)Math.floor((double) ccp.getWidth() / roofMaterialBig.getMaterialWidth());
      int bigBoardsVertically = (int)Math.floor((double) ccp.getLength() / roofMaterialBig.getMaterialLength());

      int spaceLeftHorizontally = ccp.getWidth() - ((int)roofMaterialBig.getMaterialWidth() * bigBoardsHorizontally);
      int smallBoardsHorizontally = 0;
      if(spaceLeftHorizontally < ccp.getWidth()){
         smallBoardsHorizontally = (int)Math.ceil(spaceLeftHorizontally / roofMaterialSmall.getMaterialWidth());
      }

      int spaceLeftVertically = ccp.getLength() - ((int)roofMaterialBig.getMaterialLength() * bigBoardsVertically);
      int smallBoardsVertically = 0;
      if(spaceLeftVertically < ccp.getLength()){
         smallBoardsVertically = (int)Math.ceil(spaceLeftVertically / roofMaterialSmall.getMaterialLength());
      }

      int amountNeeded = smallBoardsHorizontally * smallBoardsVertically;

      return amountNeeded;
   }

}
