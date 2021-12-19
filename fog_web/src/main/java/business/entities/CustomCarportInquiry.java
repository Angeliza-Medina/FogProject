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
   private String note;

  // Constructor used to create an inquiry and send it to the db
  public CustomCarportInquiry(int userId, CustomCarport customCarport, ContactInfo contactInfo, String note) {
     this.userId = userId;
     this.contactInfo = contactInfo;
     this.customCarport = customCarport;
     this.note = note;
  }

  // Constructor used when getting inquiries from the db to ccpiList.jsp
  public CustomCarportInquiry(int ccpiId, LocalDate inquiryDate, String status, CustomCarport customCarport){
     this.ccpiId = ccpiId;
     this.inquiryDate = inquiryDate;
     this.status = status;
     this.customCarport = customCarport;
  }

  public CustomCarportInquiry(int ccpiId, LocalDate inquiryDate, String status, String note,
                              ContactInfo contactInfo, CustomCarport customCarport){
     this.ccpiId = ccpiId;
     this.inquiryDate = inquiryDate;
     this.status = status;
     this.note = note;
     this.contactInfo = contactInfo;
     this.customCarport = customCarport;
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

   public String getNote() {
      return note;
   }

   public void setNote(String note) {
      this.note = note;
   }

}
