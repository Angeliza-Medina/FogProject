package business.persistence;

import business.entities.CustomCarportInquiry;
import business.entities.User;
import business.exceptions.UserException;


import java.sql.*;
import java.time.LocalDate;
import java.util.function.ToDoubleBiFunction;

public class CustomCarportMapper {

    private Database database;

    public CustomCarportMapper(Database database){
        this.database = database;
    }

    public void sendInquiryToDatabase(CustomCarportInquiry cpi) throws UserException{
        try (Connection connection = database.connect()) {
            LocalDate inquiryDate = LocalDate.now();
            String sql = "INSERT INTO custom_carport_inquiries (inquiryDate, fk_user_id, firstName, lastName, email, " +
                   "phoneNum, address, postalcode, city, note, fk_carportWidth_id, fk_carportLength_id, fk_carportHeight_id, " +
                   "fk_rooftype_id, fk_roofMaterial_id, fk_roofAngle_id, fk_toolshedWidth_id, fk_toolshedLength_id) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDate(1, Date.valueOf(inquiryDate));
                ps.setInt(2, 2); //TODO fix user_id so it's not hardcoded
                ps.setString(3, cpi.getContactInfo().getFirstName());
                ps.setString(4, cpi.getContactInfo().getLastName());
                ps.setString(5, cpi.getContactInfo().getEmail());
                ps.setString(6, cpi.getContactInfo().getPhoneNum());
                ps.setString(7, cpi.getContactInfo().getAddress());
                ps.setInt(8, cpi.getContactInfo().getPostalCode());
                ps.setString(9, cpi.getContactInfo().getTown());
                ps.setString(10, cpi.getNote());
                ps.setInt(11, cpi.getCarportWidth());
                ps.setInt(12, cpi.getCarportLength());
                ps.setInt(13, cpi.getCarportHeight());
                ps.setInt(14, cpi.getRoofType());
                ps.setInt(15, cpi.getRoofMaterial());
                ps.setInt(16, cpi.getRoofAngle());
                ps.setInt(17, cpi.getToolInfo().getToolshedWidth());
                ps.setInt(18, cpi.getToolInfo().getToolshedLength());

                ps.executeUpdate();
                System.out.println("Here: 1");

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }



    }

