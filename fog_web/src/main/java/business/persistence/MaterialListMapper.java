package business.persistence;

import business.entities.*;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;

public class MaterialListMapper {
   Database database;

   public MaterialListMapper(Database database) {
      this.database = database;
   }


   public ArrayList<WoodPiece> getAllWoodPieces() throws UserException {
      ArrayList<WoodPiece> woodPieces = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                "FROM wood_pieces " +
                       "INNER JOIN units ON wood_pieces.fk_unit_id = units.unit_id " +
                "ORDER BY wood_pieces_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int productId = rs.getInt("wood_piece_id");
               String productName = rs.getString("productName");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";
               int width = rs.getInt("width");
               int thickness = rs.getInt("thickness");
               int length = rs.getInt("length");

               WoodPiece woodPiece = new WoodPiece(
                  productId, productName, unit, price, desc, width, thickness, length
               );

               woodPieces.add(woodPiece);
            } while (rs.next());

            return woodPieces;
         } else {
            throw new UserException("No data on wood pieces from the database could be retrieved at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<RoofMaterialOption> getAllRoofMaterial() throws UserException{
      ArrayList<RoofMaterialOption> roofMaterials = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                "FROM ccp_roof_material_options " +
                  "INNER JOIN units ON ccp_roof_material_options.fk_unit_id = units.unit_id " +
                "ORDER BY roofMaterial_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int productId = rs.getInt("roofMaterial_id");
               String productName = rs.getString("material");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";
               int roofType  = rs.getInt("fk_roofType_id");
               int materialWidth = rs.getInt("materialWidth");
               int materialLength = rs.getInt("materialLength");

               RoofMaterialOption roofMaterial = new RoofMaterialOption(
                  productId, productName, unit, price, desc, roofType, materialWidth, materialLength
               );

               roofMaterials.add(roofMaterial);
            } while (rs.next());

            return roofMaterials;
         } else {
            throw new UserException("No data on roof materials from the database could be retrieved at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<Screw> getAllScrews() throws UserException {
      ArrayList<Screw> screws = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                "FROM screws " +
                     "INNER JOIN units ON screws.fk_unit_id = units.unit_id " +
                "ORDER BY screw_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int productId = rs.getInt("screw_id");
               String productName = rs.getString("productName");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";
               int piecesPrPack = rs.getInt("PiecesPrPack");

               Screw screw = new Screw(
                      productId, productName, unit, price, desc, piecesPrPack
               );

               screws.add(screw);
            } while (rs.next());

            return screws;
         } else {
            throw new UserException("No data on screw materials from the database could be retrieved at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<WoodConnector> getAllWoodConnectors() throws UserException{
      ArrayList<WoodConnector> woodConnectors = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                 "FROM wood_connectors " +
                     "INNER JOIN units ON wood_connectors.fk_unit_id = units.unit_id " +
                 "ORDER BY wood_connector_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int productId = rs.getInt("wood_connector_id");
               String productName = rs.getString("material");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";

               WoodConnector woodConnector = new WoodConnector(
                      productId, productName, unit, price, desc
               );

               woodConnectors.add(woodConnector);
            } while (rs.next());

            return woodConnectors;
         } else {
            throw new UserException("No data on wood connectors from the database could be retrieved at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public CTSCladdingOption getCladdingById(int claddingId) throws UserException{
      CTSCladdingOption cladding = null;

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                "FROM cts_cladding_options " +
                  "INNER JOIN units ON cts_cladding_options.fk_unit_id = units.unit_id " +
                "WHERE cts_cladding_id = ?";

         try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, claddingId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
               int productId = rs.getInt("cts_cladding_id");
               String productName = rs.getString("cladding");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";
               int thickness = rs.getInt("thickness");
               int width = rs.getInt("width");
               int length = rs.getInt("length");

               cladding = new CTSCladdingOption(
                  productId, productName, unit, price, desc, thickness, width, length
               );

               return cladding;
            } else {
               throw new UserException("Could not validate user");
            }
         } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

   public ArrayList<CTSDoorComponent> getAllDoorComponents() throws UserException{
      ArrayList<CTSDoorComponent> doorComponents = new ArrayList<>();

      try (Connection connection = database.connect()) {
         String sql =
                "SELECT * " +
                "FROM cts_door_components " +
                    "INNER JOIN units ON cts_door_components.fk_unit_id = units.unit_id " +
                "ORDER BY door_component_id";

         Statement statement = connection.createStatement();
         ResultSet rs = statement.executeQuery(sql);

         if (rs.next()) {
            do {
               int productId = rs.getInt("wood_connector_id");
               String productName = rs.getString("material");
               String unit = rs.getString("unit");
               double price = rs.getDouble("price");
               String desc = "";

               CTSDoorComponent doorComponent = new CTSDoorComponent(
                      productId, productName, unit, price, desc
               );

               doorComponents.add(doorComponent);
            } while (rs.next());

            return doorComponents;
         } else {
            throw new UserException("No data on door components from the database could be retrieved at the moment");
         }
      } catch (SQLException ex) {
         throw new UserException("Connection to database could not be established");
      }
   }

}
