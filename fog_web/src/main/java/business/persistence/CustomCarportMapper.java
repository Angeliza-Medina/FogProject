package business.persistence;

import business.entities.CustomCarportInquiry;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomCarportMapper {

    private Database database;

    public CustomCarportMapper(Database database){
        this.database = database;
    }

    public void sendInquiryToDatabase(CustomCarportInquiry cpi) throws UserException{

    }

}
