package business.services;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.CCPOptionMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CCPOptionFacade {

   CCPOptionMapper ccpOptionMapper;

   public CCPOptionFacade(Database database){
      ccpOptionMapper = new CCPOptionMapper(database);
   }


   public ArrayList<RoofTypeOption> getCCPRoofTypeOptions() throws UserException{
      return ccpOptionMapper.getCCPRoofTypeOptions();
   }

   public ArrayList<Integer> getCCPRoofAngleOptions() throws UserException{
      return ccpOptionMapper.getCCPRoofAngleOptions();
   }

   public ArrayList<RoofMaterialOption> getCCPRoofMaterialOptions() throws UserException{
      return ccpOptionMapper.getCCPRoofMaterialOptions();
   }

   public ArrayList<Integer> getCCPWidthOptions() throws UserException{
      return ccpOptionMapper.getCCPWidthOptions();
   }

   public ArrayList<Integer> getCCPLengthOptions() throws UserException{
      return ccpOptionMapper.getCCPLengthOptions();
   }

   public ArrayList<Integer> getCCPHeightOptions() throws UserException{
      return ccpOptionMapper.getCCPHeightOptions();
   }

   public ArrayList<Integer> getCTSWidthOptions() throws UserException{
      return ccpOptionMapper.getCTSWidthOptions();
   }

   public ArrayList<Integer> getCTSLengthOptions() throws UserException{
      return ccpOptionMapper.getCTSLengthOptions();
   }

   public ArrayList<CTSCladdingOption> getCladdingOptions() throws UserException{
      return ccpOptionMapper.getCTSCladdingOptions();
   }

}
