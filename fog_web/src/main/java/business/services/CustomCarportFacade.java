package business.services;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;
import business.persistence.CustomCarportMapper;
import business.persistence.Database;

import java.util.ArrayList;

public class CustomCarportFacade {
    CustomCarportMapper customCarportMapper;

    public CustomCarportFacade(Database database){
        customCarportMapper = new CustomCarportMapper(database);
    }


    public void sendInquiryToDB1(CustomCarportInquiry cpi) throws UserException{
        customCarportMapper.sendInquiryToDB1(cpi);
    }

    public void sendInquiryToDB2(CustomCarportInquiry cpi) throws UserException{
        customCarportMapper.sendInquiryToDB2(cpi);
    }

    public ArrayList<CustomCarportInquiry> getAllCCPI() throws UserException{
        return customCarportMapper.getAllCCPI();
    }

    public CustomCarportInquiry getInquiryById(int inquiryId) throws UserException{
        return customCarportMapper.getInquiryById(inquiryId);
    }

   public CustomCarportInquiry getSearchInquiryById(String searchInput) throws UserException{
       return customCarportMapper.getSearchInquiryById(searchInput);
   }

}