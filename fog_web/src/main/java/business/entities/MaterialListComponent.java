package business.entities;

public class MaterialListComponent {
   private int productId;
   private String productName;
   private int amount;
   private String unit;
   private double price;
   private String desc;

   public MaterialListComponent(int productId, String productName, String unit, double price, String desc) {
      this.productId = productId;
      this.productName = productName;
      this.unit = unit;
      this.price = price;
      this.desc = desc;
   }

   public int getProductId() {
      return productId;
   }

   public void setProductId(int productId) {
      this.productId = productId;
   }

   public String getProductName() {
      return productName;
   }

   public void setProductName(String productName) {
      this.productName = productName;
   }

   public int getAmount() {
      return amount;
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public String getUnit() {
      return unit;
   }

   public void setUnit(String unit) {
      this.unit = unit;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public String getDesc() {
      return desc;
   }

   public void setDesc(String desc) {
      this.desc = desc;
   }

}
