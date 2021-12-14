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

   MaterialListComponent calcRemForCCPSides(CustomCarport ccp, WoodPiece spaerWood){
      MaterialListComponent component = null;


      return component;
   }

}
