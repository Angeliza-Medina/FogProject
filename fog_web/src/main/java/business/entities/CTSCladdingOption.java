package business.entities;

public class CTSCladdingOption {
   int id;
   String cladding;
   double thickness;
   double width;
   double price;

   public CTSCladdingOption(int id, String cladding, double thickness, double width, double price){
      this.id = id;
      this.cladding = cladding;
      this.thickness = thickness;
      this.width = width;
      this.price = price;
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getCladding() {
      return cladding;
   }

   public void setCladding(String cladding) {
      this.cladding = cladding;
   }

   public double getThickness() {
      return thickness;
   }

   public void setThickness(double thickness) {
      this.thickness = thickness;
   }

   public double getWidth() {
      return width;
   }

   public void setWidth(double width) {
      this.width = width;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
