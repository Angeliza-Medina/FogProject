package business.entities;

public class RoofMaterialOption {
   private int id;
   private int roofType;
   private String material;

   public RoofMaterialOption(int id, int roofType, String material) {
      this.id = id;
      this.roofType = roofType;
      this.material = material;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getRoofType() {
      return roofType;
   }

   public void setRoofType(int roofType) {
      this.roofType = roofType;
   }

   public String getMaterial() {
      return material;
   }

   public void setMaterial(String material) {
      this.material = material;
   }

}
