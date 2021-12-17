package business.entities;

public class RoofMaterialOption extends MaterialListComponent{
   private int roofType;
   private int materialWidth;
   private int materialLength;

//   public RoofMaterialOption(int id, int roofType, String material, int materialWidth, int materialLength, double price) {
//      this.id = id;
//      this.roofType = roofType;
//      this.material = material;
//      this.materialWidth = materialWidth;
//      this.materialLength = materialLength;
//      this.price = price;
//   }

   public RoofMaterialOption(
          int productId, String productName, String unit, double price, String desc,
          int roofType, int materialWidth, int materialLength)
   {
      super(productId, productName, unit, price, desc);
      this.roofType = roofType;
      this.materialWidth = materialWidth;
      this.materialLength = materialLength;
   }


   public int getId() {
      return super.getProductId();
   }

   public int getRoofType() {
      return roofType;
   }

   public void setRoofType(int roofType) {
      this.roofType = roofType;
   }

   public String getMaterial() {
      return super.getProductName();
   }

   public int getMaterialWidth() {
      return materialWidth;
   }

   public void setMaterialWidth(int materialWidth) {
      this.materialWidth = materialWidth;
   }

   public int getMaterialLength() {
      return materialLength;
   }

   public void setMaterialLength(int materialLength) {
      this.materialLength = materialLength;
   }

}
