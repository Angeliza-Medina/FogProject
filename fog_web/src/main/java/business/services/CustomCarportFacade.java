package business.services;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;
import business.persistence.CustomCarportMapper;
import business.persistence.Database;

public class CustomCarportFacade {
    CustomCarportMapper customCarportMapper;

    public CustomCarportFacade(Database database){
        customCarportMapper = new CustomCarportMapper(database);
    }

    public void sendInquiryToDB(CustomCarportInquiry cpi) throws UserException{
        customCarportMapper.sendInquiryToDatabase(cpi);
    }

}