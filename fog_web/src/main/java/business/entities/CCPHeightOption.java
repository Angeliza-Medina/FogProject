package business.entities;

public class CCPHeightOption {
   private int id;
   private int height;

   public CCPHeightOption(int id, int height) {
      this.id = id;
      this.height = height;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

}
