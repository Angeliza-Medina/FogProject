package business.entities;

public class CustomCarportInquiry {

   // - Carport dimensions -
  private int userId;
  private  int carportWidth;
  private  int carportLength;
  private  int carportHeight;
  private int roofTypeId;
  private  int roofAngle;
  private int roofMaterialId;
  private ContactInfo contactInfo;
  private ToolshedInfo toolshedInfo;
  private String note;


  public CustomCarportInquiry(
         int userId, int carportWidth, int carportLength, int carportHeight, int roofTypeId, int roofAngle,
         int roofMaterialId, ContactInfo contactInfo, ToolshedInfo toolshedInfo, String note) {
    this.userId = userId;
     this.carportWidth = carportWidth;
     this.carportLength = carportLength;
     this.carportHeight = carportHeight;
    this.roofTypeId = roofTypeId;
     this.roofAngle = roofAngle;
    this.roofMaterialId = roofMaterialId;
     this.contactInfo = contactInfo;
     this.toolshedInfo = toolshedInfo;
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

   public int getRoofTypeId() {
      return roofTypeId;
   }

   public void setRoofTypeId(int roofTypeId) {
      this.roofTypeId = roofTypeId;
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

    public ToolshedInfo getToolshedInfo() {
        return toolshedInfo;
    }

    public void setToolshedInfo(ToolshedInfo toolshedInfo) {
        this.toolshedInfo = toolshedInfo;
    }

    public int getRoofMaterialId() {
        return roofMaterialId;
    }

    public void setRoofMaterialId(int roofMaterialId) {
        this.roofMaterialId = roofMaterialId;
    }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }
}
