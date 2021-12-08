package business.persistence;

import business.entities.CustomCarport;
import business.entities.CustomCarportInquiry;
import business.entities.Toolshed;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
                   "    VALUES(?, ?, ?, 0.86, ?, ?, ?, LAST_INSERT_ID()) ;\n" +
                   "INSERT INTO ccp_inquiries (inquiryDate, fk_user_id, firstName, lastName, email, phoneNum, address, postalcode, city, note, fk_ccp_id)\n" +
                   "    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID()) ;\n";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                // Inserts into cts
                ps.setInt(1, ccpi.getToolshed().getToolshedWidth());
                ps.setInt(2, ccpi.getToolshed().getToolshedLength());
                ps.setInt(3, ccpi.getToolshed().getToolshedCladdingId());

                // Inserts into ccp
                ps.setInt(4, ccpi.getCustomCarport().getWidth());
                ps.setInt(5, ccpi.getCustomCarport().getLength());
                ps.setInt(6, ccpi.getCustomCarport().getHeight());
                ps.setInt(7, ccpi.getCustomCarport().getRoofTypeId());
                ps.setInt(8, ccpi.getCustomCarport().getRoofAngle());
                ps.setInt(9, ccpi.getCustomCarport().getRoofMaterialId());

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

                System.out.println("Here before execute");
                ps.executeUpdate();
                System.out.println("Here after execute");
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Could not establish connection to our database at the moment...");
        }
    }

    public ArrayList<CustomCarportInquiry> getAllCCPI() throws UserException{
        ArrayList<CustomCarportInquiry> inquiries = new ArrayList<>();

        try (Connection connection = database.connect()) {
            String sql =
                   "SELECT custom_carport_inquiry_id AS inquiry_id, " +
                       "inquiryDate, " +
                       "ccp_inquiry_statuses.status AS status, " +
                       "ccp.ccp_id AS ccp_id, " +
                       "ccp.fk_ccpWidth AS ccpWidth,\n" +
                       "ccp.fk_ccpLength AS ccpLength, " +
                       "ccp.fk_ccpHeight AS ccpHeight, " +
                       "ccp.fk_cts_id AS cts_id,\n" +
                       "cts.fk_ctsWidth AS ctsWidth, " +
                       "cts.fk_ctsLength AS ctsLength\n" +
                   "FROM (((ccp_inquiries\n" +
                   "    INNER JOIN ccp_inquiry_statuses ON ccp_inquiries.fk_status_id = ccp_inquiry_statuses.status_id)\n" +
                   "    INNER JOIN ccp ON ccp_inquiries.fk_ccp_id = ccp.ccp_id)\n" +
                   "    INNER JOIN cts ON ccp.fk_cts_id = cts.cts_id)";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                do {
                    // CTS data
                    int cts_id = rs.getInt("cts_id");
                    int ctsWidth = rs.getInt("ctsWidth");
                    int ctsLength = rs.getInt("ctsLength");

                    Toolshed toolshed = new Toolshed(cts_id, ctsWidth, ctsLength);

                    // CCP data
                    int ccp_id = rs.getInt("ccp_id");
                    int ccpWidth = rs.getInt("ccpWidth");
                    int ccpLength = rs.getInt("ccpLength");
                    int ccpHeight = rs.getInt("ccpHeight");

                    CustomCarport customCarport = new CustomCarport(ccp_id, ccpWidth, ccpLength, ccpHeight);

                    // Inquiry data
                    int inquiry_id = rs.getInt("inquiry_id");
                    LocalDate inquiryDate = rs.getDate("inquiryDate").toLocalDate();
                    String inquiryStatus = rs.getString("status");

                    CustomCarportInquiry inquiry = new CustomCarportInquiry(inquiry_id, inquiryDate, inquiryStatus, customCarport, toolshed);

                    inquiries.add(inquiry);
                } while (rs.next());

            } else {
                // Todo: Change to something else
                System.out.println("Something went wrong...");
            }

            return inquiries;
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

}

