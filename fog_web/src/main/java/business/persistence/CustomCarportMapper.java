package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class CustomCarportMapper {

    private Database database;

    public CustomCarportMapper(Database database){
        this.database = database;
    }


    public void sendInquiryToDB1(CustomCarportInquiry ccpi) throws UserException{
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
                ps.setInt(1, ccpi.getCustomCarport().getToolshed().getToolshedWidth());
                ps.setInt(2, ccpi.getCustomCarport().getToolshed().getToolshedLength());
                ps.setInt(3, ccpi.getCustomCarport().getToolshed().getToolshedCladdingId());

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

                ps.executeUpdate();
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Could not establish connection to our database at the moment...");
        }
    }

    public void sendInquiryToDB2(CustomCarportInquiry ccpi) throws UserException{
        try (Connection connection = database.connect()) {

            String sql =
                  "INSERT INTO ccp (fk_ccpWidth, fk_ccpLength, fk_ccpHeight, fk_rafterSpacing, fk_ccpRoofType_id, fk_ccpRoofAngle, fk_ccpRoofMaterial_id, fk_cts_id)\n" +
                  "    VALUES(?, ?, ?, 0.86, ?, ?, ?, ?) ;\n" +
                  "INSERT INTO ccp_inquiries (inquiryDate, fk_user_id, firstName, lastName, email, phoneNum, address, postalcode, city, note, fk_ccp_id)\n" +
                  "    VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, LAST_INSERT_ID()) ;\n";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                // Inserts into ccp
                ps.setInt(1, ccpi.getCustomCarport().getWidth());
                ps.setInt(2, ccpi.getCustomCarport().getLength());
                ps.setInt(3, ccpi.getCustomCarport().getHeight());
                ps.setInt(4, ccpi.getCustomCarport().getRoofTypeId());
                ps.setInt(5, ccpi.getCustomCarport().getRoofAngle());
                ps.setInt(6, ccpi.getCustomCarport().getRoofMaterialId());
                ps.setNull(7, Types.INTEGER);

                // Inserts into ccp_inquiries
                LocalDate inquiryDate = LocalDate.now();
                ps.setDate(8, Date.valueOf(inquiryDate));

                if(ccpi.getUserId() != 0){
                    ps.setInt(9, ccpi.getUserId());
                }else{
                    ps.setNull(9, Types.INTEGER);
                }

                ps.setString(10, ccpi.getContactInfo().getFirstName());
                ps.setString(11, ccpi.getContactInfo().getLastName());
                ps.setString(12, ccpi.getContactInfo().getEmail());
                ps.setString(13, ccpi.getContactInfo().getPhoneNum());
                ps.setString(14, ccpi.getContactInfo().getAddress());
                ps.setInt(15, ccpi.getContactInfo().getPostalCode());
                ps.setString(16, ccpi.getContactInfo().getCity());
                ps.setString(17, ccpi.getNote());

                ps.executeUpdate();
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
                   "SELECT custom_carport_inquiry_id AS inquiry_id,\n" +
                      "       inquiryDate, ccp_inquiry_statuses.status AS status,\n" +
                      "       ccp.ccp_id AS ccp_id, ccp.fk_ccpWidth AS ccpWidth,\n" +
                      "       ccp.fk_ccpLength AS ccpLength,\n" +
                      "       ccp.fk_ccpHeight AS ccpHeight,\n" +
                      "       ccp.fk_cts_id AS cts_id,\n" +
                      "       cts.fk_ctsWidth AS ctsWidth,\n" +
                      "       cts.fk_ctsLength AS ctsLength, \n" +
                      "       cts.fk_cladding_id AS ctsCladding_id \n" +
                      "FROM (((ccp_inquiries\n" +
                      "   INNER JOIN ccp_inquiry_statuses ON ccp_inquiries.fk_status_id = ccp_inquiry_statuses.status_id)\n" +
                      "   INNER JOIN ccp ON ccp_inquiries.fk_ccp_id = ccp.ccp_id)\n" +
                      "   LEFT JOIN cts ON ccp.fk_cts_id = cts.cts_id)\n" +
                      "ORDER BY status";

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                do {
                    // CTS data
                    Toolshed toolshed = null;

                    if(rs.getInt("cts_id") != 0){
                        int cts_id = rs.getInt("cts_id");
                        int ctsWidth = rs.getInt("ctsWidth");
                        int ctsLength = rs.getInt("ctsLength");
                        int ctsCladding_id = rs.getInt("ctsCladding_id");
                        toolshed = new Toolshed(cts_id, ctsWidth, ctsLength, ctsCladding_id);
                    }

                    // CCP data
                    int ccp_id = rs.getInt("ccp_id");
                    int ccpWidth = rs.getInt("ccpWidth");
                    int ccpLength = rs.getInt("ccpLength");
                    int ccpHeight = rs.getInt("ccpHeight");

                    CustomCarport customCarport = new CustomCarport(ccp_id, ccpWidth, ccpLength, ccpHeight, toolshed);

                    // Inquiry data
                    int inquiry_id = rs.getInt("inquiry_id");
                    LocalDate inquiryDate = rs.getDate("inquiryDate").toLocalDate();
                    String inquiryStatus = rs.getString("status");

                    CustomCarportInquiry inquiry = new CustomCarportInquiry(inquiry_id, inquiryDate, inquiryStatus, customCarport);

                    inquiries.add(inquiry);
                } while (rs.next());

                return inquiries;
            }else{
                throw new UserException("Der er endnu ikke registreret nogle forespørgsler i databasen...");
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }

    }

    public CustomCarportInquiry getInquiryById(int inquiryId) throws UserException{
        CustomCarportInquiry customCarportInquiry = null;

        try (Connection connection = database.connect()) {
            String sql =
                   " SELECT\n" +
                   "    custom_carport_inquiry_id AS inquiry_id,\n" +
                   "    inquiryDate,\n" +
                   "    ccp_inquiry_statuses.status AS status,\n" +
                   "    firstName, lastName, email, phoneNum, address, postalcode, city, note,\n" +
                   "    ccp.ccp_id AS ccp_id,\n" +
                   "    ccp.fk_ccpWidth AS ccpWidth,\n" +
                   "    ccp.fk_ccpLength AS ccpLength,\n" +
                   "    ccp.fk_ccpHeight AS ccpHeight,\n" +
                   "    ccp.middlePilar AS middlePilar,\n" +
                   "    ccp.fk_rafterSpacing AS rafterSpacing,\n" +
                   "    ccp.fk_ccpRoofType_id AS roofType_id,\n" +
                   "    ccp.fk_ccpRoofAngle AS roofAngle,\n" +
                   "    ccp.fk_ccpRoofMaterial_id AS roofMaterial_id,\n" +
                   "    ccp.price,\n" +
                   "    ccp.fk_cts_id AS cts_id,\n" +
                   "    cts.fk_ctsWidth AS ctsWidth,\n" +
                   "    cts.fk_ctsLength AS ctsLength,\n" +
                   "    cts.fk_cladding_id AS ctsCladding_id \n" +
                   "FROM (((ccp_inquiries\n" +
                   "    INNER JOIN ccp_inquiry_statuses ON ccp_inquiries.fk_status_id = ccp_inquiry_statuses.status_id)\n" +
                   "    INNER JOIN ccp ON ccp_inquiries.fk_ccp_id = ccp.ccp_id)\n" +
                   "    LEFT JOIN cts ON ccp.fk_cts_id = cts.cts_id)\n" +
                   "WHERE custom_carport_inquiry_id = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, inquiryId);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    //CTS
                    Toolshed toolshed = null;

                    if(rs.getInt("cts_id") != 0){
                        int cts_id = rs.getInt("cts_id");
                        int ctsWidth = rs.getInt("ctsWidth");
                        int ctsLength = rs.getInt("ctsLength");
                        int ctsCladding_id = rs.getInt("ctsCladding_id");

                        toolshed = new Toolshed(cts_id, ctsWidth, ctsLength, ctsCladding_id);
                    }

                    // CCP
                    CustomCarport customCarport = null;

                    int ccp_id = rs.getInt("ccp_id");
                    int ccpWidth = rs.getInt("ccpWidth");
                    int ccpLength = rs.getInt("ccpLength");
                    int ccpHeight = rs.getInt("ccpHeight");
                    boolean middlePilar = rs.getBoolean("middlePilar");
                    double rafterSpacing = rs.getDouble("rafterSpacing");
                    int roofType_id = rs.getInt("roofType_id");
                    int roofAngle = rs.getInt("roofAngle");
                    int roofMaterial_id = rs.getInt("roofMaterial_id");
                    double price = rs.getDouble("price");

                    customCarport = new CustomCarport(
                           ccp_id, ccpWidth, ccpLength, ccpHeight, middlePilar, rafterSpacing, roofType_id, roofAngle,
                           roofMaterial_id, toolshed, price);

                    // Contact info
                    ContactInfo contactInfo = null;

                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String email = rs.getString("email");
                    String phoneNum = rs.getString("phoneNum");
                    String address = rs.getString("address");
                    int postalcode = rs.getInt("postalcode");
                    String city = rs.getString("city");

                    contactInfo = new ContactInfo(firstName, lastName, address, postalcode, city, email, phoneNum);

                    // Inquiries
                    int inquiry_id = rs.getInt("inquiry_id");
                    LocalDate inquiryDate = rs.getDate("inquiryDate").toLocalDate();
                    String inquiryStatus = rs.getString("status");
                    String note = rs.getString("note");

                    customCarportInquiry = new CustomCarportInquiry(inquiry_id, inquiryDate, inquiryStatus, note, contactInfo,
                           customCarport);

                    return customCarportInquiry;
                } else {
                    System.out.println("Here");
                    throw new UserException("No corresponding inquiry was found in the database...");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException("Connection to database could not be established");
        }
    }
}

