package business.persistence;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDate;

public class CustomCarportMapper {

    private Database database;

    public CustomCarportMapper(Database database){
        this.database = database;
    }

    public void sendInquiryToDatabase(CustomCarportInquiry ccpi) throws UserException{
        try (Connection connection = database.connect()) {

            String sql =
                   "INSERT INTO cts (fk_ctsWidth, fk_ctsLength, fk_cladding_id)\n" +
                   "    VALUES(?, ?, ?);\n" +
                   "INSERT INTO ccp (fk_ccpWidth, fk_ccpLength, fk_ccpHeight, fk_rafterSpacing, fk_ccpRoofType_id, fk_ccpRoofAngle, fk_ccpRoofMaterial_id, fk_cts_id)\n" +
                   "    VALUES(?, ?, ?, 0.86, ?, ?, ?, LAST_INSERT_ID());\n" +
                   "INSERT INTO ccp_inquiries (inquiryDate, fk_user_id, firstName, lastName, email, phoneNum, address, postalcode, city, note, fk_ccp_id)\n" +
                   "    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID());\n";

//            String sql = "START TRANSACTION; " +
//                   "INSERT INTO cts (fk_ctsWidth, fk_ctsLength, fk_cladding_id)\n" +
//                   "    VALUES(?, ?, ?);\n" +
//                   "INSERT INTO ccp (fk_ccpWidth, fk_ccpLength, fk_ccpHeight, fk_rafterSpacing, fk_ccpRoofType_id, fk_ccpRoofAngle, fk_ccpRoofMaterial_id, fk_cts_id)\n" +
//                   "    VALUES(?, ?, ?, 0.86, ?, ?, ?, LAST_INSERT_ID()) ;\n" +
//                   "INSERT INTO ccp_inquiries (inquiryDate, fk_user_id, firstName, lastName, email, phoneNum, address, postalcode, city, note, fk_ccp_id)\n" +
//                   "    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID()) ;\n" +
//                   "COMMIT;";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                // Inserts into cts
                ps.setInt(1, ccpi.getToolshedInfo().getToolshedWidth());
                ps.setInt(2, ccpi.getToolshedInfo().getToolshedLength());
                ps.setInt(3, ccpi.getToolshedInfo().getToolshedCladdingId());

                // Inserts into ccp
                ps.setInt(4, ccpi.getCarportWidth());
                ps.setInt(5, ccpi.getCarportLength());
                ps.setInt(6, ccpi.getCarportHeight());
                ps.setInt(7, ccpi.getRoofTypeId());
                ps.setInt(8, ccpi.getRoofAngle());
                ps.setInt(9, ccpi.getRoofMaterialId());

                // Inserts into ccp_inquiries
                LocalDate inquiryDate = LocalDate.now();
                ps.setDate(10, Date.valueOf(inquiryDate));

                if(ccpi.getUserId() != 0){
                    ps.setInt(11, ccpi.getUserId());
                }else{
                    ps.setNull(11, Types.INTEGER);
                }

                ps.setString(12, ccpi.getContactInfo().getFirstName());
                ps.setString(13, ccpi.getContactInfo().getLastName());
                ps.setString(14, ccpi.getContactInfo().getEmail());
                ps.setString(15, ccpi.getContactInfo().getPhoneNum());
                ps.setString(16, ccpi.getContactInfo().getAddress());
                ps.setInt(17, ccpi.getContactInfo().getPostalCode());
                ps.setString(18, ccpi.getContactInfo().getCity());
                ps.setString(19, ccpi.getNote());

                ps.executeUpdate();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Could not establish connection to our database at the moment...");
        }
    }



    }

