package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.MaterialListFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class CalcMaterialListCommand extends CommandProtectedPage{
   public MaterialListFacade materialListFacade;

   public CalcMaterialListCommand(String pageToShow, String role) {
      super(pageToShow, role);
      materialListFacade = new MaterialListFacade(database);
   }


   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      // Carport
      int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
      int carportLength = Integer.parseInt(request.getParameter("carportLength"));
      int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
      boolean addMiddlePost = request.getParameter("middlePost") != null;
      int rafterSpacing = Integer.parseInt(request.getParameter("rafterSpacing"));
      int roofTypeId = Integer.parseInt(request.getParameter("roofTypeId"));
      int roofMaterialId = Integer.parseInt(request.getParameter("roofMaterialId"));
      int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));

      // Toolshed
      boolean hasToolshed = Boolean.parseBoolean(request.getParameter("hasToolshed"));
      Toolshed cts = null;

      if(hasToolshed){
         int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
         int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));
         int claddingId = Integer.parseInt(request.getParameter("toolshedCladdingId"));

         cts = new Toolshed(toolshedWidth, toolshedLength, claddingId);
         cts.setPlacement(request.getParameter("toolshedPlacement"));
      }

      CustomCarport updatedCCP = new CustomCarport(
             carportWidth, carportLength, carportHeight, addMiddlePost, rafterSpacing, roofTypeId, roofMaterialId, roofAngle, cts
      );

      try{
         // Get all needed materialList components from the db
         ArrayList<WoodPiece> woodPieces = materialListFacade.getAllWoodPieces();
         CTSCladdingOption cladding = null;
         ArrayList<RoofMaterialOption> roofMaterials = materialListFacade.getAllRoofMaterial();
         ArrayList<Screw> screws = materialListFacade.getAllScrews();
         ArrayList<WoodConnector> woodConnectors = materialListFacade.getAllWoodConnectors();
         ArrayList<CTSDoorComponent> doorComponents = null;

         if(updatedCCP.getToolshed() != null){
            cladding = materialListFacade.getCladdingById(updatedCCP.getToolshed().getToolshedCladdingId());
         }

         if(updatedCCP.getToolshed() != null){
            doorComponents = materialListFacade.getAllDoorComponents();
         }


         // Create and calc. the materialList
         MaterialList materialList = calcMaterialList(updatedCCP, woodPieces, cladding, roofMaterials, screws, woodConnectors, doorComponents);
         int totalPrice = calcTotalPrice(materialList);
         int recommendedPrice = calcRecommendedPrice(totalPrice);

         HttpSession session = request.getSession();

         // Update the opened inquiry's carport with the possible changes the employee has made
         // Will NOT change the info on the database!
         CustomCarportInquiry inquiry = (CustomCarportInquiry) session.getAttribute("inquiryById");
         inquiry.setCustomCarport(updatedCCP);

         SketchInfo sketchInfo = new SketchInfo(updatedCCP, woodPieces.get(7).getThickness()); // Todo to get by id

         session.setAttribute("inquiryById", inquiry);
         session.setAttribute("materialList", materialList);
         session.setAttribute("totalPrice", totalPrice);
         session.setAttribute("recommendedPrice", recommendedPrice);
         session.setAttribute("sketchInfo", sketchInfo);

         return REDIRECT_INDICATOR + super.pageToShow;
      }catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         System.out.println(ex.getMessage());
         return "error";
      }
   }

   private int calcTotalPrice(MaterialList materialList){
      int totalPrice = 0;

      ArrayList<WoodPiece> woodPieces = materialList.getWoodPieces();
      CTSCladdingOption cladding = null;
      if(materialList.getCladding() != null){
         cladding = materialList.getCladding();
      }
      ArrayList<RoofMaterialOption> roofMaterials = materialList.getRoofMaterials();
      ArrayList<Screw> screws = materialList.getScrews();
      ArrayList<WoodConnector> woodConnectors = materialList.getWoodConnectors();
      ArrayList<CTSDoorComponent> doorComponents = materialList.getDoorComponents();

      for(WoodPiece woodPiece : woodPieces){
         totalPrice += (woodPiece.getPrice() * woodPiece.getAmount());
      }

      if(cladding != null){
         totalPrice += (cladding.getPrice() * cladding.getAmount());
      }

      for(RoofMaterialOption roofMaterial : roofMaterials){
         totalPrice += (roofMaterial.getPrice() * roofMaterial.getAmount());
      }

      for(Screw screw : screws){
         totalPrice += (screw.getPrice() * screw.getAmount());
      }

      for(WoodConnector woodConnector : woodConnectors){
         totalPrice += (woodConnector.getPrice() * woodConnector.getAmount());
      }

      for(CTSDoorComponent doorComponent : doorComponents){
         totalPrice += (doorComponent.getPrice() * doorComponent.getAmount());
      }

      return totalPrice;
   }

   private int calcRecommendedPrice(int totalPrice){
      return (int)Math.ceil((double)totalPrice / 100 * 30) + totalPrice;
   }

   // Method that calls all the different calculation methods and saves the results in multiple ArrayLists
   private MaterialList calcMaterialList(
          CustomCarport ccp,
          ArrayList<WoodPiece> woodPieces,
          CTSCladdingOption cladding,
          ArrayList<RoofMaterialOption> roofMaterials,
          ArrayList<Screw> screws,
          ArrayList<WoodConnector> woodConnectors,
          ArrayList<CTSDoorComponent> doorComponents
   ) throws UserException {
      // Sublists for the material list
      ArrayList<WoodPiece> woodPiecesToList = new ArrayList<>();
      CTSCladdingOption claddingToList = null;
      ArrayList<RoofMaterialOption> roofMaterialsToList = new ArrayList<>();
      ArrayList<Screw> screwsToList = new ArrayList<>();
      ArrayList<WoodConnector> woodConnectorsToList = new ArrayList<>();
      ArrayList<CTSDoorComponent> doorComponentsToList = new ArrayList<>();

      //------------------------------ Understernbrædder for- og bagende ------------------------------
      WoodPiece understernbraetFrontAndBack = woodPieces.get(0);
      understernbraetFrontAndBack.setDesc("Understernbrædder til for- og bagenden");
      understernbraetFrontAndBack.setAmount(calcUnderSternBraedderFrontAndBack(ccp, understernbraetFrontAndBack));

      woodPiecesToList.add(understernbraetFrontAndBack);
      //---------------------------- Understernbrædder for- og bagende END ----------------------------


      //------------------------------- Understernbrædder til siderne ---------------------------------
      WoodPiece understernbraetSides = woodPieces.get(1);
      understernbraetSides.setDesc("Understernbrædder til siderne");
      understernbraetSides.setAmount(calcUnderSternBraedderSides(ccp, understernbraetSides));

      woodPiecesToList.add(understernbraetSides);
      //----------------------------- Understernbrædder til siderne END -------------------------------


      //------------------------------- Oversternbrædder til forenden ---------------------------------
      WoodPiece oversternbraetFront = woodPieces.get(2);
      oversternbraetFront.setDesc("Oversternbrædder til forenden");
      oversternbraetFront.setAmount(calcOverSternBraetFront(ccp, oversternbraetFront));

      woodPiecesToList.add(oversternbraetFront);
      //----------------------------- Oversternbrædder til forenden END -------------------------------


      //------------------------------- Oversternbrædder til siderne ----------------------------------
      WoodPiece oversternbraetSides = woodPieces.get(3);
      oversternbraetSides.setDesc("Oversternbrædder til siderne");
      oversternbraetSides.setAmount(calcOverSternBraedderSides(ccp, oversternbraetSides));

      woodPiecesToList.add(oversternbraetSides);
      //----------------------------- Oversternbrædder til siderne END --------------------------------


      //--------------------------------- Z til bagsiden af døren -------------------------------------
      if(ccp.getToolshed() != null){
         WoodPiece z = woodPieces.get(4);
         z.setDesc("Til z på bagside af redskebsrummets dør");
         z.setAmount(1);
         woodPiecesToList.add(z);
      }
      //------------------------------- Z til bagsiden af døren END -----------------------------------


      //----------------------------- Løsholter til redskabrum gavle ----------------------------------
      WoodPiece loesholtForGables = null;
      if(ccp.getToolshed() != null){
         loesholtForGables = woodPieces.get(5);
         loesholtForGables.setDesc("Løsholter til redskabsrummets gavle");
         loesholtForGables.setAmount(calcLoesholterForGables(ccp, loesholtForGables));

         woodPiecesToList.add(loesholtForGables);
      }
      //--------------------------- Løsholter til redskabrum gavle END --------------------------------


      //----------------------------- Løsholter til redskabrum sider ----------------------------------
      WoodPiece loesholtForSides = null;

      if(ccp.getToolshed() != null){
         loesholtForSides = woodPieces.get(6);
         loesholtForSides.setDesc("Løsholter til redskabsrummets sider");
         loesholtForSides.setAmount(calcLoesholterForSides(ccp, loesholtForSides));

         woodPiecesToList.add(loesholtForSides);
      }
      //--------------------------- Løsholter til redskabrum sider END --------------------------------


      //-------------------------------- Remme til carportens sider -----------------------------------
      WoodPiece remmeForCarportSides_base = woodPieces.get(7);

      WoodPiece remmeForCarportSides_toList = new WoodPiece(
             remmeForCarportSides_base.getProductId(), remmeForCarportSides_base.getProductName(),
             remmeForCarportSides_base.getUnit(), remmeForCarportSides_base.getPrice(),
             "Remme til sider, sadles ned i stolperne", remmeForCarportSides_base.getWidth(),
             remmeForCarportSides_base.getThickness(), remmeForCarportSides_base.getLength()
      );

      remmeForCarportSides_toList.setAmount(calcRemForCCPSides(ccp, remmeForCarportSides_base));

      woodPiecesToList.add(remmeForCarportSides_toList);
      //------------------------------ Remme til carportens sider END ---------------------------------


      //----------------------------- Remme til redskabsrummets sider ---------------------------------
      if(ccp.getToolshed() != null){
         WoodPiece remmeForToolshedSides = woodPieces.get(8);
         remmeForToolshedSides.setDesc("Remme til redskabsrummets sider, sadles ned i stolper (rem deles)");
         remmeForToolshedSides.setAmount(calcRemForCTSSides(ccp.getToolshed(), remmeForToolshedSides));

         woodPiecesToList.add(remmeForToolshedSides);
      }
      //--------------------------- Remme til redskabsrummets sider END -------------------------------


      //------------------------------------------- Spær ----------------------------------------------
      WoodPiece spaer = woodPieces.get(7);
      spaer.setDesc("Spær, monteres på rem");
      spaer.setAmount(calcSpaer(ccp, spaer));
      woodPiecesToList.add(spaer);
      //----------------------------------------- Spær END --------------------------------------------


      //------------------------------------------ Stolper --------------------------------------------
      WoodPiece stolpe = woodPieces.get(9);
      stolpe.setDesc("Stolper nedgraves min. 90cm i jord");
      stolpe.setAmount(calcStolpe(ccp, stolpe));

      woodPiecesToList.add(stolpe);
      //---------------------------------------- Stolper END ------------------------------------------


      //------------------------------------- Bræddebeklædning ----------------------------------------
      if(ccp.getToolshed() != null){
         cladding.setDesc("Til beklædning af redskabsrum 1 på 2");
         cladding.setAmount(calcBraeddebeklaedning(ccp.getToolshed(), cladding));

         claddingToList = cladding;
      }
      //----------------------------------- Bræddebeklædning END --------------------------------------


      //----------------------------------- Vandbræt til siderne --------------------------------------
      WoodPiece vandbraetForSides = woodPieces.get(11);
      vandbraetForSides.setDesc("Vandbrædt på stern i sider");
      vandbraetForSides.setAmount(calcVandbraetOnSides(ccp, vandbraetForSides));

      woodPiecesToList.add(vandbraetForSides);
      //--------------------------------- Vandbræt til siderne END ------------------------------------


      //----------------------------------- Vandbræt til forende --------------------------------------
      WoodPiece vandbraetFront = woodPieces.get(12);
      vandbraetFront.setDesc("Vandbrædt på stern i forende");
      vandbraetFront.setAmount(calcVandbraetOnFront(ccp, vandbraetFront));

      woodPiecesToList.add(vandbraetFront);
      //--------------------------------- Vandbræt til forende END ------------------------------------


      //-------------------------------------- Tag-materiale ------------------------------------------
      if(ccp.getRoofTypeId() == 1){
         ArrayList<RoofMaterialOption> roofMaterial_toList = new ArrayList<>();

         String roofMaterialProductName = "";

         // Find roof material product name
         for(RoofMaterialOption roofMaterial : roofMaterials){
            if(ccp.getRoofMaterialId() == roofMaterial.getProductId()){
               roofMaterialProductName = roofMaterial.getProductName();
            }
         }

         // Find all varieties of the roof material found above and add to list
         for(RoofMaterialOption roofMaterial : roofMaterials){
            if(roofMaterialProductName.equals(roofMaterial.getProductName())){
               roofMaterial_toList.add(roofMaterial);
            }
         }

         roofMaterial_toList.get(0).setDesc("Tagplader, monteres på spær");
         roofMaterial_toList.get(0).setAmount(calcFlatRoofOverCTS(ccp, roofMaterial_toList.get(0)));

         if(roofMaterial_toList.size() > 1 && ccp.getToolshed() != null){
            roofMaterial_toList.get(1).setDesc("Tagplader, monteres på spær");
            roofMaterial_toList.get(1).setAmount(calcFlatRoofOverCCP(ccp, roofMaterial_toList.get(1)));
         }

         roofMaterialsToList = roofMaterial_toList;

      }else if(ccp.getRoofTypeId() == 2){
         // Todo: Add method calls for angled roofs when made
      }
      //------------------------------------- Tag-materiale END ---------------------------------------


      //------------------------------ Screws for plated roof material --------------------------------
      // Todo: add check if roof material is of the plate type
      Screw bundskruer = screws.get(0);
      bundskruer.setDesc("Skruer til tagplader");
      bundskruer.setAmount(calcScrewsForPlateRoofs(ccp, bundskruer));

      screwsToList.add(bundskruer);
      //------------------------------ Screws for plated roof material --------------------------------


      //------------------------------------------ Hulbaand -------------------------------------------
      WoodConnector hulbaand = woodConnectors.get(0);
      hulbaand.setDesc("Til vindkryds på spær");
      hulbaand.setAmount(calcHulbaand(ccp));
      woodConnectorsToList.add(hulbaand);
      //---------------------------------------- Hulbaand END -----------------------------------------


      //----------------------------------------- Uni beslag ------------------------------------------
      WoodConnector uniConnectorR = woodConnectors.get(1);
      uniConnectorR.setDesc("Til montering af spær på rem");
      uniConnectorR.setAmount(calcUniConnector(spaer));
      woodConnectorsToList.add(uniConnectorR);

      WoodConnector uniConnectorL = woodConnectors.get(2);
      uniConnectorL.setDesc("Til montering af spær på rem");
      uniConnectorL.setAmount(calcUniConnector(spaer));
      woodConnectorsToList.add(uniConnectorL);
      //--------------------------------------- Uni beslag END ----------------------------------------


      //------------------------------- Skruer for stern og vandbræt ----------------------------------
      Screw screwsForSternAndVandbraet = screws.get(1);
      screwsForSternAndVandbraet.setDesc("Til montering af stern & vandbræt");
      screwsForSternAndVandbraet.setAmount(calcScrewsForSternAndVandbraet(ccp,screwsForSternAndVandbraet));
      screwsToList.add(screwsForSternAndVandbraet);
      //----------------------------- Skruer for stern og vandbræt END --------------------------------


      //-------------------------------------- Beslag skruer ------------------------------------------
      Screw beslagSkruer = screws.get(2);
      beslagSkruer.setDesc("Til montering af universalbeslag & hulbånd");
      beslagSkruer.setAmount(calcBeslagSkruer(ccp, spaer, beslagSkruer));
      screwsToList.add(beslagSkruer);
      //------------------------------------ Beslag skruer END ----------------------------------------


      //--------------------------------------- Bræddebolt --------------------------------------------
      Screw braeddebolt = screws.get(3);
      braeddebolt.setDesc("Til montering af rem på stolper");
      braeddebolt.setAmount(calcBraeddebolt(ccp, braeddebolt));
      screwsToList.add(braeddebolt);
      //------------------------------------- Bræddebolt END ------------------------------------------


      //-------------------------------------- FirkantSkiver ------------------------------------------
      WoodConnector firkantskiver = woodConnectors.get(3);
      firkantskiver.setDesc("Til montering af rem på stolper");
      firkantskiver.setAmount(calcfirkantskiver(ccp));
      woodConnectorsToList.add(firkantskiver);
      //------------------------------------ FirkantSkiver END ----------------------------------------


      //----------------------------- Skruer til yderste beklædning -----------------------------------
      if(ccp.getToolshed() != null){
         Screw screwsForOutterCladding = screws.get(4);
         screwsForOutterCladding.setDesc("Til montering af yderste beklædning");
         screwsForOutterCladding.setAmount(calcScrewsForOutterCladding(spaer, screwsForOutterCladding));
         screwsToList.add(screwsForOutterCladding);
      }
      //--------------------------- Skruer til yderste beklædning END ---------------------------------


      //----------------------------- Skruer til inderste beklædning ----------------------------------
      if(ccp.getToolshed() != null){
         Screw screwsForInnerCladding = screws.get(5);
         screwsForInnerCladding.setDesc("Til montering af inderste beklædning");
         screwsForInnerCladding.setAmount(calcScrewsForInnerCladding(spaer, screwsForInnerCladding));
         screwsToList.add(screwsForInnerCladding);
      }
      //--------------------------- Skruer til inderste beklædning END --------------------------------


      //-------------------------- Komponenter til redskabsrummets dør --------------------------------
      if(ccp.getToolshed() != null){
         CTSDoorComponent stalddoersgreb = doorComponents.get(0);
         stalddoersgreb.setDesc("Til lås på redskabsrummets dør");
         stalddoersgreb.setAmount(1);
         doorComponentsToList.add(stalddoersgreb);

         CTSDoorComponent thaengsel = doorComponents.get(1);
         thaengsel.setDesc("Til redskabsrummets dør");
         thaengsel.setAmount(2);
         doorComponentsToList.add(thaengsel);
      }
      //------------------------ Komponenter til redskabsrummets dør END ------------------------------


      //------------------------------------- Vinkelbeslag --------------------------------------------
      if(ccp.getToolshed() != null) {
         WoodConnector vinkelbeslag = woodConnectors.get(4);
         vinkelbeslag.setDesc("Til montering af løsholter i skur");

         if(loesholtForGables != null && loesholtForSides != null){
            vinkelbeslag.setAmount(calcVinkelbeslag(loesholtForGables, loesholtForSides));
         }
      }
      //----------------------------------- Vinkelbeslag END ------------------------------------------

      MaterialList materialList = new MaterialList(
             woodPiecesToList, claddingToList, roofMaterialsToList, screwsToList, woodConnectorsToList, doorComponentsToList
      );

      return  materialList;
   }


   // ----------------------------------- Material calculations -----------------------------------
   private int calcUnderSternBraedderFrontAndBack(CustomCarport ccp, WoodPiece understernbraet){
      final int sidesToCalculate = 2;

      int amountNeeded = (int) Math.ceil((double) ccp.getWidth() / understernbraet.getLength()) * sidesToCalculate;

      return amountNeeded;
   }

   private int calcUnderSternBraedderSides(CustomCarport ccp, WoodPiece understernbraet){
      final int sidesToCalculate = 2;

      int amountNeeded = (int) Math.ceil((double) ccp.getLength() / understernbraet.getLength()) * sidesToCalculate;

      return amountNeeded;
   }

   private int calcOverSternBraetFront (CustomCarport ccp, WoodPiece overSternBraet){
      int amountNeeded = (int) Math.ceil((double) ccp.getWidth() / overSternBraet.getLength());

      return amountNeeded;
   }

   private int calcOverSternBraedderSides(CustomCarport ccp, WoodPiece overSternBraetSides){
      final int sidesToCalculate = 2;

      int amountNeeded = (int) Math.ceil((double) ccp.getLength() / overSternBraetSides.getLength()) * sidesToCalculate;

      return amountNeeded;
   }

   private int calcLoesholterForGables (CustomCarport ccp, WoodPiece loesholt){
      /*
         Calculating on the assumption that:
         - The top løsholt is placed 30 cm below the top pilar
         - The bottom løsholt is 30 cm above the ground.
         - The recommended max. space between two løsholt, which is 60 cm, is being followed
      */

      final int surfacesToCalculate = 2;
      final int recommendedMaxSpace = 60;
      final int minAmountOfLoesholt = 2;

      int amountNeededHorizontally = (int) Math.ceil((double) ccp.getToolshed().getToolshedWidth() / loesholt.getLength());

      double airBetweenTheTopAndBottomLoesholt = (double) ccp.getHeight() - (double) recommendedMaxSpace - (double) loesholt.getWidth() / 10 * 2;
      // 2 = Top and bottom løsholt

      int additionalLoesholtBetweenTopAndBottom = (int) Math.floor(airBetweenTheTopAndBottomLoesholt / recommendedMaxSpace) / 2;

      int amountNeeded = (minAmountOfLoesholt + additionalLoesholtBetweenTopAndBottom) * amountNeededHorizontally * surfacesToCalculate;

      return amountNeeded;
   }

   private int calcLoesholterForSides (CustomCarport ccp, WoodPiece loesholt){
     /*
         Calculating on the assumption that:
         - The top løsholt is placed 30 cm below the top pilar
         - The bottom løsholt is 30 cm above the ground.
         - The max. space between two løsholt is higher than the recommended 60 cm.
           First one to fit from 60 was 64 cm so that is what we are calculating on.
      */

      final int surfacesToCalculate = 2;
      final int recommendedMaxSpace = 64;
      final int minAmountOfLoesholt = 2;

      int amountNeededHorizontally = (int) Math.ceil((double) ccp.getToolshed().getToolshedLength() / loesholt.getLength());

      double airBetweenTheTopAndBottomLoesholt = (double) ccp.getHeight() - (double) recommendedMaxSpace - (double) loesholt.getWidth() / 10 * 2;
      // 2 = Top and bottom løsholt

      int additionalLoesholtBetweenTopAndBottom = (int) Math.floor(airBetweenTheTopAndBottomLoesholt / recommendedMaxSpace) / 2;

      int amountNeeded = (minAmountOfLoesholt + additionalLoesholtBetweenTopAndBottom) * amountNeededHorizontally * surfacesToCalculate;

      return amountNeeded;
   }

   private int calcRemForCCPSides (CustomCarport ccp, WoodPiece rem){
      int lengthToCover = ccp.getLength();
      if (ccp.getToolshed() != null) {
         lengthToCover -= ccp.getToolshed().getToolshedLength();
      }

      int amountNeeded = (int) Math.ceil(((double) lengthToCover / rem.getLength())) * 2;

      return amountNeeded;
   }

   private int calcRemForCTSSides (Toolshed cts, WoodPiece rem){
      int amountNeeded = (int) Math.ceil((double) cts.getToolshedLength() / rem.getLength());

      return amountNeeded;
   }

   private int calcSpaer(CustomCarport ccp, WoodPiece spaer){
      final int rafterSpacing = ccp.getRafterSpacing();
      double spaerThicknessIncm = (double) spaer.getThickness() / 10;

      int amountNeeded = (int) Math.ceil(ccp.getLength() / (spaerThicknessIncm + rafterSpacing) + 1);

      return amountNeeded;
   }

   private int calcStolpe(CustomCarport ccp, WoodPiece stolpe){
      int amountOfPilars = 4;

      if (ccp.getToolshed() != null) {
         amountOfPilars += 6;
      }

      if (ccp.isHasMiddlePillar()) {
         amountOfPilars++;
      }

      final int frontUndergroundLength = 90;
      final int backUndergroundLength = 100;
      final int frontAboveGroundLength = ccp.getHeight() - 2;
      final int backAboveGroundLength = frontAboveGroundLength - ((int) Math.floor((double) ccp.getLength() / 130));

      int lengthNeededForFront = (frontUndergroundLength + frontAboveGroundLength) * 2;
      int lengthNeededForBack = (backUndergroundLength + backAboveGroundLength) * (amountOfPilars - 2);

      int amountNeeded = (int) Math.ceil((double) (lengthNeededForFront + lengthNeededForBack) / stolpe.getLength());

      return amountNeeded;
   }

   private int calcBraeddebeklaedning (Toolshed cts, CTSCladdingOption braeddebeklaedning){
      final int doorWidth = 70;
      final double braeddebeklaedningSpacing = 1.6;

      double outlineLengthToCover = (cts.getToolshedWidth() * 2) + (cts.getToolshedLength() * 2) - doorWidth - (10 + braeddebeklaedningSpacing);
      int firstLayer = (int) Math.ceil(outlineLengthToCover / ((double) braeddebeklaedning.getWidth() / 10 + braeddebeklaedningSpacing));
      int secondLayer = (int) Math.ceil((double) firstLayer / 2);

      int amountNeeded = firstLayer + secondLayer;

      return amountNeeded;
   }

   private int calcVandbraetOnSides(CustomCarport ccp, WoodPiece vandbraet){
      int amountNeeded = (int) Math.ceil(((double) ccp.getLength() / vandbraet.getLength())) * 2;

      return amountNeeded;
   }

   private int calcVandbraetOnFront(CustomCarport ccp, WoodPiece vandbraet){
      int amountNeeded = (int) Math.ceil((double) ccp.getWidth() / vandbraet.getLength());

      return amountNeeded;
   }

   private int calcFlatRoofOverCCP(CustomCarport ccp, RoofMaterialOption roofMaterial){
      int toolshedLength = 0;

      if (ccp.getToolshed() != null) {
         toolshedLength = ccp.getToolshed().getToolshedLength();
      }

      int piecesNeededHorizontally = (int) Math.ceil((double) ccp.getWidth() / roofMaterial.getMaterialWidth());
      int piecesNeededVertically = (int) Math.ceil((double) (ccp.getLength() - toolshedLength) / roofMaterial.getMaterialLength());

      int amountNeeded = piecesNeededHorizontally * piecesNeededVertically;

      return amountNeeded;
   }

   private int calcFlatRoofOverCTS(CustomCarport ccp, RoofMaterialOption roofMaterial ){
      int piecesNeededHorizontally = (int) Math.ceil((double) ccp.getWidth() / roofMaterial.getMaterialWidth());
      int piecesNeededVertically = (int) Math.ceil((double) ccp.getToolshed().getToolshedLength() / roofMaterial.getMaterialLength());

      int amountNeeded = piecesNeededHorizontally * piecesNeededVertically;

      return amountNeeded;
   }

   // Todo: make calc. for non-plate types of roof options

   // Todo: make calc. for angled roofs (3 methods)

   private int calcScrewsForPlateRoofs(CustomCarport ccp, Screw screw){
      /*
         Assuming you need 12 screws for every m2
      */

      final int screwsNeededForEveryM2 = 12;
      int roofAreaInM2 = (int) Math.ceil(((double) ccp.getWidth() / 100) * ((double) ccp.getLength() / 100));
      int screwsNeeded = screwsNeededForEveryM2 * roofAreaInM2;

      int amountNeeded = (int) Math.ceil((double) screwsNeeded / screw.getPiecesPrPack());

      return amountNeeded;
   }

   private int calcHulbaand (CustomCarport ccp){
      /*
         Assuming that all hulbånd comes in 10m length
      */

      int toolshedLength = 0;

      if (ccp.getToolshed() != null) {
         toolshedLength = ccp.getToolshed().getToolshedLength();
      }

      int a = ccp.getWidth();
      int b = ccp.getLength() - toolshedLength;

      int hulbaandLengthNeeded = (int) (Math.ceil(Math.sqrt(a ^ 2 + b ^ 2)));

      int amountNeeded = (int) Math.ceil((double) hulbaandLengthNeeded / 1000);

      return amountNeeded;
   }

   private int calcUniConnector (MaterialListComponent spaer){
      int amountNeeded = spaer.getAmount();

      return amountNeeded;
   }

   private int calcScrewsForSternAndVandbraet(CustomCarport ccp, Screw screwsForSternAndVandbraet){
      int ccpOutlineInM = (int) Math.ceil((ccp.getWidth() * 2) + ((double) ccp.getLength() * 2) / 100);
      int screwsPerM = 8;

      int amountNeeded = (int) Math.ceil((double) screwsForSternAndVandbraet.getPiecesPrPack() / (ccpOutlineInM * screwsPerM));

      return amountNeeded;
   }

   private int calcBeslagSkruer(CustomCarport ccp, WoodPiece spaer, Screw beslagSkruer){
      int widthToCover = ccp.getLength() - spaer.getWidth() + ccp.getRafterSpacing();

      if (ccp.getToolshed() != null) {
         widthToCover -= ccp.getToolshed().getToolshedLength();
      }

      final int rafterSpacing = ccp.getRafterSpacing();
      double spaerThicknessIncm = (double) spaer.getThickness() / 10;

      int screwsForHulbaand = (int) Math.ceil((double) widthToCover / (spaerThicknessIncm + rafterSpacing) + 1) * 2;

      int screwsForBeslag = (int) Math.ceil(ccp.getLength() / (spaerThicknessIncm + rafterSpacing) + 1) * 4 * 9;

      int amountNeeded = (int) Math.ceil((double) (screwsForBeslag + screwsForHulbaand) / beslagSkruer.getPiecesPrPack());

      return amountNeeded;
   }

   private int calcBraeddebolt (CustomCarport ccp, Screw braeddebolt){
      final int amountPerPillar = 2;

      int amountOfPillars = 4;

      if (ccp.getToolshed() != null) {
         amountOfPillars += 6;
      }

      int amountNeeded = (amountOfPillars * amountPerPillar / braeddebolt.getPiecesPrPack());

      if(ccp.getToolshed() != null){
         amountNeeded += 2;
      }

      return amountNeeded;
   }

   private int calcfirkantskiver(CustomCarport ccp){
      int amountOfPillars = 4;

      if (ccp.getToolshed() != null) {
         amountOfPillars += 6;
      }

      int amountNeeded = amountOfPillars;

      if(ccp.getToolshed() != null){
         amountNeeded += 2;
      }

      return amountNeeded;
   }

   private int calcScrewsForOutterCladding(WoodPiece spaer, Screw screwsForOutterCladding){
      int amountNeeded = (int)Math.ceil((double)spaer.getAmount() * 3 / screwsForOutterCladding.getPiecesPrPack());

      return amountNeeded;
   }

   private int calcScrewsForInnerCladding(WoodPiece spaer, Screw screwsForInnerCladding){
      int amountNeeded = (int)Math.ceil((double)spaer.getAmount() * 3 / screwsForInnerCladding.getPiecesPrPack());

      return amountNeeded;
   }

   private int calcVinkelbeslag(WoodPiece loesholtForGables, WoodPiece loesholtForSides){
      int amountOfLoesholter = loesholtForGables.getAmount() + loesholtForSides.getAmount();
      int amountNeeded = amountOfLoesholter * 2;

      return amountNeeded;
   }
   // --------------------------------- Material calculations END ---------------------------------

}
