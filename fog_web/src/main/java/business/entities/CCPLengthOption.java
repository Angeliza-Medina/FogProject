package business.entities;

public class CCPLengthOption {
   private int id;
   private int length;

   public CCPLengthOption(int id, int length){
      this.id = id;
      this.length = length;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getLength() {
      return length;
   }

   public void setLength(int length) {
      this.length = length;
   }

}
