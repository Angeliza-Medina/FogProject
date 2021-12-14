package business.entities;

public class CustomCarport {
   private int id;
   private int width;
   private int length;
   private int height;
   private boolean hasMiddlePost;
   private double rafterSpacing;
   private int roofTypeId;
   private int roofAngle;
   private int roofMaterialId;
   private Toolshed toolshed;
   private double price;

   // Constructor used to create new data to the database
   public CustomCarport(int width, int length, int height, int roofTypeId, int roofAngle, int roofMaterialId, Toolshed toolshed) {
      this.width = width;
      this.length = length;
      this.height = height;
      this.roofTypeId = roofTypeId;
      this.roofAngle = roofAngle;
      this.roofMaterialId = roofMaterialId;
      this.toolshed = toolshed;
   }

   // Constructor used to get data from the db to us in ccpiList.jsp
   public CustomCarport (int id, int width, int length, int height, Toolshed toolshed){
      this.id = id;
      this.width = width;
      this.length = length;
      this.height = height;
      this.toolshed = toolshed;
   }


   // Constructor used to get data from the db to use in ccpMaterialCalculator.jsp
   public CustomCarport(
          int id, int width, int length, int height, boolean hasMiddlePost, double rafterSpacing, int roofTypeId,
          int roofAngle, int roofMaterialId, Toolshed toolshed, double price)
   {
      this.id = id;
      this.width = width;
      this.length = length;
      this.height = height;
      this.hasMiddlePost = hasMiddlePost;
      this.rafterSpacing = rafterSpacing;
      this.roofTypeId = roofTypeId;
      this.roofAngle = roofAngle;
      this.roofMaterialId = roofMaterialId;
      this.toolshed = toolshed;
      this.price = price;
   }


   // Constructor used for calculations
   public CustomCarport (int width, int length, int height, boolean hasMiddlePost, double rafterSpacing, int roofTypeId, int roofMaterialId, int roofAngle){
      this.width = width;
      this.length = length;
      this.height = height;
      this.hasMiddlePost = hasMiddlePost;
      this.rafterSpacing = rafterSpacing;
      this.roofTypeId = roofTypeId;
      this.roofMaterialId = roofMaterialId;
      this.roofAngle = roofAngle;
   }


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

   public int getLength() {
      return length;
   }

   public void setLength(int length) {
      this.length = length;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }

   public boolean isHasMiddlePost() {
      return hasMiddlePost;
   }

   public void setHasMiddlePost(boolean hasMiddlePost) {
      this.hasMiddlePost = hasMiddlePost;
   }

   public double getRafterSpacing() {
      return rafterSpacing;
   }

   public void setRafterSpacing(double rafterSpacing) {
      this.rafterSpacing = rafterSpacing;
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

   public int getRoofMaterialId() {
      return roofMaterialId;
   }

   public void setRoofMaterialId(int roofMaterialId) {
      this.roofMaterialId = roofMaterialId;
   }

   public Toolshed getToolshed() {
      return toolshed;
   }

   public void setToolshed(Toolshed toolshed) {
      this.toolshed = toolshed;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }
}
