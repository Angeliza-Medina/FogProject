package business.entities;

public class CustomCarportInquiry {

   // - Carport dimensions -
  private int userId;
  private  int carportWidth;
  private  int carportLength;
  private  int carportHeight;
   private int roofType;
  private  int roofAngle;
  private int roofMaterial;
  private ContactInfo contactInfo;
  private ToolInfo toolInfo;
  private String note;


    public CustomCarportInquiry(
           int userId, int carportWidth, int carportLength, int carportHeight, int roofType, int roofAngle,
           int roofMaterial, ContactInfo contactInfo, ToolInfo toolInfo, String note) {
       this.userId = userId;
        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
       this.roofType = roofType;
        this.roofAngle = roofAngle;
       this.roofMaterial = roofMaterial;
        this.contactInfo = contactInfo;
        this.toolInfo = toolInfo;
        this.note = note;
    }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

    public int getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(int carportWidth) {
        this.carportWidth = carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(int carportLength) {
        this.carportLength = carportLength;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public void setCarportHeight(int carportHeight) {
        this.carportHeight = carportHeight;
    }

      public int getRoofType() {
         return roofType;
      }

      public void setRoofType(int roofType) {
         this.roofType = roofType;
      }

    public int getRoofAngle() {
        return roofAngle;
    }

    public void setRoofAngle(int roofAngle) {
        this.roofAngle = roofAngle;
    }

   public ContactInfo getContactInfo() {
      return contactInfo;
   }

   public void setContactInfo(ContactInfo contactInfo) {
      this.contactInfo = contactInfo;
   }

    public ToolInfo getToolInfo() {
        return toolInfo;
    }

    public void setToolInfo(ToolInfo toolInfo) {
        this.toolInfo = toolInfo;
    }

    public int getRoofMaterial() {
        return roofMaterial;
    }

    public void setRoofMaterial(int roofMaterial) {
        this.roofMaterial = roofMaterial;
    }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }
}
