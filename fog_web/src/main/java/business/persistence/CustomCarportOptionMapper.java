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

   public ArrayList<RoofAngleOption> getCCPRoofAngleOptions() throws UserException {
      ArrayList<RoofAngleOption> roofAngleOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_roof_angle_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("roofAngleOption_id");
               int angle = rs.getInt("angle");

               RoofAngleOption roofAngleOption = new RoofAngleOption(id, angle);
               roofAngleOptions.add(roofAngleOption);
            } while (rs.next());

            return roofAngleOptions;
         } else {
            throw new UserException("Could retrieve roof angle options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<RoofMaterialOption> getCCPRoofMaterialOptions() throws UserException {
      ArrayList<RoofMaterialOption> roofMaterialOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_roof_material_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("roofMaterial_id");
               int roofType = rs.getInt("fk_roofType_id");
               String material = rs.getString("material");

               RoofMaterialOption roofMaterialOption = new RoofMaterialOption(id, roofType, material);
               roofMaterialOptions.add(roofMaterialOption);
            } while (rs.next());

            return roofMaterialOptions;
         } else {
            throw new UserException("Could retrieve roof material options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CCPWidthOption> getCCPWidthOptions() throws UserException {
      ArrayList<CCPWidthOption> cCPWidthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_width_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("carportWidthOption_id");
               int width = rs.getInt("width");

               CCPWidthOption cCPWidthOption = new CCPWidthOption(id, width);
               cCPWidthOptions.add(cCPWidthOption);
            } while (rs.next());

            return cCPWidthOptions;
         } else {
            throw new UserException("Could retrieve custom carport width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CCPLengthOption> getCCPLengthOptions() throws UserException {
      ArrayList<CCPLengthOption> cCPLengthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_length_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("carportLengthOption_id");
               int length = rs.getInt("length");

               CCPLengthOption cCPLengthOption = new CCPLengthOption(id, length);
               cCPLengthOptions.add(cCPLengthOption);
            } while (rs.next());

            return cCPLengthOptions;
         } else {
            throw new UserException("Could retrieve custom carport length options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CCPHeightOption> getCCPHeightOptions() throws UserException {
      ArrayList<CCPHeightOption> cCPHeightOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM carport_height_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("carportHeightOption_id");
               int height = rs.getInt("height");

               CCPHeightOption cCPHeightOption = new CCPHeightOption(id, height);
               cCPHeightOptions.add(cCPHeightOption);
            } while (rs.next());

            return cCPHeightOptions;
         } else {
            throw new UserException("Could retrieve custom carport height options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CTSWidthOption> getCTSWidthOptions() throws UserException {
      ArrayList<CTSWidthOption> cTSWidthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM toolshed_width_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("toolshedWidthOption_id");
               int width = rs.getInt("width");

               CTSWidthOption cCPWidthOption = new CTSWidthOption(id, width);
               cTSWidthOptions.add(cCPWidthOption);
            } while (rs.next());

            return cTSWidthOptions;
         } else {
            throw new UserException("Could retrieve custom toolshed width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CTSLengthOption> getCTSLengthOptions() throws UserException {
      ArrayList<CTSLengthOption> cTSLengthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM toolshed_length_options";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("toolshedLengthOption_id");
               int length = rs.getInt("length");

               CTSLengthOption cCPWidthOption = new CTSLengthOption(id, length);
               cTSLengthOptions.add(cCPWidthOption);
            } while (rs.next());

            return cTSLengthOptions;
         } else {
            throw new UserException("Could retrieve custom toolshed width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

}
