package business.entities;

public class RoofMaterialOption {
   private int id;
   private int roofType;
   private String material;
   private double materialWidth;
   private double materialLength;
   private double price;

   public RoofMaterialOption(int id, int roofType, String material, double materialWidth, double materialLength, double price) {
      this.id = id;
      this.roofType = roofType;
      this.material = material;
      this.materialWidth = materialWidth;
      this.materialLength = materialLength;
      this.price = price;
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

   public double getMaterialWidth() {
      return materialWidth;
   }

   public void setMaterialWidth(double materialWidth) {
      this.materialWidth = materialWidth;
   }

   public double getMaterialLength() {
      return materialLength;
   }

   public void setMaterialLength(double materialLength) {
      this.materialLength = materialLength;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
