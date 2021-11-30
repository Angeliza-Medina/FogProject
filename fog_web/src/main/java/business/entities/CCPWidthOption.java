package business.entities;

public class CCPWidthOption {
   private int id;
   private int width;

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

   public CCPWidthOption(int id, int width) {
      this.id = id;
      this.width = width;
   }

}
