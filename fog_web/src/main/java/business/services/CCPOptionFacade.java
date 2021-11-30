package business.services;

import business.entities.*;
import business.exceptions.UserException;
import business.persistence.CustomCarportOptionMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CCPOptionFacade {

   CustomCarportOptionMapper customCarportOptionMapper;

   public CCPOptionFacade(Database database){
      customCarportOptionMapper = new CustomCarportOptionMapper(database);
   }

   public void getAllCustomCarpor() throws UserException {

   }

   public ArrayList<RoofTypeOption> getCCPRoofTypeOptions() throws UserException{
      return customCarportOptionMapper.getCCPRoofTypeOptions();
   }

   public ArrayList<RoofAngleOption> getCCPRoofAngleOptions() throws UserException{
      return customCarportOptionMapper.getCCPRoofAngleOptions();
   }

   public ArrayList<RoofMaterialOption> getCCPRoofMaterialOptions() throws UserException{
      return customCarportOptionMapper.getCCPRoofMaterialOptions();
   }

   public ArrayList<CCPWidthOption> getCCPWidthOptions() throws UserException{
      return customCarportOptionMapper.getCCPWidthOptions();
   }

   public ArrayList<CCPLengthOption> getCCPLengthOptions() throws UserException{
      return customCarportOptionMapper.getCCPLengthOptions();
   }

//   public ArrayList<CCPHeightOption> getCCPHeightOptions() throws UserException{
//      return customCarportOptionMapper.getCCPHeightOptions();
//   }
//
//   public ArrayList<CTSWidthOption> getCTSWidthOptions() throws UserException{
//      return customCarportOptionMapper.getCTSWidthOptions();
//   }
//
//   public ArrayList<CTSLengthOption> getCTSLengthOptions() throws UserException{
//      return customCarportOptionMapper.getCTSLengthOptions();
//   }

}
