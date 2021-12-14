package business.entities;

public class WoodConnector extends MaterialListComponent{
   private int width;
   private int thickness;
   private int length;

   public WoodConnector(int productId, String productName, String unit, double price, String desc, int width, int thickness, int length) {
      super(productId, productName, unit, price, desc);
      this.width = width;
      this.thickness = thickness;
      this.length = length;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getThickness() {
      return thickness;
   }

   public void setThickness(int thickness) {
      this.thickness = thickness;
   }

   public int getLength() {
      return length;
   }

   public void setLength(int length) {
      this.length = length;
   }
}