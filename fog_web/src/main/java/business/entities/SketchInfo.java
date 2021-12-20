package business.entities;

public class SketchInfo {
   private CustomCarport carport;
   private int rafterThickness;

   public SketchInfo(CustomCarport carport, int rafterThickness) {
      this.carport = carport;
      this.rafterThickness = rafterThickness;
   }

   public CustomCarport getCarport() {
      return carport;
   }

   public void setCarport(CustomCarport carport) {
      this.carport = carport;
   }

   public int getRafterThickness() {
      return rafterThickness;
   }

   public void setRafterThickness(int rafterThickness) {
      this.rafterThickness = rafterThickness;
   }

}
