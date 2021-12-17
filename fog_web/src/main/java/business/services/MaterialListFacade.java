package business.services;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.Database;
import business.persistence.MaterialListMapper;

import java.util.ArrayList;

public class MaterialListFacade {
   MaterialListMapper materialListMapper;

   public MaterialListFacade(Database database){
      materialListMapper = new MaterialListMapper(database);
   }


   public ArrayList<WoodPiece> getAllWoodPieces() throws UserException{
      return materialListMapper.getAllWoodPieces();
   }

   public ArrayList<RoofMaterialOption> getAllRoofMaterial() throws UserException{
      return materialListMapper.getAllRoofMaterial();
   }

   public ArrayList<Screw> getAllScrews() throws UserException {
      return materialListMapper.getAllScrews();
   }

   public ArrayList<WoodConnector> getAllWoodConnectors() throws UserException{
      return materialListMapper.getAllWoodConnectors();
   }

   public CTSCladdingOption getCladdingById(int claddingId) throws UserException{
      return materialListMapper.getCladdingById(claddingId);
   }

   public ArrayList<CTSDoorComponent> getAllDoorComponents() throws UserException{
      return materialListMapper.getAllDoorComponents();
   }

}
