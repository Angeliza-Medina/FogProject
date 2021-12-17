package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;

public class CCPOptionMapper {
   private Database database;

   public CCPOptionMapper(Database database) {
      this.database = database;
   }


   public ArrayList<RoofTypeOption> getCCPRoofTypeOptions() throws UserException {
      ArrayList<RoofTypeOption> roofTypeOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM ccp_roof_type_options ORDER BY roofType_id";

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

   public ArrayList<Integer> getCCPRoofAngleOptions() throws UserException {
      ArrayList<Integer> roofAngleOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM ccp_roof_angle_options ORDER BY ccpRoofAngle";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int angle = rs.getInt("ccpRoofAngle");

               roofAngleOptions.add(angle);
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
         String sql = "SELECT " +
                "roofMaterial_id, fk_roofType_id, material, materialWidth, materialLength, price, units.unit AS unit " +
                "FROM ccp_roof_material_options\n" +
                  "INNER JOIN units ON ccp_roof_material_options.fk_unit_id = units.unit_id " +
                "GROUP BY material " +
                "ORDER BY roofMaterial_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("roofMaterial_id");
               int roofType = rs.getInt("fk_roofType_id");
               String material = rs.getString("material");
               int materialWidth = rs.getInt("materialWidth");
               int materialLength = rs.getInt("materialLength");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";

               RoofMaterialOption roofMaterialOption = new RoofMaterialOption(
               id, material, unit, price, desc, roofType, materialWidth, materialLength);

//               RoofMaterialOption roofMaterialOption = new RoofMaterialOption(id, roofType, material, materialWidth, materialLength, price);
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

   public ArrayList<Integer> getCCPWidthOptions() throws UserException {
      ArrayList<Integer> ccpWidthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM ccp_width_options ORDER BY ccpWidth";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int width = rs.getInt("ccpWidth");

               ccpWidthOptions.add(width);
            } while (rs.next());

            return ccpWidthOptions;
         } else {
            throw new UserException("Could retrieve custom carport width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<Integer> getCCPLengthOptions() throws UserException {
      ArrayList<Integer> ccpLengthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM ccp_length_options ORDER BY ccpLength";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int length = rs.getInt("ccpLength");

               ccpLengthOptions.add(length);
            } while (rs.next());

            return ccpLengthOptions;
         } else {
            throw new UserException("Could retrieve custom carport length options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<Integer> getCCPHeightOptions() throws UserException {
      ArrayList<Integer> cCPHeightOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM ccp_height_options ORDER BY ccpHeight";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int height = rs.getInt("ccpHeight");

               cCPHeightOptions.add(height);
            } while (rs.next());

            return cCPHeightOptions;
         } else {
            throw new UserException("Could retrieve custom carport height options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<Integer> getCTSWidthOptions() throws UserException {
      ArrayList<Integer> cTSWidthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM cts_width_options ORDER BY ctsWidth";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int width = rs.getInt("ctsWidth");

               cTSWidthOptions.add(width);
            } while (rs.next());

            return cTSWidthOptions;
         } else {
            throw new UserException("Could retrieve custom toolshed width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<Integer> getCTSLengthOptions() throws UserException {
      ArrayList<Integer> cTSLengthOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql = "SELECT * FROM cts_length_options ORDER BY ctsLength";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int length = rs.getInt("ctsLength");

               cTSLengthOptions.add(length);
            } while (rs.next());

            return cTSLengthOptions;
         } else {
            throw new UserException("Could retrieve custom toolshed width options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CTSCladdingOption> getCTSCladdingOptions() throws UserException {
      ArrayList<CTSCladdingOption> ctsCladdingOptions = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT cts_cladding_id, cladding, thickness, width, length, price, units.unit AS unit " +
                "FROM cts_cladding_options " +
                  "INNER JOIN units ON cts_cladding_options.fk_unit_id = units.unit_id " +
                "ORDER BY cts_cladding_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int id = rs.getInt("cts_cladding_id");
               String cladding = rs.getString("cladding");
               String unit = rs.getString("unit");
               double price = rs.getInt("price");
               String desc = "";

               CTSCladdingOption ctsCladdingOption = new CTSCladdingOption(
                      id, cladding, unit, price, desc);

               ctsCladdingOptions.add(ctsCladdingOption);
            } while (rs.next());

            return ctsCladdingOptions;
         } else {
            throw new UserException("Could retrieve cladding options from our database at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

}
