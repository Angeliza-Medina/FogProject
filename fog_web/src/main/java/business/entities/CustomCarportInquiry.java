package business.entities;

import java.time.LocalDate;

public class CustomCarportInquiry {

   // - Carport dimensions -
   private int ccpiId;
   private LocalDate inquiryDate;
   private String status;
  private int userId;
  private ContactInfo contactInfo;
  private CustomCarport customCarport;
  private Toolshed toolshed;
  private String note;

  // Constructor used to create an inquiry and send it to the db
  public CustomCarportInquiry(int userId, CustomCarport customCarport, ContactInfo contactInfo, Toolshed toolshed, String note) {
     this.userId = userId;
     this.contactInfo = contactInfo;
     this.customCarport = customCarport;
     this.toolshed = toolshed;
     this.note = note;
  }

  // Constructor used when getting inquiries from the db to ccpiList.jsp
  public CustomCarportInquiry(int ccpiId, LocalDate inquiryDate, String status, CustomCarport customCarport, Toolshed toolshed){
     this.ccpiId = ccpiId;
     this.inquiryDate = inquiryDate;
     this.status = status;
     this.customCarport = customCarport;
     this.toolshed = toolshed;
  }

  public CustomCarportInquiry(int inquiry_id, LocalDate inquiryDate, String inquiryStatus, String note,
                              ContactInfo contactInfo, CustomCarport customCarport, Toolshed toolshed){
     this.ccpiId = inquiry_id;
     this.inquiryDate = inquiryDate;
     this.status = inquiryStatus;
     this.note = note;
     this.contactInfo = contactInfo;
     this.customCarport = customCarport;
     this.toolshed = toolshed;
  }


   public int getCcpiId() {
      return ccpiId;
   }

   public void setCcpiId(int ccpiId) {
      this.ccpiId = ccpiId;
   }

   public LocalDate getInquiryDate() {
      return inquiryDate;
   }

   public void setInquiryDate(LocalDate inquiryDate) {
      this.inquiryDate = inquiryDate;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public int getUserId() {
      return userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }

   public ContactInfo getContactInfo() {
      return contactInfo;
   }

   public void setContactInfo(ContactInfo contactInfo) {
      this.contactInfo = contactInfo;
   }

   public CustomCarport getCustomCarport() {
      return customCarport;
   }

   public void setCustomCarport(CustomCarport customCarport) {
      this.customCarport = customCarport;
   }

   public Toolshed getToolshed() {
        return toolshed;
    }

   public void setToolshed(Toolshed toolshed) {
        this.toolshed = toolshed;
    }

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

}
