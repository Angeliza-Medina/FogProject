package business.entities;

public class CTSLengthOption {
   int id;
   int length;

   public CTSLengthOption(int id, int length) {
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
