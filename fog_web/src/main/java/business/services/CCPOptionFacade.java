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

//   public ArrayList<RoofAngleOption> getCCPRoofAngleOptions() throws UserException{
//      return customCarportOptionMapper.getCCPRoofAngleOptions();
//   }
//
//   public ArrayList<RoofMaterialOption> getCCPRoofMaterialOptions() {
//      return customCarportOptionMapper.getCCPRoofMaterialOptions();
//   }
//
//   public ArrayList<CCPWidthOption> getCCPWidthOptions() {
//      return customCarportOptionMapper.getCCPWidthOptions();
//   }
//
//   public ArrayList<CCPLengthOption> getCCPLengthOptions() {
//      return customCarportOptionMapper.getCCPLengthOptions();
//   }
//
//   public ArrayList<CCPHeightOption> getCCPHeightOptions() {
//      return customCarportOptionMapper.getCCPHeightOptions();
//   }
//
//   public ArrayList<CTSWidthOption> getCTSWidthOptions() {
//      return customCarportOptionMapper.getCTSWidthOptions();
//   }
//
//   public ArrayList<CTSLengthOption> getCTSLengthOptions() {
//      return customCarportOptionMapper.getCTSLengthOptions();
//   }

}
