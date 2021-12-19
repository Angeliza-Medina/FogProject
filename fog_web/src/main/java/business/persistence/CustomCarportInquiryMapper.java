package business.persistence;

import business.entities.CustomCarport;
import business.entities.CustomCarportInquiry;
import business.entities.Toolshed;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class CustomCarportInquiryMapper {


    private Database database;

    public CustomCarportInquiryMapper(Database database) throws UserException {
        this.database = database;
    }

    public CustomCarportInquiry getSearchInquiryById(int search_input) throws UserException {
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
                            "WHERE custom_carport_inquiry_id = ?";


            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, search_input);


                ResultSet rs = ps.executeQuery();

                Toolshed toolshed = null;

                if (rs.getInt("cts_id") != 0) {
                    int cts_id = rs.getInt("cts_id");
                    int ctsWidth = rs.getInt("ctsWidth");
                    int ctsLength = rs.getInt("ctsLength");
                    int ctsCladding_id = rs.getInt("ctsCladding_id");
                    toolshed = new Toolshed(cts_id, ctsWidth, ctsLength, ctsCladding_id);


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

                    return inquiry;
                } else {
                    throw new UserException("Could not validate user");
                }
            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}