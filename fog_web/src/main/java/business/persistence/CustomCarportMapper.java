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

        System.out.println("jeg er her");

        try (Connection connection = database.connect()) {
            LocalDate inquiryDate = LocalDate.now();
            String sql = "INSERT INTO custom_carport_inquiries (inquiryDate, fk_user_id, firstName, lastName, email," +
                    "phoneNum, address, postalcode, city, fk_caportWidth_id, fk_caportLength_id, fk_caportHeight_id, fk_rooftype_id, fk_roofMaterial_id" +
                    "fk_roofAngle_id, fk_toolshedWidth_id, fk_toolshedLength_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setDate(1, Date.valueOf(inquiryDate));
                //TODO fix user_id so it's not hardcoded
                ps.setInt(2, 2);
                ps.setString(3, cpi.getContanctInfo().getFirstName());
                ps.setString(4, cpi.getContanctInfo().getLastName());
                ps.setString(5, cpi.getContanctInfo().getEmail());
                ps.setInt(6, cpi.getContanctInfo().getPhoneNum());
                ps.setString(7, cpi.getContanctInfo().getAddress());
                ps.setInt(8, cpi.getContanctInfo().getPostalCode());
                ps.setString(9, cpi.getContanctInfo().getTown());


                ps.setInt(10, cpi.getCarportWidth());
                ps.setInt(11, cpi.getCarportLength());
                ps.setInt(12, cpi.getCarportHeight());
                ps.setInt(13, cpi.getRoofType());
                ps.setInt(14, cpi.getRoofMaterial());
                ps.setInt(15, cpi.getRoofAngle());
                ps.setInt(16, cpi.getToolInfo().getToolshedWidth());
                ps.setInt(17, cpi.getToolInfo().getToolshedLength());

                ps.executeUpdate();


                ResultSet ids = ps.getGeneratedKeys();
                ids.next();
                int id = ids.getInt(1);
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
    }



    }

