package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;

public class CustomCarportOptionMapper {
   private Database database;

   public CustomCarportOptionMapper(Database database) {
      this.database = database;
   }


   public ArrayList<RoofTypeOption> getCCPRoofTypeOptions() throws UserException {
      ArrayList<RoofTypeOption> roofTypeOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_roof_type_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("roofType_id");
               String type = rs.getString("type");

               RoofTypeOption roofTypeOption = new RoofTypeOption(id, type);
               roofTypeOptions.add(roofTypeOption);
            } while (rs.next());

            return roofTypeOptions;
         } else {
            throw new UserException("Could retrieve roof type options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

//   public ArrayList<RoofAngleOption> getCCPRoofAngleOptions() throws UserException {
//   }
//
//   public ArrayList<RoofMaterialOption> getCCPRoofMaterialOptions() throws UserException {
//   }
//
//   public ArrayList<CCPWidthOption> getCCPWidthOptions() throws UserException {
//   }
//
//   public ArrayList<CCPLengthOption> getCCPLengthOptions() throws UserException {
//   }
//
//   public ArrayList<CCPHeightOption> getCCPHeightOptions() throws UserException {
//   }
//
//   public ArrayList<CTSWidthOption> getCTSWidthOptions() throws UserException {
//   }
//
//   public ArrayList<CTSLengthOption> getCTSLengthOptions() throws UserException {
//   }
}
