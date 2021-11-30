package business.entities;

public class CTSWidthOption {

   private int id;
   private int width;

   public CTSWidthOption(int id, int width) {
      this.id = id;
      this.width = width;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

}
