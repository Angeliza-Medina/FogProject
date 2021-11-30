package business.entities;

public class RoofAngleOption {
   private int id;
   private int angle;

   public RoofAngleOption(int id, int angle) {
      this.id = id;
      this.angle = angle;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getAngle() {
      return angle;
   }

   public void setAngle(int angle) {
      this.angle = angle;
   }

}
