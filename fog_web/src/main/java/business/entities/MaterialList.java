package business.entities;

import java.util.ArrayList;

public class MaterialList {
   private ArrayList<WoodPiece> woodPieces;
   private CTSCladdingOption cladding;
   private ArrayList<RoofMaterialOption> roofMaterials;
   private ArrayList<Screw> screws;
   private ArrayList<WoodConnector> woodConnectors;
   private ArrayList<CTSDoorComponent> doorComponents;

   public MaterialList(
          ArrayList<WoodPiece> woodPieces, CTSCladdingOption cladding, ArrayList<RoofMaterialOption> roofMaterials,
          ArrayList<Screw> screws, ArrayList<WoodConnector> woodConnectors, ArrayList<CTSDoorComponent> doorComponents)
   {
      this.woodPieces = woodPieces;
      this.cladding = cladding;
      this.roofMaterials = roofMaterials;
      this.screws = screws;
      this.woodConnectors = woodConnectors;
      this.doorComponents = doorComponents;
   }

   public ArrayList<WoodPiece> getWoodPieces() {
      return woodPieces;
   }

   public void setWoodPieces(ArrayList<WoodPiece> woodPieces) {
      this.woodPieces = woodPieces;
   }

   public CTSCladdingOption getCladding() {
      return cladding;
   }

   public void setCladding(CTSCladdingOption cladding) {
      this.cladding = cladding;
   }

   public ArrayList<RoofMaterialOption> getRoofMaterials() {
      return roofMaterials;
   }

   public void setRoofMaterials(ArrayList<RoofMaterialOption> roofMaterials) {
      this.roofMaterials = roofMaterials;
   }

   public ArrayList<Screw> getScrews() {
      return screws;
   }

   public void setScrews(ArrayList<Screw> screws) {
      this.screws = screws;
   }

   public ArrayList<WoodConnector> getWoodConnectors() {
      return woodConnectors;
   }

   public void setWoodConnectors(ArrayList<WoodConnector> woodConnectors) {
      this.woodConnectors = woodConnectors;
   }

   public ArrayList<CTSDoorComponent> getDoorComponents() {
      return doorComponents;
   }

   public void setDoorComponents(ArrayList<CTSDoorComponent> doorComponents) {
      this.doorComponents = doorComponents;
   }
}
