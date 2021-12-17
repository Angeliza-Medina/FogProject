package business.entities;

public class CTSCladdingOption extends MaterialListComponent{
   private int id;
   private String cladding;
   private int thickness;
   private int width;
   private int length;

   // Constructor used for getting data from db to use on customer pages and admin calc. page
   public CTSCladdingOption(int id, String cladding, String unit, double price, String desc) {
      super(id, cladding, unit, price, desc);
      this.id = id;
      this.cladding = cladding;
   }

   // Constructor used for getting data from db to use on calc. algorithms
   public CTSCladdingOption(
          int productId, String productName, String unit, double price, String desc,
          int thickness, int width, int length)
   {
      super(productId, productName, unit, price, desc);
      this.thickness = thickness;
      this.width = width;
      this.length = length;
   }


   public int getId() {
      return super.getProductId();
   }

   public void setId(int id) {
      super.setProductId(id);
   }

   public String getCladding() {
      return cladding;
   }

   public void setCladding(String cladding) {
      this.cladding = cladding;
   }

   public int getThickness() {
      return thickness;
   }

   public void setThickness(int thickness) {
      this.thickness = thickness;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getLength() {
      return length;
   }

   public void setLength(int length) {
      this.length = length;
   }
}
