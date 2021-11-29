package business.services;

import business.entities.CustomCaportInquiry;
import business.exceptions.UserException;
import business.persistence.Database;

import static web.commands.Command.database;
public class CustomCarportFacade {
    CustomCarportMapper CustomCarportMapper;

    public CustomCarportFacade(Database database){
        CustomCarportMapper = new CustomCarportMapper(database);
    }

    public void sendInquiryToDB(CustomCarportInquiry cpi) throws UserException{
        CustomCarportMapper.sendInquiryToDatabase(cpi);
    }
}